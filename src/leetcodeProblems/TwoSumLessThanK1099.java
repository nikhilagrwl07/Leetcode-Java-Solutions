/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package leetcodeProblems;

import java.util.Arrays;

public class TwoSumLessThanK1099 {
    public static void main(String[] args) {

        TwoSumLessThanK1099 ob = new TwoSumLessThanK1099();
        int[] a = {34, 23, 1, 24, 75, 33, 54, 8};
        int K = 60;

//        int[] a = {10, 20, 30};
//        int K = 15;

        int[] twoSumLessThanK = ob.twoSumLessThanK(a, K);
        System.out.println(Arrays.toString(twoSumLessThanK));

    }

    public int[] twoSumLessThanK(int[] A, int K) {

        int[] indices = new int[2];
        indices[0] = -1;
        indices[1] = -1;

        if (A == null || A.length == 0)
            return indices;

//        Arrays.sort(A);
        int left = 0;
        int right = A.length - 1;
        int maximumSumLessthanK = -1;

        while (left < right) {
            int currentSum = A[left] + A[right];

            if (currentSum < K) {

                if (maximumSumLessthanK == -1) {
                    maximumSumLessthanK = currentSum;
                    indices[0] = left;
                    indices[1] = right;
                } else {
                    if (maximumSumLessthanK < currentSum) {
                        maximumSumLessthanK = currentSum;
                        indices[0] = left;
                        indices[1] = right;
                    }
                }
                left++;
            } else if (currentSum > K) {
                right--;
            } else {
                left++;
                right--;
            }

        }
        return indices;
    }
}
