package com.sg.FlooringMastery.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 *
 * @author mohammedchowdhury
 */
public class Order {

    private static int orderCounter = 0;

    private int orderNumber = 0;
    private String customerName;

    //private String state;
    //private BigDecimal taxRate;
    private BigDecimal area;

    private Tax pickedTax;
    private Product pickedProduct;

    //private String productType;
    //private BigDecimal costPerSquareFoot;
    //private BigDecimal laborCostPerSquareFoot;
    // calculated values below 
    //MaterialCost = (Area * CostPerSquareFoot)
    private BigDecimal materialCost;
    //LaborCost = (Area * LaborCostPerSquareFoot)
    private BigDecimal laborCost;
    //Tax = (MaterialCost + LaborCost) * (TaxRate/100)
    //Tax rates are stored as whole numbers
    private BigDecimal tax;
    //Total = (MaterialCost + LaborCost + Tax)
    private BigDecimal total;
    private LocalDate orderDate;
    private String orderDateAsString;
    private String exportDateasString;

    //used for loading the items from a file
    public Order(String orderNumber, String customerName, String state, String taxRate, String productType, String area, String costPerSquareFoot, String laborCostPerSquareFoot) {
        this.orderNumber = Integer.parseInt(orderNumber);

        if (this.orderNumber > this.orderCounter) {
            this.orderCounter = this.orderNumber;
        }

        this.pickedTax = new Tax(state, taxRate);
        this.pickedProduct = new Product(productType, costPerSquareFoot, laborCostPerSquareFoot);

        this.customerName = customerName;

        // this.productType = productType;
        this.area = new BigDecimal(area);
        //this.costPerSquareFoot = new BigDecimal(costPerSquareFoot);
        //this.laborCostPerSquareFoot = new BigDecimal(laborCostPerSquareFoot);

        //MaterialCost = (Area * CostPerSquareFoot)
        this.materialCost = this.area.multiply(this.pickedProduct.getCostPerSquareFoot());
        //this.materialCost = this.area.multiply(this.costPerSquareFoot);
        this.materialCost = this.materialCost.setScale(2, BigDecimal.ROUND_HALF_UP);

        //LaborCost = (Area * LaborCostPerSquareFoot)
        //this.laborCost = this.area.multiply(this.laborCostPerSquareFoot);
        this.laborCost = this.area.multiply(this.pickedProduct.getLaborCostPerSquareFoot());
        this.laborCost = this.laborCost.setScale(2, BigDecimal.ROUND_HALF_UP);

        // Tax = (MaterialCost + LaborCost) * (TaxRate / 100) //Tax rates are stored as whole numbers
        this.tax = this.pickedTax.getTaxRate().divide(new BigDecimal("100"));
        this.tax = tax.multiply(this.materialCost.add(laborCost));
        this.tax = tax.setScale(2, BigDecimal.ROUND_HALF_UP);

        //Total = (MaterialCost + LaborCost + Tax)
        this.total = this.materialCost.add(this.laborCost);
        this.total = this.total.add(this.tax);
        this.total = this.total.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    //used to create newly created items
    public Order(String customerName, Tax selectedTax, String area, Product selectedProduct) {
        this.orderCounter++;
        this.orderNumber = this.orderCounter;

        this.customerName = customerName;
        this.customerName = this.customerName.replaceAll(",", "*");

        this.pickedTax = selectedTax;
        this.pickedProduct = selectedProduct;

        //this.taxRate = selectedTax.getTaxRate();
        //this.productType = selectedProduct.getProductType();
        this.area = new BigDecimal(area);
        //this.costPerSquareFoot = selectedProduct.getCostPerSquareFoot();
        //this.laborCostPerSquareFoot = selectedProduct.getLaborCostPerSquareFoot();

        //MaterialCost = (Area * CostPerSquareFoot)
        this.materialCost = this.area.multiply(this.pickedProduct.getCostPerSquareFoot());
        //this.materialCost = this.area.multiply(this.costPerSquareFoot);
        this.materialCost = this.materialCost.setScale(2, BigDecimal.ROUND_HALF_UP);

        //LaborCost = (Area * LaborCostPerSquareFoot)
        this.laborCost = this.area.multiply(this.pickedProduct.getLaborCostPerSquareFoot());
        this.laborCost = this.laborCost.setScale(2, BigDecimal.ROUND_HALF_UP);

        // Tax = (MaterialCost + LaborCost) * (TaxRate / 100) //Tax rates are stored as whole numbers
        this.tax = selectedTax.getTaxRate().divide(new BigDecimal("100"));
        this.tax = tax.multiply(this.materialCost.add(laborCost));
        this.tax = tax.setScale(2, BigDecimal.ROUND_HALF_UP);

        //Total = (MaterialCost + LaborCost + Tax)
        this.total = this.materialCost.add(this.laborCost);
        this.total = this.total.add(this.tax);
        this.total = this.total.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public void setOrderCounter(int orderCounter) {
        Order.orderCounter = orderCounter;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getCustomerName() {
        return this.customerName.replaceAll("\\*", ",");
    }

    public String getState() {
        return this.pickedTax.getState();
    }

    public BigDecimal getTaxRate() {
        return this.pickedTax.getTaxRate();
    }

    public BigDecimal getArea() {
        return area;
    }

    public String getProductType() {
        return this.pickedProduct.getProductType();
    }

    public BigDecimal getCostPerSquareFoot() {
        return pickedProduct.getCostPerSquareFoot();
    }

    public BigDecimal getLaborCostPerSquareFoot() {
        return pickedProduct.getLaborCostPerSquareFoot();
    }

    public BigDecimal getMaterialCost() {
        return materialCost;
    }

    public BigDecimal getLaborCost() {
        return laborCost;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");
        this.orderDate = LocalDate.parse(orderDate, formatter);

        this.orderDateAsString = orderDate;
        DateTimeFormatter exportformatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        exportDateasString = this.orderDate.format(exportformatter);
    }

    public String getOrderDateAsString() {
        return orderDateAsString;
    }

    public String getExportDateasString() {
        return exportDateasString;
    }

    //used for Export File
    public String orderToStringExportFile() {
        return this.orderNumber + "," + this.customerName + "," + this.pickedTax.getState() + "," + this.pickedTax.getTaxRate() + "," + this.pickedProduct.getProductType() + "," + area + "," + this.pickedProduct.getCostPerSquareFoot() + "," + this.pickedProduct.getLaborCostPerSquareFoot() + "," + materialCost + "," + laborCost + "," + tax + "," + total + "," + exportDateasString;
    }

    //used for orderFiles
    public String orderToStringOrderFile() {
        return this.orderNumber + "," + this.customerName + "," + this.pickedTax.getState() + "," + this.pickedTax.getTaxRate() + "," + this.pickedProduct.getProductType() + "," + area + "," + this.pickedProduct.getCostPerSquareFoot() + "," + this.pickedProduct.getLaborCostPerSquareFoot() + "," + materialCost + "," + laborCost + "," + tax + "," + total;
    }

    public String oderToStringToView() { // used to view / display 
        String name = this.customerName.replaceAll("\\*", ",");
        String displayOrder
                = "*********Recipt*********"
                + "\nOrder Number:" + this.orderNumber
                + "\n Name:" + name
                + "\n State:" + pickedTax.getState()
                + "\n Tax Rate:" + this.pickedTax.getTaxRate()
                + "\n Product Type:" + this.pickedProduct.getProductType()
                + "\n Area:" + area
                + "\n Material Cost:" + materialCost
                + "\n Labor Cost:" + laborCost
                + "\n Tax:" + tax
                + "\n Total:" + total;
        return displayOrder;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.orderNumber;
        hash = 79 * hash + Objects.hashCode(this.customerName);
        hash = 79 * hash + Objects.hashCode(this.area);
        hash = 79 * hash + Objects.hashCode(this.pickedTax);
        hash = 79 * hash + Objects.hashCode(this.pickedProduct);
        hash = 79 * hash + Objects.hashCode(this.materialCost);
        hash = 79 * hash + Objects.hashCode(this.laborCost);
        hash = 79 * hash + Objects.hashCode(this.tax);
        hash = 79 * hash + Objects.hashCode(this.total);
        hash = 79 * hash + Objects.hashCode(this.orderDate);
        hash = 79 * hash + Objects.hashCode(this.orderDateAsString);
        hash = 79 * hash + Objects.hashCode(this.exportDateasString);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Order other = (Order) obj;
        if (this.orderNumber != other.orderNumber) {
            return false;
        }
        if (!Objects.equals(this.customerName, other.customerName)) {
            return false;
        }
        if (!Objects.equals(this.orderDateAsString, other.orderDateAsString)) {
            return false;
        }
        if (!Objects.equals(this.exportDateasString, other.exportDateasString)) {
            return false;
        }
        if (!Objects.equals(this.area, other.area)) {
            return false;
        }
        if (!Objects.equals(this.pickedTax, other.pickedTax)) {
            return false;
        }
        if (!Objects.equals(this.pickedProduct, other.pickedProduct)) {
            return false;
        }
        if (!Objects.equals(this.materialCost, other.materialCost)) {
            return false;
        }
        if (!Objects.equals(this.laborCost, other.laborCost)) {
            return false;
        }
        if (!Objects.equals(this.tax, other.tax)) {
            return false;
        }
        if (!Objects.equals(this.total, other.total)) {
            return false;
        }
        if (!Objects.equals(this.orderDate, other.orderDate)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Order{" + "orderNumber=" + orderNumber + ", customerName=" + customerName + ", area=" + area + ", pickedTax=" + pickedTax + ", pickedProduct=" + pickedProduct + ", materialCost=" + materialCost + ", laborCost=" + laborCost + ", tax=" + tax + ", total=" + total + ", orderDate=" + orderDate + ", orderDateAsString=" + orderDateAsString + ", exportDateasString=" + exportDateasString + '}';
    }

}
