package gs;

/**
 * You have an integer array. Starting from arr[startIndex], follow each element
 * to the index it points to. Continue to do this until you find a cycle. Return
 * the length of the cycle. If no cycle is found return -1
 */
public class CountLengthOfCycle {

    public static int countLengthOfCycle(int[] arr, int startIndex) {
        int[] aux = new int[arr.length];
        for (int i = 0; i < aux.length; i++)
            aux[i] = -1;
        int c = 0;
        while (aux[startIndex] == -1) {
            aux[startIndex] = 1;
            startIndex = arr[startIndex];
            c++;
        }

        return c;
    }



    public static void main(String[] args) {
        boolean testsPassed = true;

        testsPassed &= countLengthOfCycle(new int[]{1, 0}, 0) == 2;
        testsPassed &= countLengthOfCycle(new int[]{1, 2, 0}, 0) == 3;


        if (testsPassed) {
            System.out.println("Test passed.");
        } else {
            System.out.println("Test failed.");
        }

    }
}
