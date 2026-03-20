package service;

import model.Rental;
import java.util.ArrayList;

public class ReportService {
    public void generateReport(ArrayList<Rental> rentals) {
        double total = 0;

        for (Rental r : rentals) {
            System.out.println("Rental ID: " + r.getRentalId());
        }

        System.out.println("Report Generated.");
    }
}