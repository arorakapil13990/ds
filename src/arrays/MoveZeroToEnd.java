package arrays;

import java.util.Arrays;

public class MoveZeroToEnd {


    public static void moveZerosToEnd(int a[]) {   // the order is not maintained

        int left = 0, right = a.length - 1;

        while (left < right) {
            while (a[left] > 0) {
                left++;
            }
            while (a[right] == 0) {
                right--;
            }
            if (left < right) {
                swap(a, left, right);
                left++;
                right--;
            }

        }
    }

    public static void rearrange(int a[]) { // the order is maintained

        int count = 0, i;

        for (i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                a[count++] = a[i];
            }
        }
        while (count < a.length) {
            a[count++] = 0;
        }
        System.out.println(Arrays.toString(a));

    }

    public static void rearrangeInSingeTraversal(int a[]) {

        int i, count = 0, t;

        for (i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                t = a[count];
                a[count] = a[i];
                a[i] = t;
                count++;
            }
        }

        System.out.println(Arrays.toString(a));
    }

    private static void swap(int a[], int left, int right) {
        int t;
        t = a[left];
        a[left] = a[right];
        a[right] = t;
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 0, 0, 0, 3, 6};
        moveZerosToEnd(a);
        System.out.println(Arrays.toString(a));
        int b[] = {1, 2, 0, 0, 0, 3, 6};
        rearrange(b);
        int c[] = {1, 2, 0, 0, 0, 3, 6};
        rearrangeInSingeTraversal(c);
    }
}
