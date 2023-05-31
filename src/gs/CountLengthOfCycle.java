package gs;

/**
 * You have an integer array. Starting from arr[startIndex], follow each element
 * to the index it points to. Continue to do this until you find a cycle. Return
 * the length of the cycle. If no cycle is found return -1
 */
public class CountLengthOfCycle {


    public static int count(int[] arr){
        int c =0;
        int[] aux = new int[arr.length];
        int i =arr[0];
        while (aux[i]  == 0){
            aux[i] = 1;
            i = arr[i];
            c++;
        }
        return c;
    }

// set startindex = arr[0]
    private static int countLengthOfCycle(int[] arr, int startIndex) {
        int[] aux = new int[arr.length];
        int c = 0;
        while (aux[startIndex] == 0) {
            aux[startIndex] = 1;
            startIndex = arr[startIndex];
            c++;
        }

        return c;
    }

    public static int countCycles(int[] data) {
        int[] counters = new int[data.length];
        int index = 0;
        int count = 0;
        while(counters[index] == 0) {
            counters[index] = count++;
            index = data[index];
        }
        return count - counters[index];
    }



    public static void main(String[] args) {
        boolean testsPassed = true;
        testsPassed &= countLengthOfCycle(new int[]{1, 0}, 0) == 2;
        testsPassed &= countLengthOfCycle(new int[]{1, 2, 0}, 0) == 3;

        /*boolean testsPassed = true;
        testsPassed &= countCycles(new int[]{1, 0}) == 2;
        testsPassed &= countCycles(new int[]{1, 2, 3,1}) == 3;*/

        System.out.println(count(new int[]{1, 0}));
        System.out.println(count(new int[]{1, 2, 3,1}));
        if (testsPassed) {
            System.out.println("Test passed.");
        } else {
            System.out.println("Test failed.");
        }

    }


}
