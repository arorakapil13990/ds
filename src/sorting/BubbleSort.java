package sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int i, j, t;
        int a[] = {50, 10, 40, 60, 80, 20, 30};

        for (i = 0; i < a.length; i++) {
            for (j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
