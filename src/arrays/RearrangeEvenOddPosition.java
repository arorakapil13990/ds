package arrays;

import java.util.Arrays;

// Rearrange array such that even positioned are greater than odd

public class RearrangeEvenOddPosition {

    public static void reassign(int a[]) {

        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
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
        int a[] = {1, 2, 3, 4, 5};
        reassign(a);
    }
}
