package arrays;

import java.util.Arrays;

public class RearrangeEvenOddPosition {

    public static void reassign(int a[]) {

        Arrays.sort(a);

        int i, t, r = a.length - 1;

        for (i = 1; i < a.length; i = i + 2) {
            t = a[i];
            a[i] = a[r];
            a[r] = t;
            r--;
        }
        System.out.println(Arrays.toString(a));

    }

    public static void main(String[] args) {
        int a[] = {1, 3, 2, 2, 5};
        reassign(a);
    }
}
