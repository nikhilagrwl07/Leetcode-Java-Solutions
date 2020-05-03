package leetcodeProblems.medium;

import java.util.Arrays;

public class SetZerosInMatrix {
    public static void main(String[] args) {
        SetZerosInMatrix ob = new SetZerosInMatrix();
//        int[][] m = {
//                {0, 1, 2, 0},
//                {3, 4, 5, 2},
//                {1, 3, 1, 5}
//        };

        int[][] m = {
                {-1},
                {2},
                {3},
        };

//        int[][] m = {
//            {1,1,1},
//            {1,0,1},
//            {1,1,1}
//        };

        System.out.println(Arrays.deepToString(m));
        ob.setZeroes(m);
        System.out.println(Arrays.deepToString(m));
    }

    public void setZeroes(int[][] matrix) {

        Integer tmpValue = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] >= tmpValue) {
                    tmpValue = matrix[i][j] + 1;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    setToInfinity(matrix, i, j, tmpValue);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == tmpValue) {
                    matrix[i][j] = 0;
                }
            }
        }

    }

    private void setToInfinity(int[][] matrix, int r, int c, Integer tmpValue) {

        // set row
        for (int i = 0; i < matrix[0].length; i++) {

            if (matrix[r][i] == 0 && c != i) {
            } else {
                matrix[r][i] = tmpValue;
            }
        }

        // set col
        for (int j = 0; j < matrix.length; j++) {

            if (matrix[j][c] == 0 && r != j) {
            } else {
                matrix[j][c] = tmpValue;
            }
        }
    }
}
