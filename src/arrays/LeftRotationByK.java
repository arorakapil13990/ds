package arrays;

import java.util.Arrays;

public class LeftRotationByK {

    public void leftRotate(int a[], int k) {

        int i;
        int arr[] = new int[k];
        for (i = 0; i < k; i++) {
            arr[i] = a[i];
        }

        for (i = 0; i < a.length - k; i++) {
            a[i] = a[i + k];
        }
        int j = 0;
        for (i = a.length - k; i < a.length; i++) {
            a[i] = arr[j];
            j++;
        }

        print(a);
    }


    public void reverse(int a[], int d, int n) {

        while (d < n) {
            int temp = a[d];
            a[d] = a[n];
            a[n] = temp;
            d++;
            n--;
        }

    }


    /*
     * create A = 1 to n-d and B = n-d to n-1
     * reverse Ar and Br
     * reverse whole ArBr
     * */

    public void leftRotateByK(int a[], int k) {

        reverse(a, 0, k - 1);
        reverse(a, k, a.length - 1);
        reverse(a, 0, a.length - 1);
        print(a);

    }


    public void print(int a[]) {
        Arrays.stream(a).forEach(v -> {
            System.out.print(v + " ");
        });
        System.out.println();
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5, 6, 7};
        LeftRotationByK l = new LeftRotationByK();
        int b[] = {1, 2, 3, 4, 5, 6, 7};
        l.leftRotate(a, 2);
        l.leftRotateByK(b, 2);
    }
}
