package arrays;

import java.util.HashMap;
import java.util.Map;

public class SumOfPairs {

    public void findPair(int a[], int sum) {
        Map<Integer, Integer> map = new HashMap<>();


        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(sum - a[i])) {
                System.out.println(a[map.get(sum - a[i])] + " " + a[i]);
            }
            map.put(a[i], i);
        }

    }
    static void pair() {
        int a[] = {11, 15, 6, 8, 9, 10};
        int num = 16;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            int rem = num - a[i];

            if (map.containsKey(a[i])) {
                System.out.println(rem + " " + a[i]);
                break;
            } else {
                map.put(rem, i);
            }

        }
    }

    public static void main(String[] args) {
        int a[] = {11, 15, 6, 8, 9, 10};
        SumOfPairs sp = new SumOfPairs();
        sp.findPair(a, 16);
    }
}
