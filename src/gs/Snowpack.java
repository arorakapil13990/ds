package gs;

public class Snowpack {

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
        findSnow(new int[]{0, 1, 3, 0, 1, 2, 0, 4, 2, 0, 3, 0}) ;
    }
}
