package aeroplanecost.Plane_Commands;

import java.util.ArrayList;

public class TypePlanes {
    // Attributes
    private String model;
    private String manufacturer;
    private int capacity;
    private double maxSpeed; 
    private String engineType;
    private double price; 

    // Constructor 
    public TypePlanes(String model, String manufacturer, int capacity, double maxSpeed, String engineType,
            double price) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.capacity = capacity;
        this.maxSpeed = maxSpeed;
        this.engineType = engineType;
        this.price = price;
    }

    // Method to calculate tax (15% of the total cost of the plane)
    public double calculateTax() {
        return price * 0.15; 
    }

    // Public method to display airplane information and calculated tax in a report
    public void displayReport() {
        System.out.println("_______________ A I R P L A N E__R E P O R T _______________");
        System.out.println("Model: " + model);
        System.out.println("Manufacturer: " + manufacturer);
        System.out.println("Capacity: " + capacity + " passengers");
        System.out.println("Max Speed: " + maxSpeed + " km/h");
        System.out.println("Engine Type: " + engineType);
        System.out.println("Price: $" + String.format("%.2f", price));
        System.out.println("Tax (15%): $" + String.format("%.2f", calculateTax()));
        System.out.println("---------------------------------------");
    }

    public static void displayAllReports(ArrayList<TypePlanes> airplanes) {
        for (TypePlanes airplane : airplanes) {
            airplane.displayReport();
            System.out.println();
        }
    }
}