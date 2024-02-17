package sapient.designPatterns.builder;

public class User {

    private String firstName;
    private String lastName;

    private String email;
    private String fax;


    public User(Builder builder) {
        this.firstName = builder.getFirstName();
        this.lastName = builder.getLastName();
        this.email = builder.getEmail();
        this.fax = builder.getFax();
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", fax='" + fax + '\'' +
                '}';
    }

    public static class Builder {
        private String firstName;
        private String lastName;

        private String email;
        private String fax;

        public Builder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getEmail() {
            return email;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public String getFax() {
            return fax;
        }

        public Builder setFax(String fax) {
            this.fax = fax;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    public static void main(String[] args) {
        User user1 = new User.Builder("Kapil", "Arora").setEmail("a@a.com").build();
        User user2 = new User.Builder("Jasleen", "Arora").setFax("f@f.com").build();

        System.out.println(user1);
        System.out.println("---------");
        System.out.println(user2);
    }
}
