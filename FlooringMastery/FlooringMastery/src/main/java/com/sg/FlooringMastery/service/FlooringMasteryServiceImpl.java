package com.sg.FlooringMastery.service;

import com.sg.FlooringMastery.dao.FlooringMasteryAuditDaoFile;
import com.sg.FlooringMastery.dao.FlooringMasteryExportDao;
import com.sg.FlooringMastery.dao.FlooringMasteryOrderDao;
import com.sg.FlooringMastery.dao.FlooringMasteryPersistenceException;
import com.sg.FlooringMastery.dao.FlooringMasteryProductDao;

import com.sg.FlooringMastery.dao.FlooringMasteryTaxesDao;
import com.sg.FlooringMastery.dto.Order;
import com.sg.FlooringMastery.dto.Product;
import com.sg.FlooringMastery.dto.Tax;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FlooringMasteryServiceImpl implements FlooringMasteryService {

    private FlooringMasteryOrderDao orderDao;
    private FlooringMasteryProductDao productDao;
    private FlooringMasteryTaxesDao taxDao;
    private FlooringMasteryExportDao exportDao;
    private FlooringMasteryAuditDaoFile auditDao;

    public FlooringMasteryServiceImpl(FlooringMasteryOrderDao orderDao, FlooringMasteryProductDao productDao, FlooringMasteryTaxesDao taxDao, FlooringMasteryExportDao exportDao, FlooringMasteryAuditDaoFile auditDao) {
        this.orderDao = orderDao;
        this.productDao = productDao;
        this.taxDao = taxDao;
        this.exportDao = exportDao;
        this.auditDao = auditDao;

    }

    public List<Order> getOrders(LocalDate date) throws NoOrderException, FlooringMasteryPersistenceException {
        List<Order> orders = orderDao.getOrders(date);
        if (orders == null || orders.size() == 0) {
            throw new NoOrderException("No Orders Found for Date : " + date);
        }
        return orders;
    }

    public List<Tax> getTaxes() throws FlooringMasteryPersistenceException, NoTaxesFoundException {
        List<Tax> taxes = taxDao.getTaxes();
        if (taxes.size() == 0 || taxes == null) {
            throw new NoTaxesFoundException("No Tax data found");
        }
        return taxes;
    }

    public List<Product> getProducts() throws FlooringMasteryPersistenceException, NoProductsFoundException {
        List<Product> products = productDao.getProducts();
        if (products.size() == 0 || products == null) {
            throw new NoProductsFoundException("Empty inventory");
        }

        return products;
    }

    public void setUp() throws FlooringMasteryPersistenceException {
        orderDao.setUp();
    }

    public Order addOrder(Order tempOrder) throws FlooringMasteryPersistenceException, InvalidOrderException {
        validateOrder(tempOrder);
        return orderDao.addOrder(tempOrder);
    }

    public Order editOrder(Order tempOrder) throws FlooringMasteryPersistenceException, InvalidOrderException {
        validateOrder(tempOrder);
        return orderDao.addOrder(tempOrder);
    }

    public Order getOrder(LocalDate date, int orderNumber) throws NoOrderException, FlooringMasteryPersistenceException {
        List<Order> orders = getOrders(date);
        if (orders == null || orders.size() == 0) {
            throw new NoOrderException("No Orders Found for Date : " + date);
        }
        Order order = null;
        List<Order> returnDate = orders.stream()
                .filter((p) -> p.getOrderNumber() == orderNumber)
                .collect(Collectors.toList());
        if (returnDate.size() > 0) {
            order = returnDate.get(0);
        }
        if (order != null) {
            return order;
        }

        if (order == null) {
            throw new NoOrderException("No Orders Found for order number : " + orderNumber);
        }
        return null;
    }

    public Order removeOrder(LocalDate date, int orderNumber) throws NoOrderException, FlooringMasteryPersistenceException {

        Order order = orderDao.removeOrder(date, orderNumber);

        if (order == null) {
            throw new NoOrderException("No Orders Found for order number / Date : " + orderNumber + " " + date);
        }
        //writeToAudit(order.oderToStringToView() + " Was Successfully removed");
        return order;
    }

    public int exportData() throws NoOrderException, FlooringMasteryPersistenceException {
        Map<LocalDate, Map<Integer, Order>> orders = orderDao.getAllOrders();
        if (orders.size() == 0) {
            throw new NoOrderException("No Orders Found");
        }
        return exportDao.exportData(orders);
    }

    private void validateOrder(Order order) throws InvalidOrderException {
        if (order.getCustomerName() == null
                || order.getState() == null
                || order.getTaxRate() == null
                || order.getArea() == null
                || order.getProductType() == null
                || order.getLaborCostPerSquareFoot() == null
                || order.getCostPerSquareFoot() == null
                || order.getMaterialCost() == null
                || order.getLaborCost() == null
                || order.getTax() == null
                || order.getTotal() == null
                || order.getOrderDate() == null) {
            throw new InvalidOrderException("Invalid order: Missing Data");

        }

    }

    private void writeToAudit(String message) throws FlooringMasteryPersistenceException {
        auditDao.writeAuditEntry(message);
    }
}
