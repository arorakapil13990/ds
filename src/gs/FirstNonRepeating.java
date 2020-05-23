package gs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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
    }


}
