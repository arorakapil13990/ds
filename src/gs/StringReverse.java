package gs;

public class StringReverse {

    private static void reverse(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        System.out.println(sb.toString());
    }

    static void reverseRecursive(String str) {

        if (str == null || str.length() <= 1) {
            System.out.print(str);
        } else {
            System.out.print(str.charAt(str.length() - 1));
            reverseRecursive(str.substring(0, str.length() - 1));
        }
    }

    public static void main(String[] args) {
        reverse("abcd");
        reverseRecursive("abcd");
    }
}
