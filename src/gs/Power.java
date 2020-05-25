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

    public static double powerOptimised(double base, int exp) {
        if (base == 0) return 0;
        if (exp == 0) return 1;
        if (exp == 1) return base;
        int positiveExp = Math.abs(exp);
        double result = (positiveExp % 2 == 0) ? powerOptimised(base * base, positiveExp / 2)
                                               : base * powerOptimised(base * base, (positiveExp - 1) / 2);
        return exp < 0 ? 1 / result : result;
    }

    public static boolean doTestPass() {
        return powerOptimised(2, 4) == 16.0 &&
                powerOptimised(2, 1) == 2.0 &&
                powerOptimised(2, 0) == 1.0 &&
                powerOptimised(2, -4) == 0.0625;
    }

    public static void main(String[] args) {
        if (doTestPass()) {
            System.out.println("Pass");
        } else {
            System.out.println("There are failures");
        }
    }
}
