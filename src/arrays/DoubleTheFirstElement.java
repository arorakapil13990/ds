package arrays;

import java.util.Arrays;

/*
 *
 * Given an array of integers of size n. Assume ‘0’ as invalid number and all other as valid number.
 * Convert the array in such a way that if next number is a valid number and same as current number,
 * double its value and replace the next number with 0.
 * After the modification, rearrange the array such that all 0’s are shifted to the end.
 *
 * */
public class DoubleTheFirstElement {

    public static void rearrange(int a[]) {
        int i, count = 0, t;

        for (i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                //if ((i + 1) < a.length && a[i + 1] == a[i]) {
                if (i < a.length-1 && a[i + 1] == a[i]) {
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
