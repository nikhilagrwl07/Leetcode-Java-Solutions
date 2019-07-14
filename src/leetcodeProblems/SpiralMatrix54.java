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

        List<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return result;

        int r1 = 0, r2 = matrix.length - 1;
        int c1 = 0, c2 = matrix[0].length - 1;


        while (r1 <= r2 && c1 <= c2) {

            //left to right
            for (int c = c1; c <= c2; c++) {
                result.add(matrix[r1][c]);
            }

            // top to Bottom
            for (int r = r1 + 1; r <= r2; r++) {
                result.add(matrix[r][c2]);
            }


            if(r1 < r2 && c1 < c2){
                // right to left
                for (int c = c2 - 1; c >= c1 + 1; c--) {
                    result.add(matrix[r2][c]);
                }

                // bottom to top
                for (int r = r2; r > r1; r--) {
                    result.add(matrix[r][c1]);
                }

            }

            r1++;
            r2--;
            c1++;
            c2--;
        }

        return result;
    }
}
