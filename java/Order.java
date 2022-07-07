import java.io.Serializable;
import java.util.*;

public class Order implements Serializable {
    /**
    *  This class is used to process all incoming orders from the customer 
    */
    
    private int orderNumber; 
    private HashMap<String, Double> orderAmount; 
    double totalBill = 0;
    int hamburger = 0; 
    int cheeseburger = 0; 
    int double_double = 0; 
    int french_fries = 0; 
    int soda = 0; 
    
    
    HashMap<Date, HashMap<String, Double>> saveOrders; 
    HashMap<String, Integer> orderType; 
    public HashMap<Date, HashMap<String, Integer>> saveOrderAmount; 
    

    public Order() {
        /**
         * Construction with default values, etc (ie an initializer)
         */
        saveOrders = new HashMap<>(); 
        saveOrderAmount = new HashMap<>(); 
        orderAmount = new HashMap<>(); 
        orderType = new HashMap<>(); 
        orderAmount.put("Hamburger", 0.00); 
        orderAmount.put("Cheeseburger", 0.00); 
        orderAmount.put("Double Double", 0.00); 
        orderAmount.put("French Fries", 0.00); 
        orderAmount.put("Soda", 0.00); 

        //Initial for saveOrderAmount 
        orderType.put("Hamburger", 0); 
        orderType.put("Cheeseburger", 0);  
        orderType.put("Double Double", 0); 
        orderType.put("French Fries", 0); 
        orderType.put("Soda", 0); 
    }

    public void addingOrder(int itemSelect, int itemQuant){
    /**
     * Adding items to a customer's order and recording the cost and quantity for bookkeeping 
     */
        if (itemSelect == 1){
            orderAmount.put("Hamburger", orderAmount.get("Hamburger") + itemQuant * 1.00); 
            orderType.put("Hamburger", orderType.get("Hamburger") + itemQuant); 
            hamburger += itemQuant; 
        }
        if (itemSelect == 2){
            orderAmount.put("Cheeseburger", orderAmount.get("Cheeseburger") + itemQuant * 1.50); 
            orderType.put("Cheeseburger", orderType.get("Cheeseburger") + itemQuant); 
            cheeseburger += itemQuant;
        }
        if (itemSelect == 3){
            orderAmount.put("Double Double", orderAmount.get("Double Double") + itemQuant * 3.25);
            orderType.put("Double Double", orderType.get("Double Double") + itemQuant); 
            double_double += itemQuant; 
        }
        if (itemSelect == 4){
            orderAmount.put("French Fries", orderAmount.get("French Fries") + itemQuant * 1.00);
            orderType.put("French Fries", orderType.get("French Fries") + itemQuant);  
            french_fries += itemQuant; 
        }
        if (itemSelect == 5){
            orderAmount.put("Soda", orderAmount.get("Soda") + itemQuant * 1.00); 
            orderType.put("Soda", orderType.get("Soda") + itemQuant); 
            soda += itemQuant; 
        }
    }

    public Date saveTime(){
        /**
         * Getter method for obtaining the timestamp 
         */
        Date date = java.util.Calendar.getInstance().getTime(); 
        return date; 
    }

    public void serialOrder(){
        /**
         * Save the order and make sure that it is timestamped 
         */
        Date date = java.util.Calendar.getInstance().getTime(); 
        orderAmount.put("ORDER NUMBER", (double) getOrderNumber());
        saveOrders.put(date, orderAmount); //Should save the cost of the order to the date
        saveOrderAmount.put(date, orderType); //Save all the attached orders to the date
    }
    
    public void clearCache(){
        /**
         * Clearing all fields for next order to be recorded
         */
        hamburger = 0; 
        cheeseburger = 0; 
        double_double = 0; 
        french_fries = 0; 
        soda = 0; 
    }

    public double getOrderCost(){ 
        /**
        * Summation of the customer's order for the final bill
        */
        for (String a : orderAmount.keySet()){
            totalBill += orderAmount.get(a); 
        }
        return totalBill; 
    }

    @Override
    public String toString() {
        /**
         * Print out the customer's order, can be outputted later into a file, txt, etc using this toString() method
         */
        StringBuilder sb = new StringBuilder(); 
        totalBill = 0; 
        for (String a : orderAmount.keySet()){
            totalBill += orderAmount.get(a); 
        }
        setOrderNumber(); 
        sb.append("-------Your order------\n"); 
        sb.append("For order number:  " + getOrderNumber() + "\n"); 
        sb.append("You ordered " + hamburger + " hamburger(s)\n"); 
        sb.append("You ordered " + cheeseburger + " cheeseburger(s)\n"); 
        sb.append("You ordered " + double_double + " double double(s)\n"); 
        sb.append("You ordered " + french_fries + " french frie(s)\n"); 
        sb.append("You ordered " + soda + " soda(s)\n"); 
        String o = String.format("Your bill is: $%.2f%n", totalBill);
        sb.append(o);
        sb.append("-----------------------\n"); 
        return sb.toString(); 
    }

    //Getter and Setter methods below
    void setOrderNumber() {
        this.orderNumber = (int) (Math.random() * 10000000);
    }

    int getOrderNumber() {
        return this.orderNumber; 
    }

    
}