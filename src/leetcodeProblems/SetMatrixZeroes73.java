package leetcodeProblems;

import java.util.Arrays;

public class SetMatrixZeroes73 {
    public static void main(String[] args) {


//        int[][] matrix = {
//
//            {
//                0, 1, 2, 0
//            },
//
//            {
//                3, 4, 5, 2
//            },
//
//            {
//                1, 3, 1, 5
//            }
//
//        };
//        int[][] matrix =
//                {
//                        {1, 1, 1},
//                        {1, 0, 1},
//                        {1, 1, 1}
//                };


//        int[][] matrix =
//                {
//                        {1},
//                        {0},
//                        {1}
//                };

        int[][] matrix =
                {
                        {}
                };

        SetMatrixZeroes73 ob = new SetMatrixZeroes73();

        System.out.println(Arrays.deepToString(matrix));
        ob.setZeroes(matrix);

        System.out.println(Arrays.deepToString(matrix));
    }

    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;

        boolean columnsContainsZero = false;
        boolean rowContainsZero = false;


        for (int col : matrix[0]) {
            if (col == 0) {
                rowContainsZero = true;
                break;
            }

        }

        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][0] == 0) {
                columnsContainsZero = true;
                break;
            }
        }

        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }

        for (int col = 1; col < matrix[0].length; col++) {
            if (matrix[0][col] == 0) {

                //marking entire row as 0
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = 0;
                }
            }
        }


        for (int row = 1; row < matrix.length; row++) {
            if (matrix[row][0] == 0) {


                //marking entire column as 0
                for (int col = 0; col < matrix[0].length; col++) {
                    matrix[row][col] = 0;
                }
            }
        }

        if (columnsContainsZero) {

            for (int row = 0; row < matrix.length; row++) {
                matrix[row][0] = 0;
            }
        }

        if (rowContainsZero) {
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[0][col] = 0;
            }
        }
    }
}
