package sapient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableComparatorTest {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();

        Employee e1 = new Employee();
        e1.setName("ZZ");
        Employee e2 = new Employee();
        e2.setName("BB");
        Employee e3 = new Employee();
        e3.setName("CC");

        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);

        Collections.sort(employeeList);

        System.out.println(employeeList.toString());

        Collections.sort(employeeList,new NameComparator());
        System.out.println(employeeList.toString());
    }
}
