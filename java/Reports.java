import java.io.Serializable;

public class Reports implements Serializable{
    /**
     *  This class is in charge of generating reports and/or related content
     */
    Inventory obj1 = new Inventory(); //Instance
    Menu obj2 = new Menu(); //Instance

    public void inventoryReport(){ 
        /**
        * Prints out an inventory report
        */
        System.out.println(obj1); 
    }
    
    public void showMenu(){
        /**
         * Displays the menu 
         */
        System.out.println(obj2); 
    }

    public double expenses(){
        /**
         * Returns the expenses incurred
         */
        return obj1.getInventoryCost(); 
    }



}