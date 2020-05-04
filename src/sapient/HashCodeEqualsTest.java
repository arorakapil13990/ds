package sapient;

import java.util.HashMap;
import java.util.Map;



public class HashCodeEqualsTest {

    public static void main(String[] args) {

        Employee e1 = new Employee(1,"kapil");
        Employee e2 = new Employee(1,"kapil");

        Map<Employee,String> map = new HashMap<>();

        map.put(e1,"A");
        map.put(e2,"B");

        map.entrySet().stream().forEach(e -> {
            System.out.println(e.getKey() + " " + e.getValue());
        });
    }
}
