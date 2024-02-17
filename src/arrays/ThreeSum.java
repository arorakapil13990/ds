package arrays;

// https://www.youtube.com/watch?v=qJSPYnS35SE

// https://leetcode.com/problems/3sum/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    static List<List<Integer>> findSum(int[] a) {
        Arrays.sort(a);
        List<List<Integer>> output = new ArrayList<>();
        int i;
        for (i = 0; i < a.length - 2; i++) {
            if (i == 0 || (a[i] != a[i - 1])) { // skip duplicates
                // find the pair.. we have one value i.e a[i]
                int low = i + 1;
                int high = a.length - 1;
                int sum = 0 - a[i];
                while (low < high) {
                    if (a[low] + a[high] == sum) {
                        output.add(Arrays.asList(a[i], a[low], a[high]));
                        while (low < high && a[low] == a[low + 1]) low++; // we don't want duplicates in the resulting array
                        while (low < high && a[high] == a[high - 1]) high--;
                        low++;
                        high--;
                    } else if (a[low] + a[high] < sum) {
                        low++;
                    }else {
                        high--;
                    }
                }
            }
        }

        return output;
    }


    public static void main(String[] args) {
        int[] a = {-1, 0, 1, 2, -1, -4};
        findSum(a).stream().forEach(System.out::println);
    }
}
