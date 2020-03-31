package arrays;

public class ElementAtIndexAfterRandRotation {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int rotations = 2;

        int[][] ranges = {{0, 2}, {0, 3}};

        int index = 1;
        System.out.println(findElement(arr, ranges,
                rotations, index));
    }

    private static void rightRotate(int a[], int left, int right) {

        int i, last = a[right];
        for (i = right; i > left; i--) {
            a[i] = a[i - 1];
        }
        a[left] = last;
    }


    private static int findElement(int[] arr, int[][] ranges, int rotations, int index) {
        int i;


        for (i = 0; i < rotations; i++) {
            int left = ranges[i][0];
            int right = ranges[i][1];
            rightRotate(arr, left, right);
        }


        return arr[index];
    }
}
