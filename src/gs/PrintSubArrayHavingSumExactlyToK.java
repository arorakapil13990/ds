package gs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// https://www.techiedelight.com/find-subarrays-given-sum-array/

public class PrintSubArrayHavingSumExactlyToK {
    // Utility function to insert <key, value> pair into the Multimap
    /*private static <K, V> void insert(Map<K, List<V>> hashMap, K key, V value) {
        // if the key is seen for the first time, initialize the list
        if (!hashMap.containsKey(key)) {
            hashMap.put(key, new ArrayList<>());
        }

        hashMap.get(key).add(value);
    }*/

    private static void insert(Map<Integer, List<Integer>> hashMap, Integer key, Integer value) {
        // if the key is seen for the first time, initialize the list
        if (!hashMap.containsKey(key)) {
            hashMap.put(key, new ArrayList<>());
        }

        hashMap.get(key).add(value);
    }


    // Utility function to print a subarray A[i, j]
    public static void printSubarray(int[] A, int i, int j) {
        System.out.println(IntStream.range(i, j + 1)
                .mapToObj(k -> A[k])
                .collect(Collectors.toList()));
    }

    // Function to find subarrays with given sum in an array
    public static void printAllSubArrays(int[] A, int sum) {
        // create a map for storing end index of all subarrays with
        // sum of elements so far
        Map<Integer, List<Integer>> hashMap = new HashMap<>();

        // To handle the case when the subarray with given sum starts
        // from 0th index
        insert(hashMap, 0, -1);

        int sum_so_far = 0;

        // traverse the given array
        for (int index = 0; index < A.length; index++) {
            // sum of elements so far
            sum_so_far += A[index];

            // check if there exists at-least one sub-array with given sum
            if (hashMap.containsKey(sum_so_far - sum)) {
                List<Integer> list = hashMap.get(sum_so_far - sum);
                for (Integer value : list) {
                    printSubarray(A, value + 1, index);
                }
            }

            // insert (sum so far, current index) pair into the map
            insert(hashMap, sum_so_far, index);
        }
    }


    public static void main(String[] args) {
        int[] A = {10, 2, -2, -20, 10};
        int sum = -10;

        printAllSubArrays(A, sum);
    }
}
