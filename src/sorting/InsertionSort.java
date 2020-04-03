package sorting;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int i, j, t;
        int a[] = {9,14,3,2,43,11,58,22};

        for (i = 0; i <= a.length; i++) {
            for (j = i - 1; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    t = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = t;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
