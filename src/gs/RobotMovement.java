package gs;

import java.util.Arrays;

public class RobotMovement {

    public static Integer[] moveOnCircuit(String path) {

        char[] ch = path.toCharArray();
        int x = 0, y = 0;

        for (Character character : ch) {
            switch (character) {
                case 'R':
                    x++;
                    break;
                case 'U':
                    y++;
                    break;
                case 'L':
                    x--;
                    break;
                case 'D':
                    y--;
                    break;
                default:
                    break;
            }

        }

        return new Integer[]{x, y};
    }

    public static boolean evaluateEquality(Integer[] firstArray, Integer[] secondArray) {
        return Arrays.equals(firstArray, secondArray);
    }

    public static boolean doTestsPass() {
        boolean checkResult = true;
        {
            String test = "";
            Integer[] result = moveOnCircuit(test);
            checkResult &= evaluateEquality(result, new Integer[]{0, 0});
        }

        {
            String test = "L";
            Integer[] result = moveOnCircuit(test);
            checkResult &= evaluateEquality(result, new Integer[]{-1, 0});
        }

        {
            String test = "UUU";
            Integer[] result = moveOnCircuit(test);
            checkResult &= evaluateEquality(result, new Integer[]{0, 3});
        }

        {
            String test = "ULDR";
            Integer[] result = moveOnCircuit(test);
            checkResult &= evaluateEquality(result, new Integer[]{0, 0});
        }

        {
            String test = "ULLLDUDUURLRLR";
            Integer[] result = moveOnCircuit(test);
            checkResult &= evaluateEquality(result, new Integer[]{-2, 2});
        }

        {
            String test = "UP LEFT 2xDOWN DOWN RIGHT RIGHT UP UP";
            Integer[] result = moveOnCircuit(test);
            checkResult &= evaluateEquality(result, new Integer[]{1, 1});
        }

        return checkResult;
    }

    public static void main(String[] args) {
        if (doTestsPass()) {
            System.out.println("All tests pass");
        } else {
            System.out.println("There are test failures");
        }
    }
}
