package pattern.builder;

public class User {

    private String firstName;
    private String lastName;
    private int age;
    private String address;

    public User() {
    }

    public User(UserBuilder userBuilder) {
        this.firstName = userBuilder.getFirstName();
        this.lastName = userBuilder.getLastName();
        this.address = userBuilder.getAddress();
        this.age = userBuilder.getAge();
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    public static void main(String[] args) {
        User user1 = new UserBuilder("Kapil", "Arora").age(30).build();
        User user2 = new UserBuilder("Jasleen", "Arora").age(27).address("129 BMK").build();

        System.out.println(user1);
        System.out.println("---------");
        System.out.println(user2);
       // System.out.println(User.getBuilder().address("129 BMK").firstName("kapil").build());
    }

    private static class Builder {
        private String firstName;
        private String lastName;
        private int age;
        private String address;

        public Builder() {
        }

        public Builder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public String getLastName() {
            return lastName;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public int getAge() {
            return age;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public String getAddress() {
            return address;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public User build() {
            User user = new User();
            user.firstName = this.firstName;
            user.lastName = this.lastName;
            user.age = this.age;
            user.address = this.address;
            return user;
        }
    }
}
