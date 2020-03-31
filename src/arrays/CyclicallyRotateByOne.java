package arrays;

import java.util.Arrays;

public class CyclicallyRotateByOne {

    private void rightRotate(int[] a) {

        int i, last = a[a.length - 1];
        for (i = a.length - 1; i > 0; i--) {
            a[i] = a[i - 1];
        }
        a[0] = last;
        print(a);
    }

    public void print(int a[]) {
        Arrays.stream(a).forEach(v -> {
            System.out.print(v + " ");
        });
        System.out.println();
    }

    public static void main(String[] args) {
        CyclicallyRotateByOne l = new CyclicallyRotateByOne();
        int a[] = {1, 2, 3, 4, 5, 6, 7};
        l.rightRotate(a);
    }


}
