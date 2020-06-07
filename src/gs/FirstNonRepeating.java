package gs;

import java.util.*;

/**
 * Solution:
 * Maintain a linked list of characters as they appear in the stream.
 * Maintain a set of characters which have already appeared
 * For the character being checked, if already present in set, remove it from the list
 * Return the first character present in the list
 **/

public class FirstNonRepeating {


    private static Character FNR(String str) {

        List<Character> list = new LinkedList<>();
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            if (set.add(ch)) {
                list.add(ch);
            } else {
                list.remove(ch);
            }
        }
        return list.get(0);
    }


    private static char firstNonRepeating(String str) {
        char[] ch = new char[256];
        int index = -1;
        for (int i = 0; i < str.length(); i++) {
            ch[str.charAt(i)]++;
        }

        for (int i = 0; i < str.length(); i++) {
            if (ch[str.charAt(i)] == 1) {
                index = i;
                break;
            }
        }
        return str.charAt(index);
    }


    static char test(String str) {
        char ch[] = new char[26];
        str = str.toUpperCase();
        int index = -1;
        for (int i = 0; i < str.length(); i++) {
            int ascii = str.charAt(i) - 65;
            ch[ascii]++;
        }

        for (int i = 0; i < str.length(); i++) {
            int ascii = str.charAt(i) - 65;
            if (ch[ascii] == 1) {
                index = i;
                break;
            }
        }
        return str.charAt(index);

    }

    public static char getFirstNonRepeatedChar(String str) {
        Map<Character, Integer> counts = new LinkedHashMap<>(str.length());
        for (char c : str.toCharArray()) {
            counts.put(c, counts.containsKey(c) ? counts.get(c) + 1 : 1);
        }
        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        throw new RuntimeException("didn't find any non repeated Character");
    }


    public static void main(String[] args) {
        boolean result = true;
        String[] inputs = {"apple", "racecars", "ababdc"};
        char[] outputs = {'a', 'e', 'd'};

        for (int i = 0; i < inputs.length; i++) {
            result = result && (FNR(inputs[i]) == outputs[i]);
        }
        if (result) {
            System.out.println("Passed");
        } else {
            System.out.println("Fail");
        }


        for (int i = 0; i < inputs.length; i++) {
            result = result && (firstNonRepeating(inputs[i]) == outputs[i]);
        }
        if (result) {
            System.out.println("Passed");
        } else {
            System.out.println("Fail");
        }

        System.out.println(test("apple"));
    }


}
