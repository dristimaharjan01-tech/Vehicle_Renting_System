package service;

import model.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class RentalService {
    private ArrayList<Rental> rentals = new ArrayList<>();

    public void rentVehicle(String id, Vehicle v, Customer c, LocalDate start, LocalDate end) {
        if (!v.isAvailable()) {
            System.out.println("Vehicle not available!");
            return;
        }

        Rental rental = new Rental(id, v, c, start, end);
        rental.calculateCost();
        v.setStatus("Rented");

        rentals.add(rental);
        System.out.println("Vehicle rented successfully!");
    }

    public Rental findRental(String id) {
        for (Rental r : rentals) {
            if (r.getRentalId().equals(id)) return r;
        }
        return null;
    }
}