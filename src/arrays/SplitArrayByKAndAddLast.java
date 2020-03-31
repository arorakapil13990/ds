package arrays;

import java.util.Arrays;

public class SplitArrayByKAndAddLast {

    private static void reverse(int a[], int d, int n) {
        while (d < n) {
            int temp = a[d];
            a[d] = a[n];
            a[n] = temp;
            d++;
            n--;
        }
    }


    public static void main(String[] args) {

        int[] arr = {3, 1, 2};

        int k = 1;

        reverse(arr, 0, k - 1);
        reverse(arr, k, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
        print(arr);
    }

    public static void print(int a[]) {
        Arrays.stream(a).forEach(v -> {
            System.out.print(v + " ");
        });
        System.out.println();
    }
}
