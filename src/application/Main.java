package application;

import entities.CarRental;
import entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;
import model.services.TaxService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm"); // The letter H must be in uppercase

        System.out.println("ENTER RENTAL DATA");
        System.out.print("Car Model: ");
        String carModel = scanner.nextLine();
        System.out.print("Start Date (dd/mm/yyyy hh:mm): ");
        Date startDate = simpleDateFormat.parse(scanner.nextLine());
        System.out.print("Return Date (dd/mm/yyyy hh:mm): ");
        Date returnDate = simpleDateFormat.parse(scanner.nextLine());

        CarRental carRental1 = new CarRental(startDate, returnDate, new Vehicle(carModel));

        System.out.print("Enter price per hour: ");
        double pricePerHour = scanner.nextDouble();
        System.out.print("Enter price per day: ");
        double pricePerDay = scanner.nextDouble();

        RentalService rentalService1 = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());
        rentalService1.processInvoice(carRental1);

        System.out.println("---INVOICE---");
        System.out.println("Basic Payment: " + String.format("%.2f", carRental1.getInvoice().getBasicPayment()));
        System.out.println("Tax: " + String.format("%.2f", carRental1.getInvoice().getTax()));
        System.out.println("Total Payment: " + String.format("%.2f", carRental1.getInvoice().getTotalPayment()));

        scanner.close();
    }
}
