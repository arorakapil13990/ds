package gs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeFactorization {

    public static List<Integer> primeFactorization(int n) {
        List<Integer> list = new ArrayList<>();

        int i;

        if (n < 2) {
            return list;
        }

        for (i = 2; i <= n; i++) {
            while (n % i == 0) {
                list.add(i);
                n = n / i;
            }
        }
        return list;
    }


    public static void main(String[] args) {
        System.out.println(primeFactorization(6) + " " + primeFactorization(5));
        if (primeFactorization(6).equals(Arrays.asList(2, 3))
                &&
                primeFactorization(5).equals(Arrays.asList(5))
        ) {
            System.out.println("All passed");
        } else {
            System.out.println("Failed");
        }

    }
}
