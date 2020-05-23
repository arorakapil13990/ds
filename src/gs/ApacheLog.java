package gs;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ApacheLog {

    public static Map.Entry<String, Integer> findTopIpaddress(String[] inputs) {

        Map<String, Integer> map = new LinkedHashMap<>();
        int i;
        for (i = 0; i < inputs.length; i++) {
            String[] arr = inputs[i].split("-");
            if (map.containsKey(arr[0])) {
                map.put(arr[0], map.get(arr[0]) + 1);
            } else {
                map.put(arr[0], 1);
            }
        }

        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)).entrySet().stream().findFirst().get();

    }


    public static void main(String[] args) {

        String input[] = new String[]{
                "10.0.0.1 - log entry 1 11",
                "10.0.0.1 - log entry 2 213",
                "10.0.0.2 - log entry 133132"};
        String result = findTopIpaddress(input).getKey();

        if (result.contains("10.0.0.1")) {
            System.out.println("Test passed");

        } else {
            System.out.println("Test failed");

        }


    }
}
