package arrays;

import java.util.Arrays;

public class RearrangeSmallestLargest {


    private static void rightShiftByOne(int a[], int l, int r) {
        int last = a[r];

        for (int i = r; i > l; i--) {
            a[i] = a[i - 1];
        }
        a[l] = last;
    }


    private static void optimizeShift() {
        int a[] = {5, 8, 1, 4, 2, 9, 3, 7, 6};
        Arrays.sort(a);

        int temp[] = new int[a.length];

        int l = 0, r = a.length - 1, c = 0;
        while (l <= r) {
            if (c % 2 == 0) {
                temp[c] = a[l];
                l++;
            } else {
                temp[c] = a[r];
                r--;
            }
            c++;
        }
        System.out.println(Arrays.toString(temp));
    }


    public static void rearrange(int a[]) {
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        int i, j;

        for (i = 0; i < a.length; i++) {
            if (i % 2 != 0) {
                rightShiftByOne(a, i, a.length - 1);
            }
        }
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        int a[] = {5, 8, 1, 4, 2, 9, 3, 7, 6};
        rearrange(a);
        optimizeShift();
    }
}
