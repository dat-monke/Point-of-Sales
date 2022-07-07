import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat; 

public class POS implements Serializable{
    private double moneyMade = 0;
    public static void main(String[] args) throws Exception {

        /**
        *  The operating point of the entire program: in charge of all the functions such as: 
        *      1. Taking Customer Orders
        *      2. Financial Reports
        *      3. Shutting Down; 
        *      4. Inventory Reporting
        */

        POS sales = new POS(); 
        Scanner input = new Scanner(System.in); 
        Reports instance = new Reports(); //instantiating 
        Inventory invInstance = new Inventory(); 
        HashMap<Date, HashMap<String, Integer>> recordedOrders; 
        recordedOrders = new HashMap<>(); 

        while (true) {
            
            menuPOS();
            int option = input.nextInt(); 
            if (option == 1){ //Taking the orders of the customer
                instance.showMenu(); //show menu 
                Order orderInstance = new Order(); 
                String ing1 = "Bread";
                String ing2 = "Tomatoes"; 
                String ing3 = "Lettuce"; 
                String ing4 = "Patties"; 
                String ing5 = "Pickles"; 
                String ing6 = "Potatoes"; 
                String ing7 = "Vegetable Oil"; 
                String ing8 = "Sprite"; 
                String ing9 = "Coke"; 
                String ing10 = "Fanta"; 
                String ing11 = "Cheese";

                while (true) { //Will run through the menu till an exit procedure is executed
                    
                    System.out.println("What would you like to order?"); 
                    int itemName = input.nextInt(); 
                    if (itemName == 0){
                        break;
                    }
                    System.out.println("How many would you like?"); 
                    int itemQuant = input.nextInt(); 
                    if (itemName <= 5){ 
                    //Check if there is enough inventory, minimum 0.25 of each - all encompasing minimum requirements - can change to item specific if needed
                    if (itemName == 1){ //Inventory deduction for making the product
                        if (invInstance.enoughInventory(ing1) && invInstance.enoughInventory(ing2) &&
                            invInstance.enoughInventory(ing3) && invInstance.enoughInventory(ing4) && invInstance.enoughInventory(ing5)) {
                                invInstance.inventory.put(ing1, invInstance.inventory.get(ing1) - 0.20);
                                invInstance.inventory.put(ing2, invInstance.inventory.get(ing2) - 0.15);
                                invInstance.inventory.put(ing3, invInstance.inventory.get(ing3) - 0.10);
                                invInstance.inventory.put(ing4, invInstance.inventory.get(ing4) - 0.10);
                                invInstance.inventory.put(ing5, invInstance.inventory.get(ing5) - 0.05);
                                orderInstance.addingOrder(itemName, itemQuant); 
                        } else {
                            System.out.println("Not enough ingredients!"); 
                        }
                    }
                    if (itemName == 2){ //Inventory deduction for making the product
                        if (invInstance.enoughInventory(ing1) && invInstance.enoughInventory(ing2) &&
                            invInstance.enoughInventory(ing3) && invInstance.enoughInventory(ing4) && 
                            invInstance.enoughInventory(ing5) && invInstance.enoughInventory(ing11)) {
                                invInstance.inventory.put(ing1, invInstance.inventory.get(ing1) - 0.20);
                                invInstance.inventory.put(ing2, invInstance.inventory.get(ing2) - 0.15);
                                invInstance.inventory.put(ing3, invInstance.inventory.get(ing3) - 0.10);
                                invInstance.inventory.put(ing4, invInstance.inventory.get(ing4) - 0.10);
                                invInstance.inventory.put(ing5, invInstance.inventory.get(ing5) - 0.05);
                                invInstance.inventory.put(ing11, invInstance.inventory.get(ing11) - 0.10); 
                                orderInstance.addingOrder(itemName, itemQuant); 
                        } else {
                            System.out.println("Not enough ingredients!"); 
                        }   
                    }
                    if (itemName == 3){ //Inventory deduction for making the product
                        if (invInstance.enoughInventory(ing1) && invInstance.enoughInventory(ing2) &&
                            invInstance.enoughInventory(ing3) && invInstance.enoughInventory(ing4) && invInstance.enoughInventory(ing5)) {
                                invInstance.inventory.put(ing1, invInstance.inventory.get(ing1) - 0.20);
                                invInstance.inventory.put(ing2, invInstance.inventory.get(ing2) - 0.30);
                                invInstance.inventory.put(ing3, invInstance.inventory.get(ing3) - 0.20);
                                invInstance.inventory.put(ing4, invInstance.inventory.get(ing4) - 0.20);
                                invInstance.inventory.put(ing5, invInstance.inventory.get(ing5) - 0.10);
                                orderInstance.addingOrder(itemName, itemQuant); 
                            } else {
                                System.out.println("Not enough ingredients!"); 
                            }
                    }
                    if (itemName == 4){ //Inventory deduction for making the product
                        if (invInstance.enoughInventory(ing6) && invInstance.enoughInventory(ing7)) {
                                invInstance.inventory.put(ing6, invInstance.inventory.get(ing6) - 0.30);
                                invInstance.inventory.put(ing7, invInstance.inventory.get(ing7) - 0.15);
                                orderInstance.addingOrder(itemName, itemQuant); 
                        } else {
                            System.out.println("Not enough ingredients!"); 
                        }  
                    }
                    if (itemName == 5){ //Inventory deduction for making the product
                        if (invInstance.enoughInventory(ing8) && invInstance.enoughInventory(ing9) && invInstance.enoughInventory(ing10)) {
                            invInstance.inventory.put(ing8, invInstance.inventory.get(ing8) - 0.30); 
                            invInstance.inventory.put(ing9, invInstance.inventory.get(ing9) - 0.30);
                            invInstance.inventory.put(ing10, invInstance.inventory.get(ing10) - 0.30);
                            orderInstance.addingOrder(itemName, itemQuant); 
                        } else {
                            System.out.println("Not enough ingredients!"); 
                        }
                    }      
                } else {
                    System.out.println("Please choose an option between 1-5");
                    }
                }
                sales.setMoney(orderInstance.getOrderCost()); 
                System.out.println(orderInstance); 
                System.out.println("Order was placed at " + orderInstance.saveTime()); 
                orderInstance.serialOrder(); //Profits based on that order from that day 
                recordedOrders.putAll(orderInstance.saveOrderAmount); 
                orderInstance.clearCache(); 
            }
            if (option == 2){
                System.out.println(invInstance); // show current inventory
            }
            if (option == 3){ //Generate profit and expense reports
                java.util.Date date = new java.util.Date(); 
                System.out.println("Current Financial Data as of : " + date);
                System.out.println("Total Expenses: $" + invInstance.getInventoryCost());  
                System.out.println("Net Income: $" + (sales.getMoneyMade() - invInstance.getInventoryCost())); 
                //Work in progress to produce report

                //Shows all orders and stuff 
                System.out.println("Current Sales as of: " + date); 
                for (Date key : recordedOrders.keySet()) {
                    System.out.println(key + " " + recordedOrders.get(key)); 
                }
                
                //Filter by date range 
                System.out.println("Would you like to show the sales in a certain date range (Y/N)");
                char choice = input.next().charAt(0); 
                if (choice == 'Y' || choice == 'y') {
                    System.out.println("Enter the range of dates in the following format: dd/mm/yyyy/hh/mm/ss  dd/mm/yyyy/hh/mm/ss"); 
                    //Choose the date range using the mm-dd-yyyy format in order to choose the date using next instead of nextline(); 
                    
                    int hamburger = 0; int cheeseburger = 0; int double_double = 0; int french_fries = 0; int soda = 0; 
                    String Date1= input.next();  
                    Date date1 = new SimpleDateFormat("dd/MM/yyyy/HH/mm/ss").parse(Date1);  
                    String Date2 = input.next(); 
                    Date date2 = new SimpleDateFormat("dd/MM/yyyy/HH/mm/ss").parse(Date2); 
                    System.out.println("\n======================================================");
                    
                    for (Date key : recordedOrders.keySet()) {
                        if (key.after(date1)){
                            if (key.before(date2)) { //Pure display is unfiltered 
                                System.out.println(key + " " + recordedOrders.get(key));
                                //Adding orders by product within date range

                                hamburger += recordedOrders.get(key).get("Hamburger"); 
                                cheeseburger += recordedOrders.get(key).get("Cheeseburger"); 
                                double_double += recordedOrders.get(key).get("Double Double"); 
                                french_fries += recordedOrders.get(key).get("French Fries"); 
                                soda += recordedOrders.get(key).get("Soda"); 
                            }
                        } else if (date1.equals(date2)) {
                            System.out.println("Error: same time frame"); 
                        }
                    }
                    //Print out the number of units sold during the period 
                    System.out.println("======================================================="); 
                    System.out.println("Amount of hamburgers sold during the period : " + hamburger); 
                    System.out.println("Amount of cheeseburgers sold during the period : " + cheeseburger); 
                    System.out.println("Amount of double doubles sold during the period : " + double_double); 
                    System.out.println("Amount of french fries sold during the period : " + french_fries); 
                    System.out.println("Amount of soda sold during the period : " + soda); 
                    System.out.println("Total income for the period is : $" + ((hamburger * 1.00) + (cheeseburger * 1.50) + (double_double * 3.25) + (french_fries * 1.00) + (soda * 1.00))); 
                }
                if (choice == 'N' || choice == 'n') {
                    System.out.println("Returning back to main menu"); 
                }

            }
            if (option == 4){ //Ordering new inventory
                while (true){
                    System.out.println("Ordering new inventory - Select the item to order - Press 0 to finish"); 
                    invInstance.displayMenu();
                    int selection = input.nextInt(); 
                    invInstance.orderInventory(selection);
                    if (selection == 0){
                        break; 
                    }
                }
                
            }
            if (option == 5){ //Shutdown and then serialize the program
                System.out.println("Shutting down system..."); 
                saveState(sales); 
                ObjectOutputStream outputInventory = new ObjectOutputStream(new FileOutputStream("inventory.ser")); 
                outputInventory.writeObject(invInstance); 
                ObjectOutputStream outputReports = new ObjectOutputStream(new FileOutputStream("reports.ser")); 
                outputReports.writeObject(instance);

                //Serialize hashmap test 
                ObjectOutputStream outputHash = new ObjectOutputStream(new FileOutputStream("salesHash.ser")); 
                outputHash.writeObject(recordedOrders); 
                outputHash.close(); 
                //End test 

                outputInventory.close(); 
                outputReports.close(); 
                break; 
            }
            if (option == 6){ //Deserialize the previous state and load it into the program
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("saveState.ser")); 
                ObjectInputStream inputInventory = new ObjectInputStream(new FileInputStream("inventory.ser")); 
                ObjectInputStream inputReports = new ObjectInputStream(new FileInputStream("reports.ser")); 
                sales = (POS) ois.readObject(); 
                invInstance = (Inventory) inputInventory.readObject(); 
                instance = (Reports) inputReports.readObject(); 

                //Deserialize hashmap test
                ObjectInputStream inputHash = new ObjectInputStream(new FileInputStream("salesHash.ser")); 
                recordedOrders = (HashMap<Date, HashMap<String, Integer>>) inputHash.readObject(); 
                //End test

                ois.close(); inputInventory.close(); inputReports.close();
            }
        }
        input.close();
    }

    public static void menuPOS() {
        /**
         * Menu options for the main operations
         */
        java.util.Date date = new java.util.Date(); 
        System.out.println("\nWelcome to Java Burgers : " + date + "\n"); 
        System.out.println("1. Take Order / Ordering Menu"); 
        System.out.println("2. Inventory Report"); 
        System.out.println("3. Financial Report");
        System.out.println("4. Reorder Inventory"); 
        System.out.println("5. Shutdown"); 
        System.out.println("6. Restore Previous State");
    }
        
    public static void saveState(POS pos){
        /**
        * Method to save the current program state
        */
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("saveState.ser")); 
            oos.writeObject(pos); 
            oos.close(); 
        }
        catch(IOException e) {
            e.printStackTrace(); 
        } 
    }

    //Getter and Setter methods below
    public double getMoneyMade(){
        return this.moneyMade; 
    }

    public void setMoney(double amount){
        this.moneyMade += amount; 
    }
    
    
}

