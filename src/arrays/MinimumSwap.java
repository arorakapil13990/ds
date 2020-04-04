package arrays;


 // window sliding technique and  two pointer technique
public class MinimumSwap {

    static int minSwap(int arr[], int n, int k) {

        // Find count of elements which are
        // less than equals to k
        int count = 0;
        for (int i = 0; i < n; ++i)
            if (arr[i] <= k)
                ++count;

        // Find unwanted elements in current
        // window of size 'count'
        int unwantedCount = 0;
        for (int i = 0; i < count; ++i)
            if (arr[i] > k)
                ++unwantedCount;

        // Initialize answer with 'unwantedCount' value of
        // current window
        int ans = unwantedCount;
        for (int i = 0, j = count; j < n; ++i, ++j) {

            // Decrement count of previous window
            if (arr[i] > k)
                --unwantedCount;

            // Increment count of current window
            if (arr[j] > k)
                ++unwantedCount;

            // Update ans if count of 'unwantedCount'
            // is less in current window
            ans = Math.min(ans, unwantedCount);
        }
        return ans;
    }

    public static void main(String[] args) {
        int a[] ={ 1, 12, 10, 3, 14, 10, 5 };
        System.out.println(minSwap(a,a.length, 8));

    }
}
