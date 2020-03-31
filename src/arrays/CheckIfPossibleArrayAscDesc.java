package arrays;

/*
 *
 *  If the array is already increasing then the answer is Yes.
 *  If the array is already decreasing then the answer is Yes.
 *  If the array can be made increasing,
 *        this can be possible if the given array is first increasing up to the maximum element and then decreasing.
 *  If the array can be made decreasing,
 *        this can be possible if the given array is first decreasing up to the minimum element and then increasing.
 *
 * */


public class CheckIfPossibleArrayAscDesc {

    static boolean isPossible(int a[], int n) {
        // If size of the array is less than 3
        if (n <= 2)
            return true;

        int flag = 0;

        // Check if the array is already decreasing
        for (int i = 0; i < n - 2; i++) {
            if (!(a[i] > a[i + 1] &&
                    a[i + 1] > a[i + 2])) {
                flag = 1;
                break;
            }
        }

        // If the array is already decreasing
        if (flag == 0)
            return true;

        flag = 0;

        // Check if the array is already increasing
        for (int i = 0; i < n - 2; i++) {
            if (!(a[i] < a[i + 1] &&
                    a[i + 1] < a[i + 2])) {
                flag = 1;
                break;
            }
        }

        // If the array is already increasing
        if (flag == 0)
            return true;

        // Find the indices of the minimum
        // && the maximum value
        int val1 = Integer.MAX_VALUE, mini = -1,
                val2 = Integer.MIN_VALUE, maxi = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] < val1) {
                mini = i;
                val1 = a[i];
            }
            if (a[i] > val2) {
                maxi = i;
                val2 = a[i];
            }
        }

        flag = 1;

        // Check if we can make array increasing
        for (int i = 0; i < maxi; i++) {
            if (a[i] > a[i + 1]) {
                flag = 0;
                break;
            }
        }

        // If the array is increasing upto max index
        // && minimum element is right to maximum
        if (flag == 1 && maxi + 1 == mini) {
            flag = 1;

            // Check if array increasing again or not
            for (int i = mini; i < n - 1; i++) {
                if (a[i] > a[i + 1]) {
                    flag = 0;
                    break;
                }
            }
            if (flag == 1)
                return true;
        }

        flag = 1;

        // Check if we can make array decreasing
        for (int i = 0; i < mini; i++) {
            if (a[i] < a[i + 1]) {
                flag = 0;
                break;
            }
        }

        // If the array is decreasing upto min index
        // && minimum element is left to maximum
        if (flag == 1 && maxi - 1 == mini) {
            flag = 1;

            // Check if array decreasing again or not
            for (int i = maxi; i < n - 1; i++) {
                if (a[i] < a[i + 1]) {
                    flag = 0;
                    break;
                }
            }
            if (flag == 1)
                return true;
        }

        // If it is not possible to make the
        // array inreasing or decreasing
        return false;
    }

    public static void main(String[] args) {
        int a[] = { 4, 5, 6, 2, 3 };
        int n = a.length;

        if (isPossible(a, n))
            System.out.println( "Yes");
        else
            System.out.println( "No");
    }
}
