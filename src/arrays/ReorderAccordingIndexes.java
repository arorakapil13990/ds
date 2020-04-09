package arrays;

import java.util.Arrays;

public class ReorderAccordingIndexes {

    public static void reorder(int a[], int indexes[]) {
        int i, t;
        int temp[] = new int[a.length];

        for (i = 0; i < indexes.length; i++) {
            temp[indexes[i]] = a[i];
            indexes[i] = i;
        }
        System.out.println(Arrays.toString(temp));
        System.out.println(Arrays.toString(indexes));
    }

    public static void main(String[] args) {
        int a[] = {50, 40, 70, 60, 90};
        int indexes[] = {3,  0,  4,  1,  2};
        reorder(a, indexes);

    }
}
