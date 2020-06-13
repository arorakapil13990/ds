package Demo;


import java.util.Arrays;

public class Test {

    static void findTuple(int a[], int r) {

        int data[] = new int[r];
        combinationUtil(a, 0, data, 0, r, a.length );
    }


    static void combinationUtil(int a[], int i, int data[], int index, int r, int n) {

        if (index == r) {
            Arrays.stream(data).forEach(e -> System.out.print(e + " "));
            System.out.println();
            return;
        }

        if (i >= n) {
            return;
        }

        data[index] = a[i];
        combinationUtil(a, i + 1, data, index + 1, r, n);
        combinationUtil(a, i + 1, data, index, r, n);

    }


    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4};
        findTuple(a, 2);
    }
}


