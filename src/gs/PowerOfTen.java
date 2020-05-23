package gs;

public class PowerOfTen {

    private static boolean isPowerOfTen(int number) {
        while (number > 9 && number % 10 == 0) {
            number = number / 10;
        }
        if (number == 0 || number == 1) {
            return true;
        }
        return false;
    }

    public static boolean isPowerOf10(int x) {
        int y = 1;
        while (y < x) {
            y = y * 10;
        }
        if (y == x) {
            return true;
        } else
            return false;
    }


    public static boolean doTestsPass() {
        int[] isPowerList = {1000};
        int[] isNotPowerList = {3, 1100};

        for (int i : isPowerList) {
            if (!isPowerOfTen(i)) {
                System.out.println("Test failed for: " + i);
                return false;
            }
        }

        for (int i : isNotPowerList) {
            if (isPowerOfTen(i)) {
                System.out.println("Test failed for: " + i);
                return false;
            }
        }

        System.out.println("All tested passed");
        return true;
    }

    public static void main(String args[]) {
        doTestsPass();
    }
}
