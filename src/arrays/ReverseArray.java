package arrays;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5};

        int left = 0, right = a.length - 1;
        int temp = 0;
        while (left < right) {
            temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            left++;
            right--;
        }

        System.out.println(Arrays.toString(a));
    }
}
