package model;

public class Vehicle {
    private String vehicleId;
    private String brand;
    private String model;
    private String type;
    private double rentalRate;
    private String status;

    public Vehicle(String id, String brand, String model, String type, double rate) {
        this.vehicleId = id;
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.rentalRate = rate;
        this.status = "Available";
    }

    public boolean isAvailable() {
        return status.equals("Available");
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String toString() {
        return vehicleId + " - " + brand + " " + model + " [" + status + "]";
    }
}