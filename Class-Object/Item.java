 class Item {
    // Private fields
    private int itemCode;
    private String itemName;
    private double price;

    // Constructor
    public Item(int itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    // Method to calculate total cost for given quantity
    public double calculateTotalCost(int quantity) {
        return price * quantity;
    }

    // Method to display item details
    public void displayItemDetails(int quantity) {
        System.out.println("Item Code    : " + itemCode);
        System.out.println("Item Name    : " + itemName);
        System.out.println("Price per unit : ₹" + price);
        System.out.println("Quantity     : " + quantity);
        System.out.println("Total Cost   : ₹" + calculateTotalCost(quantity));
    }

    // Main method to test
    public static void main(String[] args) {
        Item item1 = new Item(101, "Pen Drive", 750.0);
        item1.displayItemDetails(3);
    }
}
