package arrays;

import java.util.Arrays;

public class DoubleTheFirstElement {

    public static void rearrange(int a[]) {
        int i, count = 0, t;

        for (i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                if ((i + 1) < a.length && a[i + 1] == a[i]) {
                    a[i + 1] = 0;
                    a[i] = a[i] * 2;
                }

                t = a[count];
                a[count] = a[i];
                a[i] = t;
                count++;
            }
        }
        System.out.println(Arrays.toString(a));
    }


    public static void main(String[] args) {
        int a[] = {2, 2, 0, 4, 0, 8};
        rearrange(a);
    }
}
