package gs;

public class Atoi {

    private static int atoi(String str) {

        int i = 0, res = 0;

        boolean isNegative = false;
        if (str.charAt(i) == '-') {
            isNegative = true;
            i++;
        }

        for (; i < str.length(); i++) {
            int ascii = str.charAt(i);
            if (ascii >= 48 && ascii <= 57) {
                res = res * 10 + (ascii - 48);
            }
        }
        if (isNegative) {
            return -1 * res;
        }

        return res;

    }

    public static boolean doTestsPass() {
        boolean result = true;
        result = result && atoi("0") == 0;
        result = result && atoi("1") == 1;
        result = result && atoi("123") == 123;
        result = result && atoi("-1") == -1;
        result = result && atoi("-123") == -123;
        result = result && atoi("123a") == 123;
        result = result && atoi("a") == 0;

        String intMax = String.valueOf(Integer.MAX_VALUE);
        result = result && atoi(intMax) == Integer.MAX_VALUE;

        String intMin = String.valueOf(Integer.MIN_VALUE);
        result = result && atoi(intMin) == Integer.MIN_VALUE;

        return result;
    }

    ;


    public static void main(String[] args) {
        if (doTestsPass()) {
            System.out.println("All tests pass");
        } else {
            System.out.println("There are test failures");
        }
    }
}
