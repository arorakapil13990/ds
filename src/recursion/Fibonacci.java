package recursion;

public class Fibonacci {

    public void printFibonacci(int n, int a, int b) {

        if (n == 0)
            return;
        System.out.println(a);
        int c = a + b;

        printFibonacci(n - 1, b, c);

    }

    public int printFibonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        return printFibonacci(n - 1) + printFibonacci(n - 2);
    }

    public static void main(String[] args) {

        Fibonacci f = new Fibonacci();
        f.printFibonacci(7, 0, 1);

        System.out.println("-------------------");

        for (int i = 0; i < 7; i++) {
            System.out.println(f.printFibonacci(i));
        }

    }


}
