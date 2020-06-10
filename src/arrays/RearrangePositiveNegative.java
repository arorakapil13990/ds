package arrays;

import java.util.Arrays;

public class RearrangePositiveNegative {

    // order not maintained for +ve number
    static void rearrange() {
        int a[] = {-12, 11, -13, -5, 6, -7, 5, -3, -6};

        int i, j = 0, t;

        for (i = 0; i < a.length; i++) {
            if (a[i] < 0) {
                t = a[j];
                a[j] = a[i];
                a[i] = t;
                j++;
            }
        }
        System.out.println(Arrays.toString(a));
    }


    public static void reverse(int a[], int l, int r) {
        if (l < r) {
            int mid = (l + (r - 1)) / 2;
            reverse(a, l, mid);
            reverse(a, mid + 1, r);
            merge(a, l, mid, r);
        }
    }

    public static void merge(int a[], int l, int mid, int r) {

        int l1 = mid - l + 1;
        int l2 = r - mid;

        int n1[] = new int[l1];
        int n2[] = new int[l2];

        for (int i = 0; i < l1; i++)
            n1[i] = a[l + i];
        for (int j = 0; j < l2; j++)
            n2[j] = a[mid + 1 + j];

        // copy negative number
        int k = l;
        for (int i = 0; i < l1; i++) {
            if (n1[i] < 0)
                a[k++] = n1[i];
        }

        for (int i = 0; i < l2; i++) {
            if (n2[i] < 0)
                a[k++] = n2[i];
        }

        for (int i = 0; i < l1; i++) {
            if (n1[i] > 0)
                a[k++] = n1[i];
        }

        for (int i = 0; i < l2; i++) {
            if (n2[i] > 0)
                a[k++] = n2[i];
        }


    }

    public static void main(String[] args) {

        int arr[] = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
        reverse(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        rearrange();

    }
}
