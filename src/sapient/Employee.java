package sapient;


public class Employee implements Comparable<Employee> {

    private String name;
    public int age = 30;
    public static double salary = 3000.00;

    public Employee() {
        System.out.println("Parent Constructor");
    }

    static {
        System.out.println("Parent Static block");
    }

    {
        System.out.println("Parent Instance block");
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
}
