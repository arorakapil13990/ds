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


    static void test(int a[], int x, int y) {

        int w1 = -1, w2 = -1, i, min = Integer.MAX_VALUE;

        for (i = 0; i < a.length; i++) {

            if (a[i] == x) {
                w1 = i;
            } else if (a[i] == y) {
                w2 = i;
            }

            if (w1 > 0 && w2 > 0) {
                int d = Math.abs(w1 - w2);
                min = Math.min(min, d);

            }
        }
        System.out.println(min);
    }


    public static void main(String[] args) {
        int a[] = {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3};
        int x = 3, y = 6;

        findMinDistance(a, x, y);
        test(a, x, y);


        int b[] = {1,2,3,4,5,5,2};
         x = 2;
         y = 5;

        findMinDistance(b, x, y);
        test(b, x, y);
    }
}
