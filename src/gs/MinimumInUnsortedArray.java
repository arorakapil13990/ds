package gs;

public class MinimumInUnsortedArray {

    private int minimum(int a[], int start, int end) {
        // only one element
        if (start == end) {
            return a[start];
        }

        // if two elements
        if (start == end - 1) {
            return Math.min(a[start], a[end]);
        }
        int mid = (start + end) / 2;
        return Math.min(minimum(a, start, mid), minimum(a, mid + 1, end));
    }

    public static void main(String[] args) {
        MinimumInUnsortedArray obj = new MinimumInUnsortedArray();
        System.out.println(obj.minimum(new int[]{10, 20, 5, 50, 3}, 0, 4));

    }
}
