 class Circle {
    // Private field
    private double radius;

    // Constructor to initialize radius
    public Circle(double radius) {
        this.radius = radius;
    }

    // Method to calculate area
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    // Method to calculate circumference
    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }

    // Method to display circle details
    public void displayDetails() {
        System.out.println("Circle Radius       : " + radius);
        System.out.println("Area                : " + calculateArea());
        System.out.println("Circumference       : " + calculateCircumference());
    }

    // Main method to test
    public static void main(String[] args) {
        Circle circle = new Circle(7.5);
        circle.displayDetails();
    }
}
