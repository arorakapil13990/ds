package arrays;

public class SearchElementInRotatedSortedArray {

    public void isPresent(int a[], int element) {
        int i;
        for (i = 0; i < a.length; i++) {
            if (a[i] > a[i + 1]) {
                break;
            }
        }
        System.out.println(binarSearch(a, 0, i, element) || binarSearch(a, i + 1, a.length, element));
    }


    public boolean binarSearch(int a[], int min, int max, int element) {
        while (min <= max) {
             int mid = (min + max) / 2;
             if(mid>=max){  // case where mid >= array's length
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

    static int findPivot(int arr[], int low, int high)
    {
        if (high < low)
            return -1;
        if (high == low)
            return low;

        int mid = (low + high)/2;
        if (mid < high && arr[mid] > arr[mid + 1])
            return mid;
        if (mid > low && arr[mid] < arr[mid - 1])
            return (mid-1);
        if (arr[low] >= arr[mid])
            return findPivot(arr, low, mid-1);
        return findPivot(arr, mid + 1, high);
    }


    public static void main(String[] args) {
        int a[] = {3, 4, 5, 1, 2};
        SearchElementInRotatedSortedArray s = new SearchElementInRotatedSortedArray();
        s.isPresent(a,10);
    }
}
