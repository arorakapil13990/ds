package arrays;

// https://www.geeksforgeeks.org/find-subarray-least-average/

public class SubArrayWithLeastAvg {


    private static void findAvg(int a[], int k) {
        int i, s = 0, index = -1;

        for (i = 0; i < k; i++) {
            s = s + a[i];
        }
        int currSum = 0;

        for (i = k; i < a.length; i++) {

            currSum = currSum + a[i] - a[i - k];  // window sliding technique i.e add next element and remove firstElement
            if (currSum < s) {
                s = currSum;
                index = i - k + 1;
            }
        }

        System.out.println(index + " " + (index + k - 1));
    }

    public static void main(String[] args) {
        int a[] = {3, 7, 5, 20, -10, 0, 12};
        findAvg(a, 2);
    }
}
