package leetcodeProblems.easy;

import java.util.Arrays;

public class UpdateMatrix {
    public static void main(String[] args) {

        UpdateMatrix ob = new UpdateMatrix();

        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};

        System.out.println(Arrays.deepToString(mat));
        ob.updateMatrix(mat);
        System.out.println(Arrays.deepToString(mat));
    }

    public int[][] updateMatrix(int[][] matrix) {

        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[0].length; y++) {
                if (matrix[x][y] == 1) {
                    dfs(matrix, x, y, 1);
                }
            }
        }

        return matrix;
    }

    private void dfs(int[][] matrix, int x, int y, int distance) {

        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] < distance)
            return;

        System.out.println("x = "+x +" y = "+y);
        matrix[x][y] = distance;

        dfs(matrix, x - 1, y, distance + 1);
        dfs(matrix, x + 1, y, distance + 1);
        dfs(matrix, x, y - 1, distance + 1);
        dfs(matrix, x, y + 1, distance + 1);
    }
}
