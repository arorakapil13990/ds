package recursion;

public class CheckArraySorted {

    static int isArraySorted(int[] a, int index) {

        if (a.length == 1) {
            return 1;
        }
        return (a[index - 1] < a[index - 2]) ? 0 : isArraySorted(a, index - 1);
    }


    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 3};
        int c = isArraySorted(a, a.length);
        if (c != 0) {
            System.out.println("Sorted");
        } else {
            System.out.println("Not sorted");
        }

    }
}
