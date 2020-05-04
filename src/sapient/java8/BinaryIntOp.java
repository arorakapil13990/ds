package sapient.java8;


public class BinaryIntOp {

    private int apply(Binary binary, int a, int b) {
        return binary.compute(a, b);
    }

    public static void main(String[] args) {

        Binary add = (a, b) -> a + b;
        Binary sub = (a, b) -> a - b;


        System.out.println(add.compute(2, 4));
        System.out.println(sub.compute(5, 4));

        System.out.println(new BinaryIntOp().apply(add, 5, 6));

        System.out.println(new BinaryIntOp().apply((a,b) -> a/b, 30, 6));

    }
}
