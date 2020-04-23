package sapient.strategy;

import java.util.Date;

public class CreditCardPaymentMethod implements PaymentMethod {

    private int creditCardNo;
    private String name;
    private Date expiryDate;

    public CreditCardPaymentMethod(final int creditCardNo, final String name, final Date expiryDate) {
        this.creditCardNo = creditCardNo;
        this.name = name;
        this.expiryDate = expiryDate;
    }

    @Override
    public void pay(final double amount) {
        System.out.println("Paid: " + amount + " with Credit Card: " + this);
    }

    public int getCreditCardNo() {
        return creditCardNo;
    }

    public String getName() {
        return name;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    //Don't do it in actual systems
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CreditCardPaymentMethod{");
        sb.append("creditCardNo=").append(creditCardNo);
        sb.append(", name='").append(name).append('\'');
        sb.append(", expiryDate=").append(expiryDate);
        sb.append('}');
        return sb.toString();
    }
}