/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package leetcodeProblems;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix54 {
    public static void main(String[] args) {
//        int[][] matrix = {
//                {1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9, 10, 11, 12},
//                {13, 14, 15, 16},
//        };

        int[][] matrix = {
                {3},
                {2}
        };

        SpiralMatrix54 ob = new SpiralMatrix54();
        List<Integer> spiralOrder = ob.spiralOrder(matrix);
        System.out.println(spiralOrder);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix==null|| matrix.length==0)
            return new ArrayList<>();

        List<Integer> result = new ArrayList<>();
        dfs(0, 0, matrix.length - 1, matrix[0].length - 1, Direction.RIGHT, matrix, result);

        return result;
    }

    private void dfs(int x1, int y1, int x2, int y2, Direction direction, int[][] matrix, List<Integer> result) {

        if (x1 > x2 || y1 > y2)
            return;

        if (direction == Direction.RIGHT) {
            for (int i = y1; i <= y2; i++) {
                result.add(matrix[x1][i]);
            }

            dfs(x1 + 1, y1, x2, y2, Direction.DOWN, matrix, result);
            return;
        }

        if (direction == Direction.DOWN) {
            for (int i = x1; i <= x2; i++) {
                result.add(matrix[i][y2]);
            }

            dfs(x1, y1, x2, y2 - 1, Direction.LEFT, matrix, result);
            return;
        }

        if (direction == Direction.LEFT) {
            for (int i = y2; i >= y1; i--) {
                result.add(matrix[x2][i]);
            }

            dfs(x1, y1, x2 - 1, y2, Direction.UP, matrix, result);
            return;
        }

        if (direction == Direction.UP) {
            for (int i = x2; i >= x1; i--) {
                result.add(matrix[i][y1]);
            }

            dfs(x1, y1 + 1, x2, y2, Direction.RIGHT, matrix, result);
            return;
        }

    }

    public enum Direction {
        RIGHT,
        LEFT,
        DOWN,
        UP;
    }
}
