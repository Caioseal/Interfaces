package model.services;

import entities.CarRental;
import entities.Invoice;

public class RentalService {

    //Atributes
    private Double pricePerHour;
    private Double pricePerDay;
    private TaxService taxService;

    //Constructor
    public RentalService(double pricePerHour, double pricePerDay, TaxService taxService) {
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.taxService = taxService;
    }

    public void processInvoice(CarRental carRental) {
        long t1 = carRental.getStart().getTime();
        long t2 = carRental.getFinish().getTime();
        double hours = (double) (t2 - t1) / 1000 / 60 / 60;

        double basicPayment;
        if (hours <= 12.00) {
            basicPayment = Math.ceil(hours) * pricePerHour;
        } else {
            basicPayment = Math.ceil(hours / 24) * pricePerDay;
        }

        double tax = taxService.tax(basicPayment);
        carRental.setInvoice(new Invoice(basicPayment, tax));
    }
}
