package arrays;

import java.util.Arrays;

// https://massivealgorithms.blogspot.com/2016/06/minimize-maximum-difference-between.html
public class MinimizeMaxDiffBetweenHeights {

    public static int findMinDifference(int a[], int k) {

        int i, min, max, n = a.length;

        Arrays.sort(a);

        min = a[0];
        max = a[n - 1];

        // doesn't make sense like {4,6} k = 10
        if (k >= (max - min)) {
            a = Arrays.stream(a).map(e -> e + k).toArray();
            return max - min;
        }

        a[0] += k;
        a[n - 1] -= k;

        min = Math.min(a[0], a[a.length - 1]);
        max = Math.max(a[0], a[a.length - 1]);


        for (i = 1; i < n - 1; i++) {


            if (a[i] < min) {
                a[i] += k;
            } else if (a[i] > max) {
                a[i] -= k;
            } else if ((a[i] - min) > (max - a[i])) {  // closest to max
                a[i] -= k;
            } else {
                a[i] += k;
            }
            min = Math.min(a[i], min);
            max = Math.max(a[i], max);
        }


        return max - min;
    }

    public static void main(String[] args) {
        int a[] = {1, 15, 10}, k = 6;
        System.out.println(findMinDifference(a, k));
    }
}
