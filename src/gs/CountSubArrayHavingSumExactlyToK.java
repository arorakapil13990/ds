package gs;

// Java program to find number of subarrays
// with sum exactly equal to k.

import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CountSubArrayHavingSumExactlyToK {

    // Function to find number of subarrays
    // with sum exactly equal to k.
    static int findSubarraySum(int arr[], int n, int sum) {
        // HashMap to store number of subarrays
        // starting from index zero having
        // particular value of sum.
        HashMap<Integer, Integer> prevSum = new HashMap<>();
        prevSum.put(0, -1);
        int res = 0;

        // Sum of elements so far.
        int currsum = 0;

        for (int i = 0; i < n; i++) {

            // Add current element to sum so far.
            currsum += arr[i];

            // If currsum is equal to desired sum,
            // then a new subarray is found. So
            // increase count of subarrays.
            if (currsum == sum)
                res++;

            // currsum exceeds given sum by currsum
            // - sum. Find number of subarrays having
            // this sum and exclude those subarrays
            // from currsum by increasing count by
            // same amount.
            if (prevSum.containsKey(currsum - sum)) {
                printSubarray(arr, prevSum.get(currsum - sum) + 1, i);
                res += prevSum.get(currsum - sum);
            }


            // Add currsum value to count of
            // different values of sum.
            Integer count = prevSum.get(currsum);
            if (count == null)
                prevSum.put(currsum, 1);
            else
                prevSum.put(currsum, count + 1);
        }

        return res;
    }

    public static void printSubarray(int[] A, int i, int j) {
        System.out.println(IntStream.range(i, j + 1)
                .mapToObj(k -> A[k])
                .collect(Collectors.toList()));
    }

    public static void main(String[] args) {

        int arr[] = {9, 4, 20, 3, 10, 5};
        int sum = 33;
        int n = arr.length;
        System.out.println(findSubarraySum(arr, n, sum));
    }
}

// This code is contributed by Rituraj Jain

