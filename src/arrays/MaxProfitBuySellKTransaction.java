package arrays;

public class MaxProfitBuySellKTransaction {

    public static void findMaxProfit(int prices[], int k) {
        int a[][] = new int[k + 1][prices.length];

        int i, j;

        for (i = 1; i <= k; i++) {
            int maxDiff = -prices[0];
            for (j = 1; j < a[0].length; j++) {
                a[i][j] = Math.max(a[i][j - 1], prices[j] + maxDiff);
                maxDiff = Math.max(maxDiff, a[i - 1][j] - prices[j]);

            }
        }
        System.out.println(a[k][prices.length - 1]);
    }

    public static void main(String[] args) {
        int prices[] = {10, 22, 5, 75, 65, 80};

        findMaxProfit(prices, 2);
    }
}
