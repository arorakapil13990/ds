package sapient;


import java.util.List;
import java.util.Objects;

public class Employee implements Comparable<Employee> {

    private int id;
    private String name;
    public int age = 30;
    public static double salary = 3000.00;
    private List<Address> address;


    public Employee( int age,String name) {
        this.name = name;
        this.age = age;
    }

    public Employee(String name) {
        this.name = name;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public Employee() {
        System.out.println("Parent Constructor");
    }

    static {
        System.out.println("Parent Static block");
    }

    {
        System.out.println("Parent Instance block");
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void demoMethodHiding() {
        System.out.println("From Employee");
    }



    public int getAge() {
        return age;
    }

    public  double getSalary() throws Exception {
        return (salary * age) / 31;
    }

    public double getSalary(double da) {
        return da + (salary * age) / 31;
    }

    @Override
    public int compareTo(Employee e) {
        return e.getName().compareTo(this.getName());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
