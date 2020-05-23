package gs;

import java.text.DecimalFormat;

// https://codingblocks.com/resources/square-root/
public class SquareRoot {


    // sqrt(n+1) = (sqrt(n)+num/sqrt(n))/2


    public static double sqrt(int number) {
        double t;
        double squareRoot = number / 2;
        do {
            t = squareRoot;
            squareRoot = (t + (number / t)) / 2;
        } while ((t - squareRoot) != 0);
        return squareRoot;
    }


    static float squareRoot(int number) {
        int start = 0, end = number;
        int mid;

        // variable to store the answer
        double ans = 0.0;

        // for computing integral part
        // of square root of number
        while (start <= end) {
            mid = (start + end) / 2;

            if (mid * mid == number) {
                ans = mid;
                break;
            }

            // incrementing start if integral
            // part lies on right side of the mid
            if (mid * mid < number) {
                start = mid + 1;
                ans = mid;
            }
            // decrementing end if integral part
            // lies on the left side of the mid
            else {
                end = mid - 1;
            }
        }

        // For computing the fractional part
        // of square root upto given precision
        double increment = 0.1;
        for (int i = 0; i < 5; i++) {
            while (ans * ans <= number) {
                ans += increment;
            }

            // loop terminates when ans * ans > number
            ans = ans - increment;
            increment = increment / 10;
        }
        return (float) ans;
    }

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.#####");
        System.out.println(df.format(sqrt(2)));
        System.out.println(df.format(sqrt(4)));
        System.out.println(df.format(sqrt(100)));
        System.out.println(squareRoot(2));
    }
}
