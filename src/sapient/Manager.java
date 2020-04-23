package sapient;

import java.io.IOException;
import java.util.stream.IntStream;

public class Manager extends Employee {
    protected int age = 40;
    protected static double salary = 4000.00;

    public Manager() {
        System.out.println("Child Constructor");
    }

    static {
        System.out.println("Child Static block");
    }

    {
        System.out.println("Child Instance block");
    }

    public static void demoMethodHiding() {
        System.out.println("From Manager");
    }

    public int getAge() {
        return age;
    }

    public final double getSalary() throws IOException {
        return salary;
    }

    public static void main(String[] args) {
        Employee e = new Manager();

        System.out.println(e.age);  // 30 no overriding on instance variable
        System.out.println(e.getAge()); // 40

        double startTime = System.currentTimeMillis();
        IntStream.range(1, 1000).forEach(i -> System.out.println(e.getSalary(i)));

        System.out.println(System.currentTimeMillis() - startTime);
        Employee.demoMethodHiding();
    }
}
