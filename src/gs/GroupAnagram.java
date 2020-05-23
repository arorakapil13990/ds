package gs;

import java.util.*;

public class GroupAnagram {

    private static void group(String input) {
        Map<String, List<String>> map = new HashMap<>();
        String[] arr = input.split(" ");

        for (int i = 0; i < arr.length; i++) {
            char[] ch = arr[i].toCharArray();
            Arrays.sort(ch);

            if (map.containsKey(String.valueOf(ch))) {
                map.get(String.valueOf(ch)).add(arr[i]);
            } else {
                List<String> words = new ArrayList<>();
                words.add(arr[i]);
                map.put(String.valueOf(ch), words);
            }

        }


        map.entrySet().stream().forEach(e -> {
            System.out.print(e.getKey() + " " + e.getValue());
            System.out.println();
        });
    }

    private static void groupAnagram(String str) {

        Map<String, List<String>> map = new HashMap<>();

        Arrays.stream(str.split(" ")).forEach(e -> {
            char[] arr = e.toCharArray();
            Arrays.sort(arr);
            List<String> words = map.get(String.valueOf(arr));
            if (words == null) {
                words = new ArrayList<>();
            }
            words.add(e);
            map.put(String.valueOf(arr), words);

        });

        map.values().stream().forEach(System.out::println);

    }


    public static void main(String[] args) {
        String input = "cat dog tac sat tas god dog";
        group(input);
    }
}
