package leetcodeProblems;

public class RotateClockWise2DMatrix49 {

    public static void main(String[] args) {
//        int[][] a = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        };

        int[][] a = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        RotateClockWise2DMatrix49 ob = new RotateClockWise2DMatrix49();
        ob.rotate(a);
        printMatrix(a);
    }

    public void rotate(int[][] matrix) {

        if (matrix == null || matrix.length == 0)
            return;

        // transpose
        for (int row = 1; row < matrix.length; row++) {

            for (int col = 0; col < row; col++) {
                int tmp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = tmp;
            }
        }

        // reverse Column
        for (int row = 0; row < matrix.length; row++) {
            int left = 0, right = matrix[0].length - 1;

            while (left < right) {
                int tmp = matrix[row][left];
                matrix[row][left] = matrix[row][right];
                matrix[row][right] = tmp;
                left++;
                right--;
            }
        }

    }


    private static void printMatrix(int[][] a) {

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

    }
}
