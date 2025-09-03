// Temperature Alert System
// Scenario: Alert if temperature crosses threshold
// Task: Use Predicate<Double> functional interface

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

// Temperature reading class
class TemperatureReading {
    private double temperature;
    private String location;
    private String timestamp;
    
    public TemperatureReading(double temperature, String location, String timestamp) {
        this.temperature = temperature;
        this.location = location;
        this.timestamp = timestamp;
    }
    
    public double getTemperature() {
        return temperature;
    }
    
    public String getLocation() {
        return location;
    }
    
    public String getTimestamp() {
        return timestamp;
    }
    
    @Override
    public String toString() {
        return "TemperatureReading [temperature=" + temperature + "°C, location=" + location + ", timestamp=" + timestamp + "]";
    }
}

// Temperature alert system
class TemperatureAlertSystem {
    private List<TemperatureReading> readings;
    
    public TemperatureAlertSystem() {
        this.readings = new ArrayList<>();
    }
    
    public void addReading(TemperatureReading reading) {
        readings.add(reading);
    }
    
    // Check for high temperature alerts using Predicate
    public List<TemperatureReading> getHighTemperatureAlerts(double threshold) {
        Predicate<TemperatureReading> highTempPredicate = reading -> reading.getTemperature() > threshold;
        
        List<TemperatureReading> alerts = new ArrayList<>();
        for (TemperatureReading reading : readings) {
            if (highTempPredicate.test(reading)) {
                alerts.add(reading);
            }
        }
        return alerts;
    }
    
    // Check for low temperature alerts using Predicate
    public List<TemperatureReading> getLowTemperatureAlerts(double threshold) {
        Predicate<TemperatureReading> lowTempPredicate = reading -> reading.getTemperature() < threshold;
        
        List<TemperatureReading> alerts = new ArrayList<>();
        for (TemperatureReading reading : readings) {
            if (lowTempPredicate.test(reading)) {
                alerts.add(reading);
            }
        }
        return alerts;
    }
    
    // Check for temperature within range using Predicate
    public List<TemperatureReading> getNormalTemperatureAlerts(double min, double max) {
        Predicate<TemperatureReading> normalTempPredicate = reading -> 
            reading.getTemperature() >= min && reading.getTemperature() <= max;
        
        List<TemperatureReading> alerts = new ArrayList<>();
        for (TemperatureReading reading : readings) {
            if (normalTempPredicate.test(reading)) {
                alerts.add(reading);
            }
        }
        return alerts;
    }
    
    // Generic alert checker with custom predicate
    public List<TemperatureReading> getCustomAlerts(Predicate<TemperatureReading> predicate) {
        List<TemperatureReading> alerts = new ArrayList<>();
        for (TemperatureReading reading : readings) {
            if (predicate.test(reading)) {
                alerts.add(reading);
            }
        }
        return alerts;
    }
    
    public void displayAllReadings() {
        System.out.println("\n--- All Temperature Readings ---");
        readings.forEach(System.out::println);
    }
}

// Temperature sensor class
class TemperatureSensor {
    private String location;
    private TemperatureAlertSystem alertSystem;
    
    public TemperatureSensor(String location, TemperatureAlertSystem alertSystem) {
        this.location = location;
        this.alertSystem = alertSystem;
    }
    
    public void recordTemperature(double temperature) {
        String timestamp = java.time.LocalDateTime.now().toString();
        TemperatureReading reading = new TemperatureReading(temperature, location, timestamp);
        alertSystem.addReading(reading);
        System.out.println("Recorded: " + reading);
    }
}

public class TemperatureAlertSystemDemo {
    public static void main(String[] args) {
        System.out.println("=== Temperature Alert System ===\n");
        
        // Create alert system
        TemperatureAlertSystem alertSystem = new TemperatureAlertSystem();
        
        // Create sensors
        TemperatureSensor sensor1 = new TemperatureSensor("Living Room", alertSystem);
        TemperatureSensor sensor2 = new TemperatureSensor("Kitchen", alertSystem);
        TemperatureSensor sensor3 = new TemperatureSensor("Bedroom", alertSystem);
        
        // Record some temperature readings
        sensor1.recordTemperature(25.5);
        sensor2.recordTemperature(35.8);
        sensor3.recordTemperature(18.2);
        sensor1.recordTemperature(40.1);
        sensor2.recordTemperature(22.0);
        sensor3.recordTemperature(15.5);
        
        // Display all readings
        alertSystem.displayAllReadings();
        
        // Check for alerts
        System.out.println("\n--- High Temperature Alerts (>30°C) ---");
        List<TemperatureReading> highAlerts = alertSystem.getHighTemperatureAlerts(30.0);
        highAlerts.forEach(alert -> 
            System.out.println("HIGH ALERT: " + alert.getLocation() + " - " + alert.getTemperature() + "°C"));
        
        System.out.println("\n--- Low Temperature Alerts (<20°C) ---");
        List<TemperatureReading> lowAlerts = alertSystem.getLowTemperatureAlerts(20.0);
        lowAlerts.forEach(alert -> 
            System.out.println("LOW ALERT: " + alert.getLocation() + " - " + alert.getTemperature() + "°C"));
        
        System.out.println("\n--- Normal Temperature Range (20-30°C) ---");
        List<TemperatureReading> normalAlerts = alertSystem.getNormalTemperatureAlerts(20.0, 30.0);
        normalAlerts.forEach(alert -> 
            System.out.println("NORMAL: " + alert.getLocation() + " - " + alert.getTemperature() + "°C"));
        
        // Custom predicate example
        System.out.println("\n--- Custom Alert: Temperature > 25°C and < 30°C ---");
        List<TemperatureReading> customAlerts = alertSystem.getCustomAlerts(
            reading -> reading.getTemperature() > 25.0 && reading.getTemperature() < 30.0
        );
        customAlerts.forEach(alert -> 
            System.out.println("CUSTOM: " + alert.getLocation() + " - " + alert.getTemperature() + "°C"));
        
        System.out.println("\n=== Temperature Alert System Demo Complete ===");
    }
}