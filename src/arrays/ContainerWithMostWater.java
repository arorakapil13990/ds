package arrays;

// https://www.youtube.com/watch?v=6PrIRPpTI9Q
// https://leetcode.com/problems/container-with-most-water/
public class ContainerWithMostWater {

    public static void main(String[] args) {

    }

    static int maxArea(int[] a) {
        int max_area = 0;
        int left = 0, right = a.length - 1;

        while (left < right) {
            if (a[left] < a[right]) {
                max_area = Math.max(max_area, a[left] * (right - left));
                left++;
            } else {
                max_area = Math.max(max_area, a[right] * (right - left));
                right--;
            }
        }
        return max_area;
    }
}
