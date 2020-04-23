package sapient;

import java.util.*;


public class FailFastFailSafe {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("first");
        list.add("second");
        list.add("third");
        list.removeIf(e -> e.equalsIgnoreCase("second"));  // fail safe
        System.out.println(list.toString());


        Map<String, String> cityCode = new HashMap<String, String>();
        cityCode.put("Delhi", "India");
        cityCode.put("Moscow", "Russia");
        cityCode.put("New York", "USA");

        Iterator iterator = cityCode.keySet().iterator();

        while (iterator.hasNext()) {
            System.out.println(cityCode.get(iterator.next()));

            // adding an element to Map
            // exception will be thrown on next call
            // of next() method.
            cityCode.put("Istanbul", "Turkey");
        }
    }
}
