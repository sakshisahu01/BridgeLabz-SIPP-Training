interface IInsurable{
    void calculateInsurance();
    void getInsuranceDetails();
}

class Vehicle{
    int vehicle_number;
    String vehicle_name;
    int rental_rate;

    Vehicle(int vehicle_number, String vehicle_name, int rental_rate) {
        this.vehicle_number = vehicle_number;
        this.vehicle_name = vehicle_name;
        this.rental_rate = rental_rate;
    }
    //getter and setter methods
    public int getVehicleNumber() {
        return vehicle_number;
    }
    public void setVehicleNumber(int vehicle_number) {
        this.vehicle_number = vehicle_number;
    }
    public String getVehicleName() {
        return vehicle_name;
    }
    public void setVehicleName(String vehicle_name) {
        this.vehicle_name = vehicle_name;
    }
    public int getRentalRate() {
        return rental_rate;
    }
    public void setRentalRate(int rental_rate) {
        this.rental_rate = rental_rate;
    }
}
class Car extends Vehicle implements IInsurable{
    String car_type;
    int seating_capacity;

    Car(int vehicle_number, String vehicle_name, int rental_rate, String car_type, int seating_capacity) {
        super(vehicle_number, vehicle_name, rental_rate);
        this.car_type = car_type;
        this.seating_capacity = seating_capacity;
    }

    @Override
    public void calculateInsurance() {
        // Logic to calculate insurance for the car
        System.out.println("Calculating insurance for " + getVehicleName());
    }

    @Override
    public void getInsuranceDetails() {
        // Logic to get insurance details for the car
        System.out.println("Getting insurance details for " + getVehicleName());
    }


}
class Bike extends Vehicle implements IInsurable{
    String bike_type;
    int engine_capacity;

    Bike(int vehicle_number, String vehicle_name, int rental_rate, String bike_type, int engine_capacity) {
        super(vehicle_number, vehicle_name, rental_rate);
        this.bike_type = bike_type;
        this.engine_capacity = engine_capacity;
    }

    @Override
    public void calculateInsurance() {
        // Logic to calculate insurance for the bike
        System.out.println("Calculating insurance for " + getVehicleName());
    }

    @Override
    public void getInsuranceDetails() {
        // Logic to get insurance details for the bike
        System.out.println("Getting insurance details for " + getVehicleName());
    }
}
class Truck extends Vehicle implements IInsurable{
    String truck_type;
    int load_capacity;

    Truck(int vehicle_number, String vehicle_name, int rental_rate, String truck_type, int load_capacity) {
        super(vehicle_number, vehicle_name, rental_rate);
        this.truck_type = truck_type;
        this.load_capacity = load_capacity;
    }

    @Override
    public void calculateInsurance() {
        // Logic to calculate insurance for the truck
        System.out.println("Calculating insurance for " + getVehicleName());
    }

    @Override
    public void getInsuranceDetails() {
        // Logic to get insurance details for the truck
        System.out.println("Getting insurance details for " + getVehicleName());
    }
}

public class VehicleRentalSystem {

    public static void main(String[] args) {
        // Creating instances of vehicles
        Car car = new Car(101, "Toyota Camry", 5000, "Sedan", 5);
        Bike bike = new Bike(102, "Yamaha R15", 1500, "Sport", 155);
        Truck truck = new Truck(103, "Volvo FH16", 10000, "Heavy Duty", 20000);

        // Displaying vehicle details
        System.out.println("Car: " + car.getVehicleName() + ", Rental Rate: " + car.getRentalRate());
        System.out.println("Bike: " + bike.getVehicleName() + ", Rental Rate: " + bike.getRentalRate());
        System.out.println("Truck: " + truck.getVehicleName() + ", Rental Rate: " + truck.getRentalRate());

        // Calculating and getting insurance details
        car.calculateInsurance();
        car.getInsuranceDetails();

        bike.calculateInsurance();
        bike.getInsuranceDetails();

        truck.calculateInsurance();
        truck.getInsuranceDetails();
    }
    
}
