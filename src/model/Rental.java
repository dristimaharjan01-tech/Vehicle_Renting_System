package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Rental {
    private String rentalId;
    private Vehicle vehicle;
    private Customer customer;
    private LocalDate startDate;
    private LocalDate expectedReturnDate;
    private LocalDate actualReturnDate;
    private double totalCost;
    private double lateFee;
    private double finalAmount;

    public Rental(String id, Vehicle v, Customer c, LocalDate start, LocalDate end) {
        this.rentalId = id;
        this.vehicle = v;
        this.customer = c;
        this.startDate = start;
        this.expectedReturnDate = end;
    }

    public void calculateCost() {
        long days = ChronoUnit.DAYS.between(startDate, expectedReturnDate);
        totalCost = days * vehicle.getRentalRate();
    }

    public void returnVehicle(LocalDate returnDate) {
        this.actualReturnDate = returnDate;

        long lateDays = ChronoUnit.DAYS.between(expectedReturnDate, returnDate);
        if (lateDays > 0) {
            lateFee = lateDays * 500;
        }

        finalAmount = totalCost + lateFee;
        vehicle.setStatus("Available");

        System.out.println("Final Amount: " + finalAmount);
    }

    public String getRentalId() {
        return rentalId;
    }
}