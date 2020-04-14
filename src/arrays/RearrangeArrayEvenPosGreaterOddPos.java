package arrays;

import java.util.Arrays;

public class RearrangeArrayEvenPosGreaterOddPos {

    public static void main(String[] args) {

        int a[] = {9, 8, 13, 2, 19, 14};
        int b[] = new int[a.length];
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        int mid = a.length % 2 == 0 ? a.length / 2 : a.length / 2 + 1;
        int k = mid - 1;  // k = 4
        for (int i = 0; i < a.length; i++) {
            if (i % 2 == 0) {
                b[i] = a[k];
                k--;
            } else {
                b[i] = a[mid];
                mid++;
            }
        }
        System.out.println(Arrays.toString(b));
    }
}
