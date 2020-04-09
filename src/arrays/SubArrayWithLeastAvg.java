package arrays;

public class SubArrayWithLeastAvg {


    private static void findAvg(int a[], int k) {
        int i, s = 0, index = -1;

        for (i = 0; i < k; i++) {
            s = s + a[i];
        }


        for (i = k; i < a.length; i++) {
            int currSum = 0;
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
