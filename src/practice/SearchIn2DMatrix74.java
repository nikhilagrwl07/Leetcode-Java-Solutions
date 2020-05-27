package practice;

public class SearchIn2DMatrix74 {
    public static void main(String[] args) {
        SearchIn2DMatrix74 ob = new SearchIn2DMatrix74();
//        int[][] matrix = {
//                {1, 3, 5, 7},
//                {10, 11, 16, 20},
//                {23, 30, 34, 50}
//        };

        int[][] matrix = {{1}};
//        int[][] matrix = {{1},
//                {3}};

        System.out.println(ob.searchMatrix(matrix, 20));
        System.out.println(ob.searchMatrix(matrix, 15));
        System.out.println(ob.searchMatrix(matrix, 10));
        System.out.println(ob.searchMatrix(matrix, 1));
        System.out.println(ob.searchMatrix(matrix, 24));
        System.out.println(ob.searchMatrix(matrix, 4));
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int rowNumber = findRowNumber(matrix, 0, matrix.length - 1, target);
        if (rowNumber == -1)
            return false;

        return binarySearchInRow(matrix[rowNumber], 0, matrix[0].length - 1, target);
    }

    private boolean binarySearchInRow(int[] a, int l, int h, int target) {

        while (l < h) {
            if (target < a[l] || a[h] < target)
                return false;
            int m = l + (h - l) / 2;
            if (a[m] == target)
                return true;

            if (a[m] < target) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }

        if (a[l] == target)
            return true;

        return false;
    }

    private int findRowNumber(int[][] matrix, int l, int h, int target) {

        if (target < matrix[l][0])
            return -1;
        if (target > matrix[h][0])
            return h;

        while (l < h) {
            if (target < matrix[l][0])
                return l - 1;

            if (matrix[l][0] <= target  && target < matrix[l + 1][0])
                return l;

            if (target >= matrix[h][0])
                return h;

            int m = l + (h - l) / 2;

            if (matrix[l][0] <= target && target <= matrix[m][0]) {
                h = m;
            } else {
                l = m;
            }
        }

        if (matrix[l][0] == target)
            return l;
        else
            return -1;
    }
}
