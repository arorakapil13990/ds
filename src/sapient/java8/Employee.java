package sapient.java8;


interface EmployeeFactoryWithName {
    Employee getEmployee(String name);
}

interface EmployeeFactoryWithoutName {
    Employee getEmployee();
}

public class Employee {

    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public Employee() {
    }


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {

        EmployeeFactoryWithName factoryWithName = Employee::new;
        System.out.println(factoryWithName.getEmployee("kapil"));

        EmployeeFactoryWithoutName factoryWithoutName = Employee::new;
        System.out.println(factoryWithoutName.getEmployee());
    }
}
