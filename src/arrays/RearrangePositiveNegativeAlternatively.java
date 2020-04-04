package arrays;

import java.util.Arrays;

public class RearrangePositiveNegativeAlternatively {

    public static void rearrange(int arr[], int n) {
        //move all -tve number to the left
        int i = -1, temp = 0;  // temp is pivot
        for (int j = 0; j < n; j++) {
            if (arr[j] < 0) {
                i++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Now all positive numbers are at end and negative numbers at
        // the beginning of array. Initialize indexes for starting point
        // of positive and negative numbers to be swapped
        int pos = i + 1, neg = 0;

        // Increment the negative index by 2 and positive index by 1, i.e.,
        // swap every alternate negative number with next positive number
        while (pos < n && neg < pos && arr[neg] < 0) {
            temp = arr[neg];
            arr[neg] = arr[pos];
            arr[pos] = temp;
            pos++;
            neg += 2;
        }
    }


    public static void main(String[] args) {
        int a[] = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
        rearrange(a, a.length);
        System.out.println(Arrays.toString(a));
    }

}





