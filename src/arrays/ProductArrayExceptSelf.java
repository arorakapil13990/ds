package arrays;

import java.util.Arrays;

// https://leetcode.com/problems/product-of-array-except-self/submissions/
// https://www.youtube.com/watch?v=tSRFtR3pv74

public class ProductArrayExceptSelf {

    public static void main(String[] args) {
        Arrays.stream(prod(new int[]{1, 2, 3, 4})).forEach(System.out::println);
    }

    static int[] prod(int[] a) {
        int n = a.length;
        int[] out = new int[n];

        int[] left_prod = new int[n];
        int[] right_prod = new int[n];

        int i;

        // both left and right of zeroth is 1
        left_prod[0] = 1;
        right_prod[n - 1] = 1;

        for (i = 1; i < n; i++) {
            left_prod[i] = left_prod[i - 1] * a[i - 1];
        }
        for (i = n - 2; i >= 0; i--) {
            right_prod[i] = right_prod[i + 1] * a[i + 1];
        }

        for (i = 0; i < n; i++) {
            out[i] = left_prod[i] * right_prod[i];
        }

        return out;
    }
}
