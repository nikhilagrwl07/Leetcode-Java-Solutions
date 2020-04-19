package leetcodeProblems.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix542 {
    public static void main(String[] args) {
        ZeroOneMatrix542 ob = new ZeroOneMatrix542();
//        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};

        System.out.println(Arrays.deepToString(mat));
        ob.updateMatrix(mat);
        System.out.println(Arrays.deepToString(mat));
    }

    public int[][] updateMatrix(int[][] matrix) {

        int[][] directions = {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1},
        };

        Queue<Integer> q = new LinkedList<>();
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (matrix[r][c] == 0) {
                    q.add(r * matrix[0].length + c);
                } else {
                    matrix[r][c] = Integer.MAX_VALUE;
                }
            }
        }

        while (!q.isEmpty()) {
            Integer poll = q.poll();
            int x = poll / matrix[0].length;
            int y = poll % matrix[0].length;

            for (int[] d : directions) {
                int newX = x + d[0];
                int newY = y + d[1];

                if (newX >= 0 && newX <= matrix.length - 1 &&
                        newY >= 0 && newY <= matrix[0].length - 1 &&
                        matrix[newX][newY] > matrix[x][y] + 1) {

                    matrix[newX][newY] = matrix[x][y] + 1;
                    q.offer((newX) * matrix[0].length + newY);

                }
            }
        }

        return matrix;
    }


//    private void dfs(int[][] matrix, int x, int y, int newDistance) {
//
//        matrix[x][y] = newDistance;
//
//        if (isSafeAndOne(matrix, x - 1, y, newDistance + 1))
//            dfs(matrix, x - 1, y, newDistance + 1);
//        if (isSafeAndOne(matrix, x + 1, y, newDistance + 1))
//            dfs(matrix, x + 1, y, newDistance + 1);
//        if (isSafeAndOne(matrix, x, y - 1, newDistance + 1))
//            dfs(matrix, x, y - 1, newDistance + 1);
//        if (isSafeAndOne(matrix, x, y + 1, newDistance + 1))
//            dfs(matrix, x, y + 1, newDistance + 1);
//
//    }
//
//    private boolean isSafeAndOne(int[][] matrix, int x, int y, int newDistance) {
//        return x >= 0 && x <= matrix.length - 1 && y >= 0 && y <= matrix[0].length - 1 && matrix[x][y] != 0
//                && matrix[x][y] > newDistance;
//    }
}
