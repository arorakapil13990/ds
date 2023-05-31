package gs;

import java.util.Arrays;

public class SecondSmallest {

    public static void smallest(int a[]) {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE, i;

        for (i = 0; i < a.length; i++) {

            if (a[i] < first) {
                first = a[i];
            }
            if (a[i] > first && a[i] < second) {
                second = a[i];
            }
        }
        System.out.println(second);

        Arrays.stream(a).sorted().skip(1).limit(1).forEach(System.out::print);
    }

    public static void main(String[] args) {
        smallest(new int[]{1,2,3,4,5});
    }
}
