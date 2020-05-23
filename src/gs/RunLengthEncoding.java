package gs;

public class RunLengthEncoding {

    private static String RLE(String str) {

        int i;
        StringBuilder sb = new StringBuilder();
        for (i = 0; i < str.length(); i++) {
            int count = 1;
            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            sb.append(str.charAt(i) + ""+ count);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "wwwwaaadexxxxxxywww";
        System.out.println(RLE(str));

        if("".equals(RLE("")) &&
                "a1".equals(RLE("a")) &&
                "a3".equals(RLE("aaa"))){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }
    }
}
