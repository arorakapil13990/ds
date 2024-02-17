package sapient.java8;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DeveloperTest {

    public static void main(String[] args) {
        List<Developer> result = new ArrayList<>();

        result.add(new Developer("mkyong", new BigDecimal("70000"), 33));
        result.add(new Developer("alvin", new BigDecimal("80000"), 20));
        result.add(new Developer("jason", new BigDecimal("100000"), 10));
        result.add(new Developer("iris", new BigDecimal("170000"), 55));

        //result.sort((d1,d2) -> d1.getName().compareTo(d2.getName()));

        result.sort((d1,d2) -> d1.getAge()- d2.getAge());

        result.forEach(System.out::println);
    }
}
