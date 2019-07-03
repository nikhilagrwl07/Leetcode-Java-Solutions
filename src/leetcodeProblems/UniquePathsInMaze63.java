/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package leetcodeProblems;

public class UniquePathsInMaze63 {
    public static void main(String[] args) {

        UniquePathsInMaze63 ob = new UniquePathsInMaze63();
//        int uniquePaths = ob.uniquePaths(3, 2);
//        int uniquePaths = ob.uniquePaths(7, 3);
        int[][] grid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        int uniquePaths = ob.uniquePathsWithObstacles(grid);
        System.out.println(uniquePaths);


    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;

        if (m == 0 || n == 0)
            return 0;

        int[][] pathCount = new int[m][n];

        for (int col = 0; col < n && obstacleGrid[0][col] == 0; col++) {
            pathCount[0][col] = 1;
        }

        for (int row = 0; row < m && obstacleGrid[row][0] == 0; row++) {
            pathCount[row][0] = 1;
        }

        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {

                if (obstacleGrid[row][col] == 0) {
                    pathCount[row][col] = pathCount[row - 1][col] + pathCount[row][col - 1];
                }

            }
        }

        return pathCount[m - 1][n - 1];
    }
}
