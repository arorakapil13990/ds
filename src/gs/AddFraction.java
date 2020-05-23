package gs;

public class AddFraction {

    private static int[] add(int f1[], int f2[]) {
        int a[] = new int[2];

        int n1 = f1[0], n2 = f2[0], d1 = f1[1], d2 = f2[1], x, y;

        x = (n1 * d2) + (d1 * n2);
        y = d1 * d2;

        int gcd = gcd(x, y);
        a[0] = x / gcd;
        a[1] = y / gcd;
        return a;
    }

    // Reduce it to the simplest form by using gcd.
    private static int gcd(int a, int b) {
        /*for (i = 1; i <= x && i <= y; ++i) {
            if (x % i == 0 && y % i == 0)
                gcd = i;
        }*/
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }

    public static void main(String[] args) {
        int[] result = add(new int[]{2, 3}, new int[]{1, 2});

        if (result[0] == 7 && result[1] == 6) {
            System.out.println("Test passed.");
        } else {
            System.out.println("Test failed.");
        }
    }
}
