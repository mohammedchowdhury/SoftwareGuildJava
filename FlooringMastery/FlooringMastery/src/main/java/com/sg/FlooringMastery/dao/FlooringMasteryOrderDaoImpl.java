package com.sg.FlooringMastery.dao;

import com.sg.FlooringMastery.dto.Order;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author mohammedchowdhury
 */
//com.sg.FlooringMastery.dao.FlooringMasteryOrderDaoImpl
public class FlooringMasteryOrderDaoImpl implements FlooringMasteryOrderDao {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");
    private Map<LocalDate, Map<Integer, Order>> orders = new HashMap<LocalDate, Map<Integer, Order>>();

    private final String DELIMITER = ",";
    private String ORDERS_FILE = "FileData/Orders";
    private int largestOrderNumber = 0;

    public FlooringMasteryOrderDaoImpl(String path) throws FlooringMasteryPersistenceException {
        this.ORDERS_FILE = path;
        setUp();

    }

    public FlooringMasteryOrderDaoImpl() {
    }

    public List<Order> getOrders(LocalDate date) throws FlooringMasteryPersistenceException {
        loadOrders();
        if (orders.containsKey(date)) {
            return new ArrayList(orders.get(date).values());
        }
        return null;
    }

    public Order addOrder(Order newOrder) throws FlooringMasteryPersistenceException {
        loadOrders();
        Order returnOrder = null;
        if (orders.containsKey(newOrder.getOrderDate())) {
            orders.get(newOrder.getOrderDate()).put(newOrder.getOrderNumber(), newOrder);
        } else {
            Map<Integer, Order> tempOrder = new HashMap<Integer, Order>();
            tempOrder.put(newOrder.getOrderNumber(), newOrder);
            orders.put(newOrder.getOrderDate(), tempOrder);
        }
        writeOrder();
        returnOrder = this.orders.get(newOrder.getOrderDate()).get(newOrder.getOrderNumber());
        return returnOrder;
    }

    public Order editOrder(Order newOrder) throws FlooringMasteryPersistenceException {
        loadOrders();
        Order returnOrder = null;
        if (orders.containsKey(newOrder.getOrderDate())) {
            orders.get(newOrder.getOrderDate()).put(newOrder.getOrderNumber(), newOrder);
        } else {
            Map<Integer, Order> tempOrder = new HashMap<Integer, Order>();
            tempOrder.put(newOrder.getOrderNumber(), newOrder);
            orders.put(newOrder.getOrderDate(), tempOrder);
        }
        writeOrder();
        returnOrder = this.orders.get(newOrder.getOrderDate()).get(newOrder.getOrderNumber());
        return returnOrder;
    }

    public Order removeOrder(LocalDate date, int orderNumber) throws FlooringMasteryPersistenceException {
        loadOrders();
        Map<Integer, Order> dayOrder = orders.get(date);
        if (dayOrder == null || dayOrder.size() == 0) {
            return null;
        }

        Order order = dayOrder.get(orderNumber);

        if (order != null) {
            if (dayOrder.size() == 1) {
                orders.remove(date);
                //remove the empty file

                removeFile(getOrderDateToString(date));
            } else {
                dayOrder.remove(orderNumber);
            }
        }
        writeOrder();
        return order;
    }

    private String getOrderDateToString(LocalDate orderDate) {
        return orderDate.format(formatter);
    }

    public Map<LocalDate, Map<Integer, Order>> getAllOrders() throws FlooringMasteryPersistenceException {
        loadOrders();
        return orders;
    }

    private void removeFile(String date) {
        String path = ORDERS_FILE + "/Orders_";
        path = path + date + ".txt";
        File myObj = new File(path);
        myObj.delete();
    }

    public void setUp() throws FlooringMasteryPersistenceException {
        loadOrders();
    }

    private Order unmarshallOrders(String productAsText, String dateInString) {
        String[] orderTokens = productAsText.split(DELIMITER);
        Order order = new Order(orderTokens[0], orderTokens[1], orderTokens[2], orderTokens[3], orderTokens[4], orderTokens[5], orderTokens[6], orderTokens[7]);
        order.setOrderDate(dateInString);
        return order;
    }

    private void loadOrders() throws FlooringMasteryPersistenceException {
        Scanner scanner = null;
        File folder = new File(ORDERS_FILE);
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {

            String ORDER = listOfFiles[i].getPath();

            if (ORDER.equals("FileData/Orders/.DS_Store") || ORDER.equals("FileData/Testing/TestingOrders/.DS_Store")) {
                continue;
            }

            String[] clean = ORDER.split("_");
            clean = clean[1].split("\\.");
            String dateInString = clean[0];

            try {
                scanner = new Scanner(new BufferedReader(new FileReader(ORDER)));
            } catch (FileNotFoundException e) {
                throw new FlooringMasteryPersistenceException("-_- Could not load orders data into memory.", e);
            }

            String currentLine;
            Order currentOrder;
            Map<Integer, Order> tempOrder = new HashMap<Integer, Order>();

            while (scanner.hasNextLine()) {
                currentLine = scanner.nextLine();
                currentOrder = unmarshallOrders(currentLine, dateInString);
                tempOrder.put(currentOrder.getOrderNumber(), currentOrder);

                if (currentOrder.getOrderNumber() > largestOrderNumber) {
                    largestOrderNumber = currentOrder.getOrderNumber();
                }
            }

            LocalDate ld = LocalDate.parse(dateInString, formatter);

            orders.put(ld, tempOrder); ///made change here
            scanner.close();
        }
    }

    private void writeOrder() throws FlooringMasteryPersistenceException {
        PrintWriter out;

        List<LocalDate> dates = new ArrayList(orders.keySet());

        // String PATH = "FileData/Orders/Orders_";
        String PATH = this.ORDERS_FILE + "/Orders_";

        for (int i = 0; i < dates.size(); i++) {
            String tempPath = PATH + dates.get(i).format(formatter) + ".txt";

            try {
                out = new PrintWriter(new FileWriter(tempPath));
            } catch (IOException e) {
                throw new FlooringMasteryPersistenceException("Could not save order data.", e);
            }

            String orderAsText;
            List<Order> orderList = new ArrayList(orders.get(dates.get(i)).values());

            for (Order currentOrder : orderList) {
                orderAsText = currentOrder.orderToStringOrderFile();
                out.println(orderAsText);
                out.flush();
            }
            out.close();
        }
    }
}
