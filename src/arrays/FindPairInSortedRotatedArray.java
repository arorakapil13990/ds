package arrays;

public class FindPairInSortedRotatedArray {

    private void findPair(int[] arr_int, int x) {
        int k, n = arr_int.length;
        for (k = 0; k < n - 1; k++)
            if (arr_int[k] > arr_int[k + 1])
                break;

            boolean isFound = false;

        int l = (k + 1) % n;

        int r = k;

        while (l != r) {
            if (arr_int[l] + arr_int[r] == x) {
                isFound =true;
                break;
            }
            if (arr_int[l] + arr_int[r] < x)
                l = (l + 1) % n;
            else
                r = (n + r - 1) % n;
        }

        if(isFound){
            System.out.println(arr_int[l] + " " + arr_int[r]);
        }else {
            System.out.println("Not found");
        }

    }


    public static void main(String[] args) {
        int a[] = {11, 15, 6, 8, 9, 10};
        FindPairInSortedRotatedArray s = new FindPairInSortedRotatedArray();
        s.findPair(a, 16);
    }


}
