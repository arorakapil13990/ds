package sapient;

import java.util.Iterator;
import java.util.Map;

public class MapIteration {
    public static void main(String[] args) {
        Map<String, String> map = Map.of("Key 1", "Value 1", "Key 2", "Value 2");

        map.forEach((k, v) -> System.out.print(k + " " + v + " "));  // lambda
        System.out.println();

        map.entrySet().stream().forEach(e->{System.out.print(e.getKey() + " " + e.getValue() + " ");}); // stream

        System.out.println();

        // iterators
        Iterator<Map.Entry<String,String>> itr = map.entrySet().iterator();
        while (itr.hasNext()){
            Map.Entry<String,String> entry = itr.next();
            System.out.print(entry.getKey() + " " + entry.getValue() + " ");
        }

        System.out.println();

        // foreach
        for(Map.Entry<String,String> entry : map.entrySet()){
            System.out.print(entry.getKey() + " " + entry.getValue() + " ");
        }
    }

}
