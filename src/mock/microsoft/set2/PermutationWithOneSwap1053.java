/*
    Problem - https://leetcode.com/problems/previous-permutation-with-one-swap
    Solution - Greedy
    Time Complexity - O(N)
    Space Complexity - O(1)
 */


package mock.microsoft.set2;

import java.util.Arrays;

public class PermutationWithOneSwap1053 {
    public static void main(String[] args) {
        PermutationWithOneSwap1053 ob = new PermutationWithOneSwap1053();

//        int[] a = {1,9,4,6,7};
//        int[] a = {3, 2, 1};
//        int[] a = {1,1,5};
        int[] a = {3,1,1,3};

        int[] largestPermutationWithOneSwapSmallerThanA = ob.prevPermOpt1(a);

        System.out.println(Arrays.toString(largestPermutationWithOneSwapSmallerThanA));
    }

    // Algorithm -
//    1. Start from right to left
//    2. Find first index i which is greater than  i+1
//    3. If index i is not found, then given array already descending sorted
//    4. If index i is found, then in subarray from i+1 till end, find leftmost index t smaller than a[i]
//    5. Swap index i and t
    public int[] prevPermOpt1(int[] A) {

        if (A.length == 1)
            return A;

        int index = -1;

        for (int i = A.length - 1; i >= 1; i--) {
            if (A[i] < A[i - 1]) {
                index = i - 1;
                break;
            }
        }

        if (index == -1)
            return A;


        for (int i = A.length - 1; i > index; i--) {

            if (A[i] < A[index] && A[i] != A[i - 1]) {
                swap(A, i, index);
                break;
            }
        }
        return A;
    }

    private void swap(int[] a, int i1, int i2) {
        int t = a[i1];
        a[i1] = a[i2];
        a[i2] = t;

    }
}
