package gs;

public class SmallestRotated {


    private static int smallest(int a[], int low, int high) {

        // If there is only one element left
        if (low == high) {
            return a[low];
        }

        // when array is not rotated at all
        if (high < low) {
            return a[0];
        }

        int mid = (low + high) / 2;

        // Check if element (mid+1) is minimum element. Consider
        // the cases like {3, 4, 5, 1, 2}
        if (mid < high && a[mid] > a[mid + 1]) {
            return a[mid + 1];
        }

        // Check if mid itself is minimum element
        if (mid > low && a[mid - 1] > a[mid]) {
            return a[mid];
        }

        // Decide whether we need to go to left half or right half
        // If middle element is higher than last element, then the minimum element lies in right half
        if (a[mid] > a[high]) {
            smallest(a, mid + 1, high);
        }

        return smallest(a, low, mid - 1);
    }


    private static void smallest(int a[]) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
        }
        System.out.println(min);
    }

    public static void main(String[] args) {
        smallest(new int[]{3, 4, 5, 1, 2});
        System.out.println(smallest(new int[]{50,60,70,90,97,10,20,30,40},0,8));
    }
}
