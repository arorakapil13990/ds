package sapient;

public class StringExample {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc");
        String s4 = new String("abc");

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s4 == s3);
        System.out.println(s4.equals(s3));
        System.out.println(s1.equals(s3));

        String s5 = new String("abc").intern();
        System.out.println(s1 == s5);
    }
}
