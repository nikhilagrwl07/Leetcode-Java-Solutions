/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package leetcodeProblems;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionsOfIntervalList986 {
    public static void main(String[] args) {
        int[][] A =
                {{0, 2},
                        {5, 10},
                        {13, 23},
                        {24, 25}};

        int[][] B = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};

        IntersectionsOfIntervalList986 ob = new IntersectionsOfIntervalList986();
        int[][] pairs = ob.intervalIntersection(A, B);
        System.out.println(Arrays.deepToString(pairs));

    }

    //    Time Complexity: O(M + N), where M, NM,N are the lengths of A and B respectively.
//    Space Complexity: O(M + N), the maximum size of the answer.
    public int[][] intervalIntersection(int[][] A, int[][] B) {

        if (A.length == 0 || B.length == 0) {
            return new int[0][0];
        }

        List<Pair> pair = new ArrayList<>();
        int i = 0, j = 0;

        while (i < A.length && j < B.length) {

            int low = Math.max(A[i][0], B[j][0]);
            int high = Math.min(A[i][1], B[j][1]);

            if (low <= high) {
                pair.add(new Pair<>(low, high));
            }

            if (A[i][1] < B[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        int[][] result = new int[pair.size()][2];
        i = 0;
        for (Pair pair1 : pair) {
            result[i][0] = (int) pair1.getKey();
            result[i][1] = (int) pair1.getValue();
            i++;
        }

        return result;
    }

    // Time Complexity - O(N * M) where N is A's length and M is B's length
//    public int[][] intervalIntersection(int[][] A, int[][] B) {
//
//        if (A == null || A.length == 0 || A[0].length == 0 ||
//                B == null || B.length == 0 || B[0].length == 0) {
//            return new int[0][0];
//        }
//
//        int[][] pair = new int[A.length + B.length][2];
//        int index = 0;
//        for (int Arow = 0; Arow < A.length; Arow++) {
//            int lowerLimitA = A[Arow][0];
//            int upperLimitA = A[Arow][1];
//
//            for (int Brow = 0; Brow < B.length; Brow++) {
//
//                int lowerLimitB = B[Brow][0];
//                int upperLimitB = B[Brow][1];
//
//                if (!(lowerLimitA > upperLimitB || upperLimitA < lowerLimitB)) {
//
//                    if (index == 0) {
//                        pair[index][0] = Math.max(lowerLimitA, lowerLimitB);
//                        pair[index][1] = Math.min(upperLimitA, upperLimitB);
//                        index++;
//                    } else {
//
//                        int[] lastPair = {pair[index - 1][0], pair[index - 1][1]};
//
//                        if (lastPair[1] < Math.max(lowerLimitA, lowerLimitB)) {
//                            pair[index][0] = Math.max(lowerLimitA, lowerLimitB);
//                            pair[index][1] = Math.min(upperLimitA, upperLimitB);
//                            index++;
//                        } else {
//
//                            pair[index - 1][0] = lastPair[0];
//                            pair[index - 1][1] = Math.min(upperLimitA, upperLimitB);
//                        }
//                    }
//
//                }
//            }
//        }
//
//        int[][] result = new int[index][2];
//        int i = 0;
//
//        for (int r = 0; r < index; r++) {
//            result[i][0] = pair[r][0];
//            result[i][1] = pair[r][1];
//            i++;
//        }
//        return result;
//    }
}
