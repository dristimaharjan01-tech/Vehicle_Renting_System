import model.*;
import service.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        AuthService auth = new AuthService();
        VehicleService vs = new VehicleService();
        CustomerService cs = new CustomerService();
        RentalService rs = new RentalService();

        System.out.println("===== TESTING STARTED =====");

        // 1. Authentication Test
        System.out.println("\n--- Test 1: Login ---");
        auth.addUser(new Admin("A1", "admin", "1234"));
        auth.addUser(new Staff("S1", "staff", "1234"));

        User user = auth.login("admin", "1234"); // valid login

        // 2. Add Vehicle
        System.out.println("\n--- Test 2: Add Vehicle ---");
        Vehicle v1 = new Vehicle("V1", "Toyota", "Corolla", "Car", 2000);
        vs.addVehicle(v1);
        vs.displayVehicles();

        // 3. Add Customer
        System.out.println("\n--- Test 3: Add Customer ---");
        Customer c1 = new Customer("C1", "Ram");
        cs.addCustomer(c1);
        System.out.println(c1);

        // 4. Rent Vehicle
        System.out.println("\n--- Test 4: Rent Vehicle ---");
        rs.rentVehicle("R1", v1, c1,
                LocalDate.now(),
                LocalDate.now().plusDays(3));

        // Try renting again (edge case)
        System.out.println("\n--- Test 4.1: Rent Same Vehicle Again ---");
        rs.rentVehicle("R2", v1, c1,
                LocalDate.now(),
                LocalDate.now().plusDays(2));

        // 5. Return Vehicle
        System.out.println("\n--- Test 5: Return Vehicle (Late) ---");
        Rental r = rs.findRental("R1");
        r.returnVehicle(LocalDate.now().plusDays(5));

        System.out.println("\n===== TESTING COMPLETED =====");
    }
}