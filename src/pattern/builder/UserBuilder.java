package pattern.builder;

public class UserBuilder {
    private final String firstName;
    private final String lastName;
    private int age;
    private String address;

    public UserBuilder(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public UserBuilder age(int age) {
        this.age = age;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public UserBuilder address(String address) {
        this.address = address;
        return this;
    }

    public User build(){
        return new User(this);
    }

}
