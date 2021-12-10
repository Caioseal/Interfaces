package entities;

public class Invoice {

    //Attributes
    private Double basicPayment;
    private Double tax;

    //Constructor
    public Invoice(double basicPayment, Double tax) {
        this.basicPayment = basicPayment;
        this.tax = tax;
    }

    //Getter and Setter
    public double getBasicPayment() {
        return basicPayment;
    }

    public void setBasicPayment(double basicPayment) {
        this.basicPayment = basicPayment;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    //Functions
    public Double getTotalPayment() {
        return getBasicPayment() + getTax();
    }
}