package arrays;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class RearrangeArrayElementAtIndex {


    private static void rearrange() {
        int[] arr = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};
        for (int i = 0; i < arr.length; ) {
            if (arr[i] >= 0 && arr[i] != i) {
                int ele = arr[arr[i]];
                arr[arr[i]] = arr[i];
                arr[i] = ele;
            } else {
                i++;
            }
        }
        System.out.println(Arrays.toString(arr));

    }

    public static void main(String[] args) {
        int a[] = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};

        Map<Integer, Integer> map = Arrays.stream(a).filter(v -> v != -1)
                .boxed().collect(Collectors.toMap(Integer::intValue, Integer::intValue));


        for (int i = 0; i < a.length; i++) {
            if (map.get(i) != null) {
                a[i] = i;
            } else {
                a[i] = -1;
            }
        }
        System.out.println(Arrays.toString(a));
        rearrange();
    }
}
