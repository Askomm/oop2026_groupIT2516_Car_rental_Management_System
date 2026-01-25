package edu.aitu.oop3;

import edu.aitu.oop3.db.DatabaseConnection;
import edu.aitu.oop3.service.*;

import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        try (Connection conn = DatabaseConnection.getConnection();
             Scanner sc = new Scanner(System.in)) {

            RentalService rentalService = new RentalService();
            CarInventoryService inventory = new CarInventoryService();

            System.out.println("=== Car Rental System ===");

            while (true) {
                System.out.println("""
                    1. Search cars
                    2. Create rental
                    3. Close rental
                    0. Exit
                    """);

                String choice = sc.nextLine();

                if (choice.equals("1")) {
                    System.out.print("Start date: ");
                    LocalDate s = LocalDate.parse(sc.nextLine());
                    System.out.print("End date: ");
                    LocalDate e = LocalDate.parse(sc.nextLine());

                    inventory.search(conn, Date.valueOf(s), Date.valueOf(e))
                            .forEach(System.out::println);
                }

                if (choice.equals("2")) {
                    System.out.print("Customer ID: ");
                    int cust = Integer.parseInt(sc.nextLine());
                    System.out.print("Car ID: ");
                    int car = Integer.parseInt(sc.nextLine());
                    System.out.print("Start date: ");
                    LocalDate s = LocalDate.parse(sc.nextLine());
                    System.out.print("End date: ");
                    LocalDate e = LocalDate.parse(sc.nextLine());

                    int id = rentalService.createRental(conn, car, cust, s, e);
                    System.out.println("Rental created. ID = " + id);
                }

                if (choice.equals("3")) {
                    System.out.print("Rental ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("Return date: ");
                    LocalDate r = LocalDate.parse(sc.nextLine());
                    System.out.print("Payment method: ");
                    String m = sc.nextLine();

                    rentalService.closeRental(conn, id, r, m);
                    System.out.println("Rental closed.");
                }

                if (choice.equals("0")) break;
            }
        }
    }
}
