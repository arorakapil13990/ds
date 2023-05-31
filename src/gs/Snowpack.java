package gs;

import java.util.Arrays;
import java.util.stream.Stream;

// water at ith  = min(maxLeft, maxRight) - a[i]
// https://www.youtube.com/watch?v=ZI2z5pq0TqA
// trapping rain water
public class Snowpack {

    // O(n) and space complexity O(n)
    // Min(MaxLeft, MaxRight) - height[i]
    static void findSnow(int[] arr) {

        int i, n = arr.length;
        int left[] = new int[n];
        int right[] = new int[n];

        left[0] = arr[0];
        int snow = 0;
        for (i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], arr[i]);
        }

        right[n - 1] = arr[n - 1];
        for (i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], arr[i]);
        }

        for (i = 0; i < n; i++) {
            snow += Math.min(left[i], right[i]) - arr[i];
        }
        System.out.println(snow);
    }

    public static void main(String[] args) {
        findSnow(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        findSnow(new int[]{3, 0, 2, 0, 4});
        System.out.println(" ----- ");
        snow(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        snow(new int[]{3, 0, 2, 0, 4});
    }

    // O(n) and space complexity O(1)
    private static void snow(int[] arr) {
        int length = arr.length;
        int leftMax = arr[0], rightMax = arr[length - 1], left = 0, right = length - 1;
        int res = 0;

        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, arr[left]);
                res += leftMax - arr[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, arr[right]);
                res += rightMax - arr[right];
            }
        }
        System.out.println(res);
    }
}
