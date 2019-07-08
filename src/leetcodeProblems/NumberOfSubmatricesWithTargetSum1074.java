/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package leetcodeProblems;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubmatricesWithTargetSum1074 {
    public static void main(String[] args) {

    }


    public int numSubmatrixSumTarget(int[][] A, int target) {
        int r = A.length, column = A[0].length;

        for (int i = 0; i < r; i++)
            for (int j = 1; j < column; j++)
                A[i][j] += A[i][j - 1];

        int res = 0;

        for (int col1 = 0; col1 < column; col1++) {
            for (int col2 = col1; col2 < column; col2++) {


                Map<Integer, Integer> counter = new HashMap<>();

                counter.put(0, 1);

                int cur = 0;

                // Not able to understand this loop. Revisit later
                for (int row = 0; row < r; row++) {
                    cur += A[row][col2] - (col1 > 0 ? A[row][col1 - 1] : 0);
                    res += counter.getOrDefault(cur - target, 0);
                    counter.put(cur, counter.getOrDefault(cur, 0) + 1);
                }
            }
        }
        return res;
    }
}
