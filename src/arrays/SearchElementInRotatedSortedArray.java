package arrays;

// https://www.youtube.com/watch?v=QdVrY3stDD4
// https://leetcode.com/problems/search-in-rotated-sorted-array/submissions/
public class SearchElementInRotatedSortedArray {

    public void isPresent(int a[], int element) {
        int i;
        for (i = 0; i < a.length; i++) {
            if (a[i] > a[i + 1]) {
                break;
            }
        }
        System.out.println(binarySearch(a, 0, i, element) || binarySearch(a, i + 1, a.length, element));
    }


    public boolean binarySearch(int a[], int min, int max, int element) {
        while (min <= max) {
            int mid = (min + max) / 2;
            if (mid >= max) {  // case where mid >= array's length
                break;
            }
            if (a[mid] == element) {
                return true;
            } else if (a[mid] > element) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    static int findPivot(int arr[], int low, int high) {
        if (high < low)
            return -1;
        if (high == low)
            return low;

        int mid = (low + high) / 2;
        if (mid < high && arr[mid] > arr[mid + 1])
            return mid;
        if (mid > low && arr[mid] < arr[mid - 1])
            return (mid - 1);
        if (arr[low] >= arr[mid])
            return findPivot(arr, low, mid - 1);
        return findPivot(arr, mid + 1, high);
    }


    public static void main(String[] args) {
        int a[] = {4, 5, 6, 7, 0, 1, 2};
        SearchElementInRotatedSortedArray s = new SearchElementInRotatedSortedArray();
        System.out.println(s.search(a, 0));
    }


    static int search(int[] a, int target) {

        if (a == null || a.length == 0) return -1;

        int left = 0, right = a.length - 1;

        // first find the smallest number
        // [4,5,6,7,0,1,2] --  0 is the min .. target = 1
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (a[mid] > a[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // no do the actual binary search .. left is the min
        int start = left;
        left = 0;
        right = a.length - 1;

        // if the target is in the left side or right side.. we have to set the left and right accordingly
        if (target >= a[start] && target <= a[right]) {
            left = start;
        } else {
            right = start;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (a[mid] == target) return mid;
            else if (a[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
