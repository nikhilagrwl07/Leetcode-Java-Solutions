/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package leetcodeProblems;

import java.util.Arrays;

public class UncrossedLines1035 {
    public static void main(String[] args) {
        UncrossedLines1035 ob = new UncrossedLines1035();
//        int[] A = {1, 4, 2};
//        int[] B = {1, 2, 4};

//        int[] A = {2, 5, 1, 2, 5}; // Length = 5
//        int[] B = {10, 5, 2, 1, 5, 2}; // Length = 6

        int[] A = {1, 3, 7, 1, 7, 5}; // Length = 5
        int[] B = {1, 9, 2, 5, 1}; // Length = 6

        int maxUncrossedLines = ob.maxUncrossedLines(A, B);
        System.out.println(maxUncrossedLines);

    }


    public int maxUncrossedLines(int[] A, int[] B) {

//        if (A.length < B.length) {
//            int[] ATmp = new int[B.length];
//            int len = ATmp.length - 1;
//            for (int i = A.length - 1; i >= 0; i--) {
//                ATmp[len--] = A[i];
//            }
//            while (len >= 0) {
//                ATmp[len] = -1;
//                len--;
//            }
//            A = ATmp;
//
//        } else if (A.length > B.length) {
//
//            int[] BTmp = new int[A.length];
//            int len = BTmp.length - 1;
//            for (int i = B.length - 1; i >= 0; i--) {
//                BTmp[len--] = B[i];
//            }
//            while (len >= 0) {
//                BTmp[len] = -1;
//                len--;
//            }
//            B = BTmp;
//        }

        int[][] lines = new int[A.length][B.length];
        for (int[] row : lines) {
            Arrays.fill(row, 0);
        }

        if (A[A.length - 1] == B[B.length - 1]) {
            lines[A.length - 1][B.length - 1] = 1;
        }

        for (int index = B.length - 2; index >= 0; index--) {
            if (A[A.length - 1] == B[index]) {
                lines[A.length - 1][index] = 1;
            } else {
                lines[A.length - 1][index] = lines[A.length - 1][index + 1];
            }
        }

        for (int index = A.length - 2; index >= 0; index--) {
            if (B[B.length - 1] == A[index]) {
                lines[index][B.length - 1] = 1;
            } else {
                lines[index][B.length - 1] = lines[index + 1][B.length - 1];
            }
        }

        for (int row = A.length - 2; row >= 0; row--) {

//            boolean isAOccupied = false;
            for (int col = B.length - 2; col >= 0; col--) {
                int result = 0;

                if (A[row] == B[col] && A[row] != -1 && B[col] != -1) {
                    result = 1;
//                    isAOccupied = true;
                }

                lines[row][col] = result + Math.max(lines[row + 1][col], lines[row][col + 1]);
//                        Math.max(lines[row][col + 1], lines[row + 1][col + 1]));
            }
        }

        return lines[0][0];
    }

//    public int maxUncrossedLines(int[] A, int[] B) {
//        return maxUncrossedLines(A, A.length - 1, B, B.length - 1);
//    }


    //plain Recursive Solution
    // Time Complexity - 2^(N+M)
//    public int maxUncrossedLines(int[] A, int indexOfA, int[] B, int indexOfB) {
//
//        int max = 0;
//        if (A[indexOfA] == B[indexOfB]) {
//            max = 1;
//        }
//
//        int a = -1, b = -1, c = -1;
//        if (indexOfA - 1 >= 0) {
//            a = maxUncrossedLines(A, indexOfA - 1, B, indexOfB);
//        }
//
//        if (indexOfB - 1 >= 0) {
//            b = maxUncrossedLines(A, indexOfA, B, indexOfB - 1);
//        }
//
//        if (indexOfA - 1 >= 0 && indexOfB - 1 >= 0) {
//            c = maxUncrossedLines(A, indexOfA - 1, B, indexOfB - 1);
//        }
//
//        if (a == -1 && b == -1 && c == -1) {
//            return max;
//        }
//        return max + Math.max(a, Math.max(b, c));
//
//    }

}
