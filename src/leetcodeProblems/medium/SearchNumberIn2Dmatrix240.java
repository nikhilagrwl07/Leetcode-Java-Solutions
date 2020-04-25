package leetcodeProblems.medium;

public class SearchNumberIn2Dmatrix240 {
    public static void main(String[] args) {

        SearchNumberIn2Dmatrix240 ob = new SearchNumberIn2Dmatrix240();
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
//        int[][] matrix ={
//            {1,2,3,4,5},
//            {6,7,8,9,10},
//            {11,12,13,14,15},
//            {16,17,18,19,20},
//            {21,22,23,24,25}
//        };

//        int[][] matrix = {};
//        int[][] matrix = {{-1,3}};
        int target = 20;
//        int target = 20;

        boolean result = ob.searchMatrix(matrix, target);
        System.out.println(result);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 ||
                target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1])
            return false;

        int[] topleft = new int[2];
        topleft[0] = 0;
        topleft[1] = 0;


        int[] bottomRight = new int[2];
        bottomRight[0] = matrix.length - 1;
        bottomRight[1] = matrix[0].length - 1;

        return searchMatrix(matrix, topleft, bottomRight, target);
    }

    private boolean searchMatrix(int[][] matrix, int[] topleft, int[] bottomRight, int target) {
        if (topleft[0] < 0 || topleft[0] >= matrix.length ||
                bottomRight[0] < 0 || bottomRight[0] >= matrix.length ||
                topleft[1] < 0 || topleft[1] >= matrix[0].length ||
                bottomRight[1] < 0 || bottomRight[1] >= matrix[0].length ||
                target < matrix[topleft[0]][topleft[1]] ||
                target > matrix[bottomRight[0]][bottomRight[1]]) {
            return false;
        }

//        System.out.println(
//                "x1= "+ topleft[0]+
//                " y1= "+ topleft[1]+
//                " x2= "+ bottomRight[0]+
//                " y2= "+ bottomRight[1]);

        int midX = topleft[0] + (bottomRight[0] - topleft[0]) / 2;
        int midY = topleft[1] + (bottomRight[1] - topleft[1]) / 2;

        if (target == matrix[midX][midY])
            return true;

        return searchMatrix(matrix, topleft, new int[]{midX, midY}, target) ||
                searchMatrix(matrix, new int[]{topleft[0], midY + 1}, new int[]{midX, bottomRight[1]}, target) ||
                searchMatrix(matrix, new int[]{midX + 1, topleft[1]}, new int[]{bottomRight[0], midY}, target) ||
                searchMatrix(matrix, new int[]{midX + 1, midY + 1}, bottomRight, target);

    }
}
