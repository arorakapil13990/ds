package gs;

public class PascalTriangle {

    public static int[][] pascal(int n) {

        int[][] a = new int[n][n];

        int i, j;

        for (i = 0; i < n; i++) {
            for (j = 0; j <= i; j++) {
                if (i == j || j == 0) {
                    a[i][j] = 1;
                } else {
                    a[i][j] = a[i - 1][j] + a[i - 1][j - 1];
                }
            }
        }
        return a;

    }

    public static void main(String[] args) {
        int a[][] = pascal(7);
        int i,j;
        for (i = 0; i < 7; i++) {
            for (j = 0; j <= i; j++) {
                System.out.print(a[i][j]+ " ");
            }
            System.out.println();
        }

        System.out.println("2,1 :: " + a[2][1]);
        System.out.println("6,5 :: " + a[6][5]);
    }
}
