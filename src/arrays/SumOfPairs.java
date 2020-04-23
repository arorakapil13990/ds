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


    public static void main(String[] args) {
        int a[] = {10, 10, 30, 30};
        SumOfPairs sp = new SumOfPairs();
        sp.findPair(a, 40);

    }
}
