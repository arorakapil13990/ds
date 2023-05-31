package arrays;
// https://leetcode.com/problems/maximum-product-subarray/description/
// https://www.youtube.com/watch?v=tHNsZHXnYd4

public class MaxProductSubArray {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2, 3, -2, 4}));
    }

    public static int maxProduct(int[] a) {
        int max = a[0];
        int min = a[0];
        int ans = a[0];
        int t, i;

        for (i = 1; i < a.length; i++) {
            if (a[i] < 0) {
                t = max;
                max = min;
                min = t;
            }
            max = Math.max(a[i], max * a[i]);
            min = Math.min(a[i], min * a[i]);
            ans = Math.max(ans, max);
        }
        return ans;

    }

}
