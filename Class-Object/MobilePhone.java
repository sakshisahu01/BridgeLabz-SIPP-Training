

 class MobilePhone{
    // Private fields for encapsulation
    private String brand;
    private String model;
    private double price;

    // Constructor to initialize MobilePhone attributes
    public MobilePhone(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    // Getter for brand
    public String getBrand() {
        return brand;
    }

    // Setter for brand
    public void setBrand(String brand) {
        this.brand = brand;
    }

    // Getter for model
    public String getModel() {
        return model;
    }

    // Setter for model
    public void setModel(String model) {
        this.model = model;
    }

    // Getter for price
    public double getPrice() {
        return price;
    }

    // Setter for price
    public void setPrice(double price) {
        this.price = price;
    }

    // Method to display phone details
    public void displayPhoneDetails() {
        System.out.println("Mobile Phone Details:");
        System.out.println("Brand : " + brand);
        System.out.println("Model : " + model);
        System.out.println("Price : ₹" + price);
    }

    // Main method to test the MobilePhone class
    public static void main(String[] args) {
        // Creating a MobilePhone object
        MobilePhone phone1 = new MobilePhone("Samsung", "Galaxy S21", 69999.0);

        // Displaying the phone det
