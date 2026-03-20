package service;

import model.Vehicle;
import java.util.ArrayList;

public class VehicleService {
    private ArrayList<Vehicle> vehicles = new ArrayList<>();

    public void addVehicle(Vehicle v) {
        vehicles.add(v);
    }

    public void displayVehicles() {
        for (Vehicle v : vehicles) {
            System.out.println(v);
        }
    }

    public Vehicle findVehicle(String id) {
        for (Vehicle v : vehicles) {
            if (v.getVehicleId().equals(id)) return v;
        }
        return null;
    }
}