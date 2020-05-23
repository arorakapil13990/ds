package gs;

import java.util.stream.IntStream;

import static java.lang.Integer.min;


public class DotProduct {


    public static void main(String[] args) {
        int a[] = new int[]{1, 2};
        int b[] = new int[]{2, 3};
        int sum = IntStream.range(0, min(a.length, b.length)).map(i -> a[i] * b[i]).sum();
        System.out.println(sum);
    }
}
