package arrays;

import java.util.HashMap;
import java.util.Map;

public class FindPairInSortedRotatedArray {

    private void findPair(int[] arr_int, int x) {
        int k, n = arr_int.length;
        for (k = 0; k < n - 1; k++)
            if (arr_int[k] > arr_int[k + 1])
                break;

        boolean isFound = false;

        int l = (k + 1) % n;  // points to minimum element

        int r = k; // points to maximum element

        while (l != r) {
            if (arr_int[l] + arr_int[r] == x) {
                isFound = true;
                break;
            }
            if (arr_int[l] + arr_int[r] < x)
                l = (l + 1) % n; // move to higher sum
            else
                r = (n + r - 1) % n;  // move to lower sum
        }

        if (isFound) {
            System.out.println(arr_int[l] + " " + arr_int[r]);
        } else {
            System.out.println("Not found");
        }

    }


    /*
    5 -> 0
    1 -> 1
    10 -> 2
    8 -> 3
    7 -> 4
    6 -> 5
     */

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
        FindPairInSortedRotatedArray s = new FindPairInSortedRotatedArray();
        s.findPair(a, 16);
        pair();
    }


}
