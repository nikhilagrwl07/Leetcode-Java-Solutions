/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 *//*



package main.java;

public class RotateClockWise2DMatrix {

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

        printMatrix(a);
        System.out.println();
        rotateClockWise(a);
        printMatrix(a);
    }

    private static void rotateClockWise(int[][] a) {

        int start = 0, end = a.length - 1;

        while (start < end) {
            int x1 = start, y1 = start, x2 = start, y2 = end, x3 = end, y3 = end, x4 = end, y4 = start;


            int diff = end - start + 1;
            int current = 0;

            while (current < diff) {

                shift(a, x1, y1, x2, y2, x3, y3, x4, y4);

                y1 += 1;

                x2 += 1;

                y3 -= 1;

                x4 -= 1;

                current++;
            }

            start++;
            end--;
        }

    }

    private static void shift(int[][] a, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {

        int temp = a[x1][y1];
        a[x1][y1] = a[x4][y4];
        a[x4][y4] = a[x3][y3];
        a[x3][y3] = a[x2][y2];
        a[x2][y2] = temp;
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
*/
