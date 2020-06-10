package gs;

import java.util.Arrays;

public class StairCase {


    /*
        There are n stairs, and a person is allowed to jump next stair, skip one stair or skip two stairs.
        So there are n stairs. So if a person is standing at i-th stair, the person can move to i+1, i+2, i+3-th stair.
        A recursive function can be formed where at current index i the
        function is recursively called for i+1, i+2 and i+3 th stair.
        There is another way of forming the recursive function. To reach a stair i,
        a person has to jump either from i-1, i-2 or i-3 th stair or i is the starting stair.
    */

    // complexity 3 power n
    // From each state, 3 recursive function are called. So the upperbound for n states is O(3n)
    public static Integer countSteps(Integer n) {
        // below if conditions are important
        if (n <= 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        return countSteps(n - 1) + countSteps(n - 2) + countSteps(n - 3);
    }


    /*
        Create an array of size n + 1 and initialize the first 3 variables with 1, 1, 2. The base cases.
        Run a loop from 3 to n.
        For each index i, computer value of ith position as dp[i] = dp[i-1] + dp[i-2] + dp[i-3].
        Print the value of dp[n], as the Count of the number of ways to reach n th step.
        filter_none
    */

    public static int countWays(int n) {
        int[] res = new int[n + 1];
        res[0] = 1;
        res[1] = 1;
        res[2] = 2;

        for (int i = 3; i <= n; i++)
            res[i] = res[i - 1] + res[i - 2]
                    + res[i - 3];
        System.out.println(Arrays.toString(res));
        return res[n];
    }


    public static boolean doTestsPass() {

        boolean x = countWays(3) == 4 && countWays(4) == 7;
        System.out.println(x);
        return countSteps(3) == 4 && countSteps(4) == 7;
    }

    public static void main(String[] args) {
        if (doTestsPass()) {
            System.out.println("All tests pass");
        } else {
            System.out.println("Tests fail.");
        }

        for (Integer n = 1; n <= 5; n++) {
            Integer numberOfCombinations = countSteps(n);
            System.out.println(n + " steps => " + numberOfCombinations);
        }
    }
}
