package arrays;

import java.util.Arrays;

public class RearrangeArrayEvenPosGreaterOddPos {

    public static void main(String[] args) {

        int a[] = {1, 2, 1, 4, 5, 6, 8, 8};
        int b[] = new int[a.length];
        Arrays.sort(a);

        int mid = a.length % 2 == 0 ? a.length / 2 : a.length / 2 + 1;
        int k=mid-1;  // k = 4
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
