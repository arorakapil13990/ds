package arrays;

// Largest Sum Contiguous Subarray
// https://www.youtube.com/watch?v=kekmCQXYwQ0&t=713s

public class ContiguousSumAlgorithm {

    public static void sum(int a[]) {
        int maxSoFar = a[0], maxEndingHere = 0;

        int start = 0, end = 0, s = 0;
        for (int i = 1; i < a.length; i++) {
            maxEndingHere = maxEndingHere + a[i];

            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
                start = s;
                end = i;
            }
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
                s = i + 1;
            }
        }
        System.out.println(maxSoFar);
        System.out.println(start + " " + end);
    }


    public static void main(String[] args) {

        int a[] = {-1, 1, -3, 4, -1, 2, 1, -3, 2};
        sum(a);
    }
}
