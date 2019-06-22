/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


public class SearchElementIn2DSortedMatrix {
    public static void main(String[] args) {

        int mat[][] = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}
        };


        int element = 48;

        int[] searchIndex = searchElementInSorted2DMatrix(mat, 0, 0,
                mat.length - 1, mat[0].length - 1, element);

        System.out.println(searchIndex[0] + " : " + searchIndex[1]);


        searchIndex = searchElementInSorted2DMatrixLinearTimeComplexityApproach(mat,
                0, mat[0].length - 1,
                element);

        System.out.println(searchIndex[0] + " : " + searchIndex[1]);
    }

    // Time Complexity - O(Row+Column)
    // Space Complexity - O(1)
    private static int[] searchElementInSorted2DMatrixLinearTimeComplexityApproach
            (int[][] m, int row, int column, int k) {

        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;

        if ((row >= m.length) || (column >= m[0].length)) {
            return result;
        }

        // starting from top right corner
        int element = m[row][column];
        if (element == k) {
            result[0] = row;
            result[1] = column;
            return result;
        }

        if (element > k) {
            return searchElementInSorted2DMatrixLinearTimeComplexityApproach(m, row, column - 1, k);
        } else {
            return searchElementInSorted2DMatrixLinearTimeComplexityApproach(m, row + 1, column, k);
        }
    }


    // Divide and conquer approach
    // Time Complexity - O((Row+Column)^1.58)
    // Space Complexity - O(1)
    private static int[] searchElementInSorted2DMatrix(int[][] m, int rowLower, int columnLower,
                                                       int rowHigher, int columnHigher,
                                                       int k) {

        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;

        if ((rowLower > rowHigher) || (columnLower > columnHigher)) {
            return result;
        }


        if (k < m[rowLower][columnLower] || k > m[rowHigher][columnHigher]) {
            return result;
        }


        int rowMid = rowLower + (rowHigher - rowLower) / 2;

        int columnMid = columnLower + (columnHigher - columnLower) / 2;
        int element = m[rowMid][columnMid];

//        System.out.println(rowLower + " : " + columnLower + " , " + rowHigher + " : " + columnHigher);
        if (k == element) {
            result[0] = rowMid;
            result[1] = columnMid;
            return result;
        } else if (k < element) {

            int[] part1 = searchElementInSorted2DMatrix(m, rowLower, columnMid + 1, rowMid, columnHigher, k);

            if (part1[0] != -1) { // found
                return part1;
            }

            part1 = searchElementInSorted2DMatrix(m, rowMid, columnLower, rowHigher, columnMid - 1, k);

            if (part1[0] != -1) { // found
                return part1;
            }
            return searchElementInSorted2DMatrix(m, rowLower, columnLower, rowMid, columnMid, k);

        } else        //k > element
        {
            int[] part1 = searchElementInSorted2DMatrix(m, rowLower, columnMid + 1, rowMid, columnHigher, k);
            if (part1[0] != -1) { // found
                return part1;
            }
            part1 = searchElementInSorted2DMatrix(m, rowMid + 1, columnLower, rowHigher, columnMid, k);
            if (part1[0] != -1) { // found
                return part1;
            }
            return searchElementInSorted2DMatrix(m, rowMid + 1, columnMid + 1, rowHigher, columnHigher, k);
        }
    }
}