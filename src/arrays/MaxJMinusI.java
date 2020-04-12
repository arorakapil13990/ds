package arrays;

// https://massivealgorithms.blogspot.com/2014/08/given-array-arr-find-maximum-j-i-such.html
public class MaxJMinusI {

    public static void maxIndexDiff(int a[]) {
        int i, maxDiff, n = a.length, j;

        int lMin[] = new int[n];
        int rMax[] = new int[n];

        lMin[0] = a[0];
        /* Construct lMin[] such that lMin[i] stores the minimum value
           from (arr[0], arr[1], ... arr[i]) */
        for (i = 1; i < n; i++) {
            lMin[i] = Math.min(lMin[i - 1], a[i]);
        }

        rMax[n - 1] = a[n - 1];

        /* Construct rMax[] such that rMax[i] stores the maximum value
           from (arr[j], arr[j+1], ..arr[n-1]) */
        for (i = n - 2; i >= 0; i--) {
            rMax[i] = Math.max(rMax[i + 1], a[i]);
        }


        i = 0; j = 0; maxDiff = -1;

        while (i < n && j < n) {

            if (lMin[i] < rMax[j]) {
                maxDiff = Math.max(maxDiff, j - i);
                j = j + 1;
            } else {
                i = i + 1;
            }

        }
        System.out.println(maxDiff);
    }


    public static void main(String[] args) {
        maxIndexDiff(new int[]{34, 8, 10, 3, 2, 80, 30, 33, 1});
    }
}
