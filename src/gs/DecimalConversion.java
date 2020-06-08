package gs;

import java.util.HashMap;

public class DecimalConversion {

    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)
            return "0";
        if (denominator == 0)
            return "";

        String result = "";

        // is result is negative
        if ((numerator < 0) ^ (denominator < 0)) {
            result += "-";
        }

        // convert int to long
        long num = numerator, den = denominator;
        num = Math.abs(num);
        den = Math.abs(den);

        // quotient
        long res = num / den;
        result += String.valueOf(res);

        // if remainder is 0, return result
        long remainder = (num % den) * 10;
        if (remainder == 0)
            return result;

        // right-hand side of decimal point
        HashMap<Long, Integer> map = new HashMap<>();
        result += ".";
        while (remainder != 0) {
            // if digits repeat
            if (map.containsKey(remainder)) {
                int beg = map.get(remainder);
                String part1 = result.substring(0, beg);
                String part2 = result.substring(beg);
                result = part1 + "(" + part2 + ")";
                return result;
            }

            // continue
            map.put(remainder, result.length());
            res = remainder / den;
            result += String.valueOf(res);
            remainder = (remainder % den) * 10;
        }

        return result;
    }



    public static String fractionRepresentation(int num, int den) {
        float d = (float) num / (float) den;
        String originalOutput = String.valueOf(d);
        String result;
        String decimalPart = originalOutput.substring(originalOutput.indexOf(".") + 1);
        result = originalOutput.substring(0, originalOutput.indexOf(".") + 1);

        String intermediateString = "";
        int i = 0;
        boolean repeated = false;
        while (i < decimalPart.length()) {
            if (intermediateString.length() > 0 && (i + intermediateString.length() < decimalPart.length())
                    && decimalPart.substring(i, i + intermediateString.length()).equals(intermediateString)) {
                repeated = true;
                break;

            } else {
                intermediateString = intermediateString + decimalPart.charAt(i);
                i++;
            }
        }

        if (repeated) {
            result = result + "(" + intermediateString + ")";
        } else {
            result = result + decimalPart;
        }
        // System.out.println(result);
        return result;
    }


    public static void main(String[] args) {
        System.out.println(fractionToDecimal(1, 2) + " " + fractionToDecimal(1, 3) + " "
                + fractionToDecimal(6, 11));

        if (fractionRepresentation(1, 2).equals("0.5") && fractionRepresentation(6, 11).equals("0.(54)")
                && fractionRepresentation(1, 3).equals("0.(3)")) {
            System.out.println("All passed");
        } else {
            System.out.println("Failed");
        }
    }
}
