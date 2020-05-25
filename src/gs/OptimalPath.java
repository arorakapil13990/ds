package gs;

public class OptimalPath {

    public static Integer optimalPath(Integer[][] grid) {
        //Memoize dynamic programming solutions
        int[][] dpSolutions = createDpSolutionsArray(grid.length, grid[0].length);

        int x = grid.length - 1;
        int y = 0;
        int finalX = 0;
        int finalY = grid[0].length - 1;
        System.out.println("Start coordinates: x= " + x + ", y= " + y);
        System.out.println("Destination coordinates: x= " + finalX + ", y= " + finalY);
        return maxPath(grid, dpSolutions, x, y, finalX, finalY);
    }

    private static Integer maxPath(
            Integer[][] grid, int[][] dpSolutions, int x, int y, int finalX, int finalY) {

        if (x == finalX && y == finalY) {
            return grid[x][y];
        }
        int up = Integer.MIN_VALUE;
        int right = Integer.MIN_VALUE;
        if (x - 1 >= finalX) {
            right = maxPath(grid, dpSolutions, x - 1, y, finalX, finalY);
        }
        if (y + 1 <= finalY) {
            up = maxPath(grid, dpSolutions, x, y + 1, finalX, finalY);
        }
        if (dpSolutions[x][y] == -1) {
            dpSolutions[x][y] = grid[x][y] + Math.max(up, right);
            System.out.println("ans = " + dpSolutions[x][y] + ", x= " + x + ", y= " + y);
        }
        return dpSolutions[x][y];
    }

    public static int[][] createDpSolutionsArray(int rowCount, int colCount) {
        int[][] dpSolutions = new int[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                dpSolutions[i][j] = -1;
            }
        }
        return dpSolutions;
    }

    public static Integer optimalPathSecond(Integer[][] grid) {
        int rowCount = grid.length;
        int colCount = grid[0].length;

        if (rowCount == 0 || colCount == 0)
            return 0;

        for (int i = rowCount - 1; i >= 0; i--) {
            for (int j = 0; j < colCount; j++) {
                if (i < rowCount - 1 && j > 0)
                    grid[i][j] += Math.max(grid[i + 1][j], grid[i][j - 1]);
                else if (i < rowCount - 1)
                    grid[i][j] += grid[i + 1][j];
                else if (j > 0)
                    grid[i][j] += grid[i][j - 1];
            }
        }
        Integer rockCount = grid[0][colCount - 1];
        System.out.println(rockCount);
        return rockCount;
    }

    public static boolean doTestsPass() {
        boolean result = true;

        /*result &= optimalPath(new Integer[][]{
                {0, 0, 0, 0, 5},
                {0, 1, 1, 1, 0},
                {2, 0, 0, 0, 0}}) == 10;


        result &= optimalPath(new Integer[][]{
                {0, 0, 10},
                {0, 1, 1},
                {2, 0, 5}}) == 18;
*/
        result &= optimalPathSecond(new Integer[][]{
                {0, 0, 0, 0, 5},
                {0, 1, 1, 1, 0},
                {2, 0, 0, 0, 0}}) == 10;


        result &= optimalPathSecond(new Integer[][]{
                {0, 0, 10},
                {0, 1, 1},
                {2, 0, 5}}) == 18;
        return result;
    }

    public static void main(String[] args) {
        if (doTestsPass()) {
            System.out.println("All tests pass");
        } else {
            System.out.println("Tests fail.");
        }
    }
}
