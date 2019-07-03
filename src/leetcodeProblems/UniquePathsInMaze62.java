/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package leetcodeProblems;

public class UniquePathsInMaze62 {
    public static void main(String[] args) {

        UniquePathsInMaze62 ob = new UniquePathsInMaze62();
//        int uniquePaths = ob.uniquePaths(3, 2);
//        int uniquePaths = ob.uniquePaths(7, 3);
        int uniquePaths = ob.uniquePaths(23, 12);
        System.out.println(uniquePaths);


    }


    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0)
            return 0;

        int[][] pathCount = new int[m][n];

        for (int col = 0; col < n; col++) {
            pathCount[0][col] = 1;
        }

        for (int row = 0; row < m; row++) {
            pathCount[row][0] = 1;
        }

        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                pathCount[row][col] = pathCount[row - 1][col] + pathCount[row][col - 1];
            }
        }

        return pathCount[m - 1][n - 1];
    }

    // Approach #2 - Backtracking
//    public int uniquePaths(int m, int n) {
//        if (m == 0 || n == 0)
//            return 0;
//
//
//        return uniquePathsUtil(new boolean[m][n], 0 , 0);
//    }


//    public int uniquePathsUtil(boolean[][] isVisited, int row, int col) {
//
//        if (!isSafe(isVisited, row, col)) {
//            return 0;
//        }
//
//        isVisited[row][col] = true;
//
//        if (row == isVisited.length - 1 && col == isVisited[0].length - 1) {
//            return 1;
//        }
//
//        int pathCount = uniquePathsUtil(isVisited, row + 1, col) +
//                uniquePathsUtil(isVisited, row, col + 1);
//
//
//        isVisited[row][col] = false;
//        return pathCount;
//    }

    private boolean isSafe(boolean[][] isVisited, int row, int col) {
        if (row < 0 || row >= isVisited.length || col < 0 || col >= isVisited[0].length) {
            return false;
        }
        return true;
    }
}
