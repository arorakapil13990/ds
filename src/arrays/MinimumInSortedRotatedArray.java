package arrays;

import java.util.*;

// right element is less than the left one
// https://www.youtube.com/watch?v=IzHR_U8Ly6c

// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/submissions/
public class MinimumInSortedRotatedArray {
    public static int findMin(int[] a) {

        if (a.length == 0) return -1;
        if (a.length == 1) return a[0];

        int left = 0;
        int right = a.length - 1;
        int mid;

        while (left < right) {
            mid = left + (right - left) / 2;

            if (mid > 0 && a[mid] < a[mid - 1]) {
                return a[mid];
                // && a[mid] > a[right] i.e not sorted on the right side
            } else if (a[left] <= a[mid] && a[mid] > a[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return a[left];
    }

    // Driver program to test above functions
    public static void main(String[] args) {
        int a[] = {11, 13, 15, 17};
        System.out.println("The minimum element is "
                + findMin(a));
        System.out.println("The minimum element is "
                + findMinimum(a));
    }

    // this also works and it's easy.. same as SearchElementInRotatedSortedArray
    public static int findMinimum(int[] a) {
        int left = 0, right = a.length - 1;
        if (a.length == 0) return -1;
        if (a.length == 1) return a[0];

        int mid = 0;

        while (left < right) {
            mid = left + (right - left) / 2;
            if (a[mid] > a[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return a[left];
    }
}
