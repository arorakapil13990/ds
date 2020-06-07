import java.util.Date;

public class Customer {

    private int id;
    private String name;
    private String phoneNumber;
    private String visaNumber;
    private String passportNumber;
    private Date passportExpiryDate;
    private Date visaExpiryDate;


    public Customer(CustomerBuilder builder) {
        this.passportExpiryDate = builder.getPassportExpiryDate();
        this.id = builder.getId();
        this.name = builder.getName();
        this.phoneNumber = builder.getPhoneNumber();
        this.visaNumber = builder.getVisaNumber();
        this.visaExpiryDate = builder.getVisaExpiryDate();
        this.passportNumber= builder.getPassportNumber();
    }


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", visaNumber='" + visaNumber + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", passportExpiryDate=" + passportExpiryDate +
                ", visaExpiryDate=" + visaExpiryDate +
                '}';
    }


    public static void main(String[] args) {
        Customer internationalCustomer = new CustomerBuilder(1,"kapil").setPassportNumber("ABC")
                .setPassportExpiryDate(new Date()).setVisaExpiryDate(new Date()).build();


        Customer domesticCustomer = new CustomerBuilder(1,"kapil").setPhoneNumber("12345").build();

        System.out.println("International Customer :: " + internationalCustomer);
        System.out.println("-----------------------");
        System.out.println("Domestic Customer :: " + domesticCustomer);

    }
}
