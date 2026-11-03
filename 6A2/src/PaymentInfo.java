package telecom.models;

import java.util.Date;

public class PaymentInfo {
    public Date date;
    public double amount;
    public String description;

    public PaymentInfo(double amount, String description) {
        this.date = new Date();
        this.amount = amount;
        this.description = description;
    }
}