package arrays;


//Rearrange an array such that ‘arr[j]’ becomes ‘i’ if ‘arr[i]’ is ‘j’

/*
*
* Input: arr[]  = {1, 3, 0, 2};
Output: arr[] = {2, 0, 3, 1};
Explanation for the above output.
Since arr[0] is 1, arr[1] is changed to 0
Since arr[1] is 3, arr[3] is changed to 1
Since arr[2] is 0, arr[0] is changed to 2
Since arr[3] is 2, arr[2] is changed to 3
*
*
* */


import java.util.Arrays;

public class RearrangeArray {

    public static void main(String[] args) {
        rearrange(new int[]{1, 3, 0, 2},4);
    }


    /*
    * Geeksforgeeks
    *
    *   The idea is to store each element’s new and old value as quotient and remainder of n,
    *   respectively (n being the size of the array).
        For example, Suppose an element’s new value is 2, the old value is 1 and n is 3,
        then the element’s value is stored as 1 + 2*3 = 7.
        We can retrieve its old value by 7%3 = 1 and its new value by 7/3 = 2.
    * */
    static void rearrange(int arr[], int n) {
        for (int i = 0; i < n; i++) {

            // retrieving old value and
            // storing with the new one
            arr[arr[i] % n] += i * n;
        }

        for (int i = 0; i < n; i++) {

            // retrieving new value
            arr[i] /= n;
        }
        System.out.println(Arrays.toString(arr));
    }

}
