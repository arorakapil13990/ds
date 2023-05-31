package gs;

public class Atoi {

    private static int atoi(String str) {

        int i = 0, res = 0;

        boolean isNegative = false;
        if (!str.isEmpty() && str.charAt(i) == '-') {
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
        result = result && atois("0") == 0;
        result = result && atois("1") == 1;
        result = result && atois("123") == 123;
        result = result && atois("-1") == -1;
        result = result && atois("-123") == -123;
        result = result && atois("123a") == 123;
        result = result && atois("a") == 0;
        result = result && atois("") == 0;
        result = result && atois("1w234e") == 1234;

        String intMax = String.valueOf(Integer.MAX_VALUE);
        result = result && atois(intMax) == Integer.MAX_VALUE;

        String intMin = String.valueOf(Integer.MIN_VALUE);
        result = result && atois(intMin) == Integer.MIN_VALUE;

        return result;
    }


    private static int atois(String s) {
        int i = 0, res = 0;

        boolean isNegative = false;

        if (!s.isEmpty() && s.charAt(0) == '-') {
            isNegative = true;
            i++;
        }

        for (; i < s.length(); i++) {
            int ascii = s.charAt(i);
            if (ascii >= 48 && ascii <= 57) {
                res = res * 10 + (ascii - 48);
            }
        }
        if(isNegative){
            res = res* -1;
        }
        return res;

    }

    public static void main(String[] args) {
        if (doTestsPass()) {
            System.out.println("All tests pass");
        } else {
            System.out.println("There are test failures");
        }
    }
}
