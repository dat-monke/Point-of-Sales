import java.util.HashMap;
import java.io.*; 

public class Menu implements Serializable{

    /**
     * In charge of all order menu related interactions
     */

    HashMap<String, Double> orderingMenu; 

    public Menu(){
        /**
         * Default values for the items and prices (subject to change)
         */
        orderingMenu = new HashMap<>(); 
        orderingMenu.put("Hamburger", 1.00); 
        orderingMenu.put("Cheeseburger", 1.50); 
        orderingMenu.put("Double Double", 3.25); 
        orderingMenu.put("French Fries" , 1.00); 
        orderingMenu.put("Soft Drink", 1.00);    
    }

    public void addToMenu(String name, double price){
        /**
         * Adding a new item to the menu 
         */
        orderingMenu.put(name, price);
    }

    public void removeFromMenu(String name){
        /**
         * Removing an item from the menu 
         */
        orderingMenu.remove(name);
    }

    @Override
    public String toString() {
        /**
         * Print out the menu using the toString() method
         */
        StringBuilder sb = new StringBuilder(); 
        sb.append("---------MENU---------\n");
        for (String a : orderingMenu.keySet()) {
            sb.append(a); 
            sb.append(" : "); 
            String o = String.format("%.2f%n", orderingMenu.get(a)); 
            sb.append("$" + o);
        }
        sb.append("----------------------"); 
        return sb.toString();
    }

    //Getter and Setter methods below 
    public Menu(HashMap<String,Double> orderingMenu) {
        this.orderingMenu = orderingMenu;
    }

    public HashMap<String,Double> getOrderingMenu() {
        return this.orderingMenu;
    }



}