package gs;

public class MedianOfSortedArray {

    private double findMedian(int a[], int b[]) {

        int c[] = new int[a.length + b.length];

        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {

            if (a[i] < b[j]) {
                c[k++] = a[i++];
            } else {
                c[k++] = b[j++];
            }
        }

        while (i < a.length) {
            c[k++] = a[i++];
        }
        while (j < b.length) {
            c[k++] = b[j++];
        }

        double median;
        if (c.length % 2 == 0) {
            median = ((double) c[c.length / 2] + (double) c[c.length / 2 - 1]) / 2;
        } else {
            median = (double) c[c.length / 2] / 2;
        }
        return median;
    }

    public static void main(String[] args) {
        MedianOfSortedArray solution = new MedianOfSortedArray();

        System.out.println("Case 1: When arrays have odd number of elements in them.");
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {6, 7, 8, 9, 10};

        System.out.println("Median: " + solution.findMedian(a, b));

        System.out.println("-----------------");

        System.out.println("Case 2: When arrays have even number of elements in them.");
        int[] c = {1, 2, 99, 100};
        int[] d = {4, 5, 101, 102};

        System.out.println("Median: " + solution.findMedian(c, d));

        int[] e = {-9, -4, 0, 3, 6, 12};
        int[] f = {-3, 1, 5};

        System.out.println("Median: " + solution.findMedian(f, e));

        int[] g = {1, 3};
        int[] h = {2, 4};

        System.out.println("Median: " + solution.findMedian(g, h));
    }
}
