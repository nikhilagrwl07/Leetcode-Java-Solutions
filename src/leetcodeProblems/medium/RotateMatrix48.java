package leetcodeProblems.medium;

import java.util.Arrays;

public class RotateMatrix48 {
    public static void main(String[] args) {
        RotateMatrix48 ob = new RotateMatrix48();
        int[][] m = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

//        int[][] m = {{1}};

//        int[][] m = {
//                {5, 1, 9, 11},
//                {2, 4, 8, 10},
//                {13, 3, 6, 7},
//                {15, 14, 12, 16}
//        };

        System.out.println(Arrays.deepToString(m));
        ob.rotate(m);
        System.out.println(Arrays.deepToString(m));

    }

    // Approach - Transpose matrix and reverse rows
    // Time -O(N^2)
    // Space -O(1)
    public void rotate(int[][] matrix) {

        int t;
        // transpose
        for (int r = 0; r < matrix.length; r++) {
            for (int c = r; c < matrix[0].length; c++) {
                t = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = t;
            }
        }

        for (int[] r : matrix) {
            int i = 0, j = matrix.length - 1;
            while (i < j) {
                t = r[i];
                r[i] = r[j];
                r[j] = t;
                i++;
                j--;
            }
        }
    }

    // Approach - Rotate Rectangle
    // Time -O(N^2)
    // Space -O(1)
    public void rotate2(int[][] matrix) {

        if (matrix == null)
            return;

        int d = matrix.length / 2;
        int length = 0;

        while (length < d) {
            int x1 = 0 + length;
            int y1 = 0 + length;

            int x2 = matrix.length - 1 - length;
            int y2 = matrix.length - 1 - length;

            int l = y2 - y1;
            // left to right

            for (int i = 0; i < l; i++) {
                int tmp1 = matrix[x1][y1 + i];
                int tmp2 = matrix[x1 + i][y2];
                int tmp3 = matrix[x2][y2 - i];
                int tmp4 = matrix[x2 - i][y1];

                matrix[x1 + i][y2] = tmp1;
                matrix[x2][y2 - i] = tmp2;
                matrix[x2 - i][y1] = tmp3;
                matrix[x1][y1 + i] = tmp4;
            }

            length++;
        }
    }
}
