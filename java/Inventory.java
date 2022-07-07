import java.io.Serializable;
import java.util.*; 

public class Inventory implements Serializable {

    /**
    * Requirements of this class: 
    * Keep track of units on hand 
    * Cost to purchase new units 
    * Able to purchase new units 
    * Immediate inventory report
    */

    public HashMap<String, Double> inventory;
    String divider = "======================================";
    int bread = 0;
    int patties = 0;
    int lettuce = 0;
    int tomatoes = 0;
    int pickles = 0;
    int potatoes = 0;
    int vegetableOil = 0;
    int sprite = 0;
    int coke = 0;
    int fanta = 0;
    int cheese = 0; 
    double inventoryCost = 0;
    Date date = new Date(); 
    
    public boolean enoughInventory(String ingredient) {
        /**
         * Checks if there is enough inventory to process a order/request
         */
        if (inventory.get(ingredient) < 0.50) {
            return false;
        }
        return true;
    }

    public Inventory() { 
        /**
         * Constructor for inventory (default values)
         */
        inventory = new HashMap<>();
        // Hamburger Ingredients
        inventory.put("Bread", 0.00);
        inventory.put("Patties", 0.00);
        inventory.put("Lettuce", 0.00);
        inventory.put("Tomatoes", 0.00);
        inventory.put("Pickles", 0.00);
        // French Fry Ingredients
        inventory.put("Potatoes", 0.00);
        inventory.put("Vegetable Oil", 0.00);
        // Soft Drink Ingredients
        inventory.put("Sprite", 0.00);
        inventory.put("Coke", 0.00);
        inventory.put("Fanta", 0.00); 
        //NEW ADDITION 
        inventory.put("Cheese", 0.00); 
    }

    public void addInventory(String ingredient, double quantity){ 
        /**
         * In case you want to add new ingredients but primarily used for buying new unimplemented stock
        */
        inventory.put(ingredient, quantity); 
    }

    public void removeInventory(String ingredient){
        /**
         * If you have to remove inventory for some reason maybe due to the age of the inventory, etc.
         */
        inventory.remove(ingredient); 
    }

    public void displayMenu(){
        /**
         * Menu to order new inventory
         */
        System.out.println(divider); 
        System.out.println("1.  Bread           : $ 1.00"); 
        System.out.println("2.  Patties         : $ 3.00"); 
        System.out.println("3.  Lettuce         : $ 1.50"); 
        System.out.println("4.  Tomatoes        : $ 2.00"); 
        System.out.println("5.  Pickles         : $ 1.25"); 
        System.out.println("6.  Potatoes        : $ 2.00"); 
        System.out.println("7.  Vegetable Oil   : $ 10.00"); 
        System.out.println("8.  Sprite          : $ 1.00"); 
        System.out.println("9.  Coke            : $ 1.00"); 
        System.out.println("10. Fanta           : $ 1.00");
        System.out.println("11. Cheese          : $ 2.00");  
        System.out.println(divider); 
    }

    

    public void orderInventory(int orderNo) {
        /**
         * Ordering new inventory based on what the manager wants
        */
        if (orderNo == 1){
            inventory.put("Bread", inventory.get("Bread") + 1);
            bread++; inventoryCost += 1.00; 
        }
        if (orderNo == 2){
            inventory.put("Patties", inventory.get("Patties") + 1); 
            patties++; inventoryCost += 3.00; 
        }
        if (orderNo == 3){
            inventory.put("Lettuce", inventory.get("Lettuce") + 1); 
            lettuce++; inventoryCost += 1.50; 
        }
        if (orderNo == 4){
            inventory.put("Tomatoes", inventory.get("Tomatoes") + 1); 
            tomatoes++; inventoryCost += 2.00; 
        }
        if (orderNo == 5){
            inventory.put("Pickles", inventory.get("Pickles") + 1); 
            pickles++; inventoryCost += 1.25; 
        }
        if (orderNo == 6){
            inventory.put("Potatoes", inventory.get("Potatoes") + 1); 
            potatoes++; inventoryCost += 2.00; 
        }
        if (orderNo == 7){
            inventory.put("Vegetable Oil", inventory.get("Vegetable Oil") + 1); 
            vegetableOil++; inventoryCost += 10.00; 
        }
        if (orderNo == 8){
            inventory.put("Sprite", inventory.get("Sprite") + 1); 
            sprite++; inventoryCost += 1.00; 
        }
        if (orderNo == 9){
            inventory.put("Coke", inventory.get("Coke") + 1); 
            coke++; inventoryCost += 1.00; 
        }
        if (orderNo == 10){
            inventory.put("Fanta", inventory.get("Fanta") + 1); 
            fanta++; inventoryCost += 1.00; 
        }
        if (orderNo == 11){
            inventory.put("Cheese", inventory.get("Cheese") + 1); 
            cheese++; inventoryCost += 2.00; 
        }

        if (orderNo == 0) { //Finish taking the orders and list out what they had ordered 
            System.out.println(divider);
            System.out.printf("Ordered %d of Bread(s)%n", bread); 
            System.out.printf("Ordered %d of Pattie(s)%n", patties); 
            System.out.printf("Ordered %d of Lettuce(s)%n", lettuce); 
            System.out.printf("Ordered %d of Tomatoe(s)%n", tomatoes); 
            System.out.printf("Ordered %d of Pickle(s)%n", pickles); 
            System.out.printf("Ordered %d of Potatoe(s)%n", potatoes); 
            System.out.printf("Ordered %d of Vegetable Oil(s)%n", vegetableOil); 
            System.out.printf("Ordered %d of Sprite(s)%n", sprite); 
            System.out.printf("Ordered %d of Coke(s)%n", coke); 
            System.out.printf("Ordered %d of Fanta(s)%n", fanta); 
            System.out.printf("Ordered %d of Cheese(s)%n", cheese); 
            System.out.println(divider); 
            System.out.printf("Your total for your order is: $ %.2f%n", inventoryCost);

            //NEW ADDITION 
            System.out.println("Timestamp : " + date);  

            //RESET 
            resetALL(0); 
        }
    }

    @Override
    public String toString() {
        /**
         * Print out inventory report
         */
        StringBuilder sb = new StringBuilder(); 
        sb.append("-------INVENTORY-------\n");
        for (String a : inventory.keySet()) {
            sb.append(a);
            sb.append(" : ");
            String o = String.format("%.2f%n", inventory.get(a));
            sb.append(o);
        }
        sb.append("----------------------"); 
        return sb.toString(); 
    }

    
    //Setter and getter methods below 
    public Inventory(HashMap<String,Double> inventory, String divider, int bread, int patties, int lettuce, int tomatoes, int pickles, int potatoes, int vegetableOil, int sprite, int coke, int fanta, int cheese, double inventoryCost) {
        this.divider = divider;
        this.bread = bread;
        this.patties = patties;
        this.lettuce = lettuce;
        this.tomatoes = tomatoes;
        this.pickles = pickles;
        this.potatoes = potatoes;
        this.vegetableOil = vegetableOil;
        this.sprite = sprite;
        this.coke = coke;
        this.fanta = fanta;
        this.cheese = cheese; 
        this.inventoryCost = inventoryCost;
    }

    public void resetALL(int value) {
        this.bread = value;
        this.patties = value;
        this.lettuce = value;
        this.tomatoes = value;
        this.pickles = value;
        this.potatoes = value;
        this.vegetableOil = value;
        this.sprite = value;
        this.coke = value;
        this.fanta = value;
        this.cheese = value; 
    }
    public void setCheese(int cheese){
        this.cheese = cheese; 
    }

    public int getCheese(){
        return this.cheese; 
    }

    public String getDivider() {
        return this.divider;
    }

    public void setDivider(String divider) {
        this.divider = divider;
    }

    public int getBread() {
        return this.bread;
    }

    public void setBread(int bread) {
        this.bread = bread;
    }

    public int getPatties() {
        return this.patties;
    }

    public void setPatties(int patties) {
        this.patties = patties;
    }

    public int getLettuce() {
        return this.lettuce;
    }

    public void setLettuce(int lettuce) {
        this.lettuce = lettuce;
    }

    public int getTomatoes() {
        return this.tomatoes;
    }

    public void setTomatoes(int tomatoes) {
        this.tomatoes = tomatoes;
    }

    public int getPickles() {
        return this.pickles;
    }

    public void setPickles(int pickles) {
        this.pickles = pickles;
    }

    public int getPotatoes() {
        return this.potatoes;
    }

    public void setPotatoes(int potatoes) {
        this.potatoes = potatoes;
    }

    public int getVegetableOil() {
        return this.vegetableOil;
    }

    public void setVegetableOil(int vegetableOil) {
        this.vegetableOil = vegetableOil;
    }

    public int getSprite() {
        return this.sprite;
    }

    public void setSprite(int sprite) {
        this.sprite = sprite;
    }

    public int getCoke() {
        return this.coke;
    }

    public void setCoke(int coke) {
        this.coke = coke;
    }

    public int getFanta() {
        return this.fanta;
    }

    public void setFanta(int fanta) {
        this.fanta = fanta;
    }

    public double getInventoryCost() {
        return this.inventoryCost;
    }

    public void setInventoryCost(double inventoryCost) {
        this.inventoryCost = inventoryCost;
    }

    public Inventory inventory(HashMap<String,Double> inventory) {
        this.inventory = inventory;
        return this;
    }

    public Inventory divider(String divider) {
        this.divider = divider;
        return this;
    }

    public Inventory bread(int bread) {
        this.bread = bread;
        return this;
    }

    public Inventory patties(int patties) {
        this.patties = patties;
        return this;
    }

    public Inventory lettuce(int lettuce) {
        this.lettuce = lettuce;
        return this;
    }

    public Inventory tomatoes(int tomatoes) {
        this.tomatoes = tomatoes;
        return this;
    }

    public Inventory pickles(int pickles) {
        this.pickles = pickles;
        return this;
    }

    public Inventory potatoes(int potatoes) {
        this.potatoes = potatoes;
        return this;
    }

    public Inventory vegetableOil(int vegetableOil) {
        this.vegetableOil = vegetableOil;
        return this;
    }

    public Inventory sprite(int sprite) {
        this.sprite = sprite;
        return this;
    }

    public Inventory coke(int coke) {
        this.coke = coke;
        return this;
    }

    public Inventory fanta(int fanta) {
        this.fanta = fanta;
        return this;
    }

    public Inventory inventoryCost(double inventoryCost) {
        this.inventoryCost = inventoryCost;
        return this;
    }

}
