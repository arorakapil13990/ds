package arrays;


// Rj - Rj-1 = arrSum - n * arr[n-j]

public class MaxSumWithRotation {

    public void maxSum(int a[]) {
        int arrSum = 0, currentVal = 0;
        int i, n = a.length;

        for (i = 0; i < n; i++) {
            arrSum = arrSum + a[i];
            currentVal = currentVal + (i * a[i]);
        }

        int maxVal = currentVal;
        //currentVal is Ro --- rotation 0


        for (i = 1; i < n; i++) {
            currentVal = currentVal + arrSum - n * a[n - i];

            if(currentVal>maxVal){
                maxVal=currentVal;
            }
        }
        System.out.println(maxVal);
    }

    public static void main(String[] args) {
        int a[] = {1, 20, 2, 10};
        MaxSumWithRotation m = new MaxSumWithRotation();
        m.maxSum(a);
    }
}
