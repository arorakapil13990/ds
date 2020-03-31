package arrays;

import java.util.Arrays;

public class RightRotationByK {

    public void rotate(int a[], int k){

        reverse(a,0,a.length-1);
        reverse(a,k,a.length-1);
        reverse(a,0,k-1);

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


    public void print(int a[]) {
        Arrays.stream(a).forEach(v -> {
            System.out.print(v + " ");
        });
        System.out.println();
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        new RightRotationByK().rotate(a,3);
    }
}
