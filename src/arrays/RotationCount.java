package arrays;

public class RotationCount {


    public int findPivot(int a[], int min, int max) {

        // when array is not rotated
        if (max < min)
            return 0;

        // If there is only one element left
        if (max == min)
            return min;

        int mid = (min + max) / 2;

        if (mid < max && a[mid] > a[mid + 1]) {  // like  mid = 18 and 2 {15, 18, 2, 3, 6, 12};
            return mid + 1;
        }

        if (mid > min && a[mid - 1] > a[mid]) { // like mid = 2 and 18
            return mid ;
        }


        /*
         * If middle element is smaller than last element, then the minimum element lies in left half
         * Else minimum element lies in right half.
         * */

        if (a[mid] < a[max]) {
            return findPivot(a, min, mid - 1);
        }

        return findPivot(a, mid + 1, max);
    }


    public static void main(String[] args) {
        int a[] = {15, 18, 2, 3, 6, 12};

        int i, c = 0, min = a[0];

        for (i = 0; i < a.length; i++) {
            if (min > a[i]) {
                break;
            }
            c++;
        }
        System.out.println(c);  // o(n)

        System.out.println(new RotationCount().findPivot(a,0,a.length-1)); // O(logn)
    }
}
