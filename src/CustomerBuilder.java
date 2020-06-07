import java.util.Date;

public class CustomerBuilder {

    private int id;
    private String name;
    private String phoneNumber;

    // optional
    private String visaNumber;
    private String passportNumber;
    private Date passportExpiryDate;
    private Date visaExpiryDate;

    public CustomerBuilder(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getVisaNumber() {
        return visaNumber;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public Date getPassportExpiryDate() {
        return passportExpiryDate;
    }

    public Date getVisaExpiryDate() {
        return visaExpiryDate;
    }

    public Customer build() {
        return new Customer(this);
    }



    public CustomerBuilder setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }


    public CustomerBuilder setVisaNumber(String visaNumber) {
        this.visaNumber = visaNumber;
        return this;
    }


    public CustomerBuilder setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
        return this;
    }

    public CustomerBuilder setPassportExpiryDate(Date passportExpiryDate) {
        this.passportExpiryDate = passportExpiryDate;
        return this;
    }

    public CustomerBuilder setVisaExpiryDate(Date visaExpiryDate) {
        this.visaExpiryDate = visaExpiryDate;
        return this;
    }


}
