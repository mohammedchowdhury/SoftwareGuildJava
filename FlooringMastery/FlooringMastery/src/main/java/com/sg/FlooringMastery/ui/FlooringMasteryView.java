package com.sg.FlooringMastery.ui;

import com.sg.FlooringMastery.dto.Order;
import com.sg.FlooringMastery.dto.Product;
import com.sg.FlooringMastery.dto.Tax;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author mohammedchowdhury
 */
public class FlooringMasteryView {

    private UserIO io;

    public FlooringMasteryView(UserIO io) {
        this.io = io;
    }

    public int printMainMenu() {
        String menu = "* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n"
                + "*  <<Flooring Program>>\n"
                + "* 1. Display Orders\n"
                + "* 2. Add an Order\n"
                + "* 3. Edit an Order\n"
                + "* 4. Remove an Order\n"
                + "* 5. Export All Data\n"
                + "* 6. Quit\n"
                + "*** Enter Selection 1-6 ***\n"
                + "* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n";
        return io.readInt(menu, 1, 6);
    }

    //section 1,3,4
    public LocalDate getDate() { //used for selecttion 1
        boolean validDate = false;
        String date = null;
        while (!validDate) {
            date = io.readString("Please enter date in MMddYYYY format");
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");
                LocalDate ld = LocalDate.parse(date, formatter);
                validDate = true;
                return ld;
            } catch (Exception e) {
                io.print("Invalid date. Please enter in MMDDYYYY Ex: 04202020");
            }

        }
        return null;
    }

    public void printErrorNoOrders(String message) {
        io.print("ERROR: NO SUCH ORDERS FOUND FOR :" + message);
    }

    public void printErrorNoProducts() {
        io.print("ERROR: Inventory empty");
    }

    public void printErrorNoTax() {
        io.print("ERROR: Tax Empty");
    }

    public void printErrorFileCannotBeRead() {
        io.print("ERROR: cannot read file");
    }

    public void printInvalidDataa() {
        io.print("Please enter valid data");
    }

    public void displayOrders(List<Order> orders) {
        for (int i = 0; i < orders.size(); i++) {
            io.print(orders.get(i).oderToStringToView());
        }
    }

    //selection 2
    public LocalDate getFutureDate() {
        int val = Integer.MIN_VALUE;

        LocalDate future = null;
        while (val <= 0) {
            future = getDate();
            LocalDate today = LocalDate.now();
            val = future.compareTo(today);
            if (val <= 0) {
                io.print("Date cannot be in the past or today");
            }
        }
        return future;
    }

    public String getName() {
        boolean validName = false;
        String name = null;
        while (validName == false) {
            name = io.readString("Please enter name :");
            name = name.trim();
            validName = validateName(name);
            if (validName == false) {
                io.print("Invalid name input");
            }
        }
        return name;
    }

    private boolean validateName(String name) {
        name = name.replaceAll(" ", "");
        if (name.length() == 0) {
            return false;
        }
        for (int i = 0; i < name.length(); i++) {
            Character temp = name.charAt(i);
            char temp2 = temp;
            if (!(Character.isDigit(temp) || Character.isLetter(temp) || temp == ',' || temp == '.')) {
                return false;
            }
        }
        return true;
    }

    public Tax pickTax(List<Tax> listOfTaxAndStates) {
        int selection = Integer.MIN_VALUE;
        Tax selectedtax = null;
        for (int i = 0; i < listOfTaxAndStates.size(); i++) {
            io.print((i + 1) + " : " + listOfTaxAndStates.get(i).toString());
        }
        selection = io.readInt("Select a state", 1, listOfTaxAndStates.size());
        selection--;
        return listOfTaxAndStates.get(selection);
    }

    public Product pickProduct(List<Product> listOfProducts) {
        int selection = Integer.MIN_VALUE;
        Tax selectedtax = null;
        for (int i = 0; i < listOfProducts.size(); i++) {
            Product tempProduct = listOfProducts.get(i);
            io.print((i + 1) + " : (Product Type) " + tempProduct.getProductType() + " ** (Cost per Sq foot)" + tempProduct.getCostPerSquareFoot() + " ** (Labor cost per Sq foot)" + tempProduct.getLaborCostPerSquareFoot());
        }
        selection = io.readInt("Select a product", 1, listOfProducts.size());
        selection--;
        return listOfProducts.get(selection);
    }

    public BigDecimal getArea() {
        double area = Double.MIN_VALUE;

        while (area < 100) {
            area = io.readDouble("Please enter area :", Double.MIN_VALUE, Double.MAX_VALUE);
            if (area < 100) {
                io.print("Invalid Area input :" + area);
            }
        }
        BigDecimal areaBigDecimal = new BigDecimal(area + "");
        return areaBigDecimal;

    }

    public boolean keepOrder(Order order, String message) {
        io.print(order.oderToStringToView());
        int ans = io.readInt(message + " Order ? 1(yes) 2(no)", 1, 2);
        if (ans == 1) {
            return true;
        }
        return false;

    }

    //seelction 3
    public int getOrderNumber() {
        return io.readInt("Please enter the order number", 1, Integer.MAX_VALUE);
    }

    public Order editOrder(Order order, List<Product> products, List<Tax> taxes) {
        boolean validName = false;
        String name = "";
        while (!validName) {
            name = io.readString("Enter customer name (" + order.getCustomerName() + ")");
            if (name.equals("")) {
                name = order.getCustomerName();
            }
            validName = validateName(name);
        }
        name = name.replaceAll(",", "*");
        name = name.trim();

        boolean validState = false;
        String stateName = null;
        while (!validState) {
            for (int i = 0; i < taxes.size(); i++) {
                io.print((i+1) + ". " + taxes.get(i).toString());
            }
            stateName = io.readString("Enter State Selection: (" + order.getState() + ")");
            stateName = stateName.toUpperCase();
            stateName = stateName.trim();

            if (stateName.equals("")) {
                stateName = order.getState();
                validState = true;
                break;
            } else {
                try {
                    int selection = Integer.parseInt(stateName);
                    if (selection <= taxes.size()) {
                        stateName = taxes.get(selection - 1).getState();
                        validState = true;
                        break;
                    }else{
                        throw new Exception(); 
                    }

                } catch (Exception e) {
                    io.print("Invalid Input");
                }
            }
        }
        
        
       boolean validproduct = false;
        String productName = null;
        while (!validproduct) {
        for (int i = 0; i < products.size(); i++) {
            io.print((i+1)+" ."+products.get(i).toString());
        }
        productName = io.readString("Enter Product Selection (" + order.getProductType() + ")");
        productName = productName.trim();
        if (productName.equals("")) {
            productName = order.getProductType();
            validproduct = true;
            break;
        }else {
                try {
                    int selection = Integer.parseInt(productName);
                    if (selection <= products.size()) {
                        productName = products.get(selection - 1).getProductType();
                        validState = true;
                        break;
                    }else{
                        throw new Exception(); 
                    }

                } catch (Exception e) {
                    io.print("Invalid Input");
                }
            }
        }

        double area = -10;
        while (area < 100) {
            area = io.readDouble("Enter Area (" + order.getArea() + ")", Integer.MIN_VALUE, Integer.MAX_VALUE);
            if (area < 100) {
                io.print("Invalid Area input :" + area);
            }
        }
        String stArea = area + "";

        Tax tax = null;

        for (int i = 0; i < taxes.size(); i++) {
            if (stateName.equals(taxes.get(i).getState())) {
                tax = taxes.get(i);
                break;
            }
        }
        Product product = null;
        for (int i = 0; i < products.size(); i++) {
            if (productName.equals(products.get(i).getProductType())) {
                product = products.get(i);
                break;
            }
        }

        if (product == null || tax == null) {
            printErrorNoOrders(stateName + " or " + productName);
            return null;
        }
        Order newOrder = new Order(order.getOrderNumber() + "", name, tax.getState(), tax.getTaxRate().toString(), product.getProductType(), stArea, product.getCostPerSquareFoot().toString(), product.getLaborCostPerSquareFoot().toString());
        newOrder.setOrderDate(order.getOrderDateAsString());
        return newOrder;
    }

    public void OrderSuccessfullyMessage(Order order, String message) {
        io.print(order.oderToStringToView() + " \n" + message);
    }

//    public void orderRemovedSuccessfully(Order order,String message) {
//      
//        io.print(order.oderToStringToView()+" "+message);
//    }
    public void numberItemsExported(int x, String message) {
        io.print(x + " " + message);
    }

    //section 6
    public void goodbyeMessage() { //used by option 6
        io.print("Good Bye ... .. . ");
    }

// Display orders will ask the user for a date and then display the orders for that date.
//If no orders exist for that date, it will display an error message and return the user to the main menu.
}
