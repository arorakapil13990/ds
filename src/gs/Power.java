package gs;

public class Power {

    public static double power(double base, double exp) {

        double expression = Math.abs(exp);
        double val = 1;
        for (int i = 1; i <= expression; i++) {
            val *= base;
        }
        if (exp < 0) {
            val = 1 / val;
        }
        return val;
    }

    public static boolean doTestPass() {
        return power(2, 3) == 8.0 &&
                power(2, 1) == 2.0 &&
                power(2, 0) == 1.0 &&
                power(2, -4) == 0.0625;
    }

    public static void main(String[] args) {
        if (doTestPass()) {
            System.out.println("Pass");
        } else {
            System.out.println("There are failures");
        }
    }
}
