package arrays;

public class MinimumDistanceTwoNumbers {

    public static void findMinDistance(int a[], int x, int y) {

        int i, p = -1, min = Integer.MAX_VALUE;

        for (i = 0; i < a.length; i++) {
            if (a[i] == x || a[i] == y) {
                if (p != -1 && a[p] != a[i]) {
                    min = Math.min(min, i - p);
                }
                p = i;
            }
        }

        System.out.println(min);
    }


    public static void main(String[] args) {
        int a[] = {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3};
        int x = 3, y = 6;

        findMinDistance(a, x, y);
    }
}
