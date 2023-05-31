package sapient;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {

        Employee employee = new Employee("A");

        Employee employee1 = new Employee("A");

        Employee employee2 = new Employee("A");

        Employee employee3 = new Employee("A");

        List<Employee> list = new ArrayList<>();
        list.add(employee);
        list.add(employee1);
        list.add(employee2);
        list.add(employee3);


        List<String> names = list.stream().map(Employee::getName).distinct().collect(Collectors.toList());
        names.forEach(System.out::println);
    }

}