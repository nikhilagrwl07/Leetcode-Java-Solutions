/*
    Problem - Given a list of integers S and a target number k, write a function that returns a subset of S that adds up to k. If such a subset cannot be made, then return null.
    Solution - Recursion
    Time Complexity - O(2^n) means exponential
    Space Complexity - O(1)
 */


public class SubSetWithSumK {
    public static void main(String[] args) {

        int[] S = {12, 11, 61, 5, 9, 2};
        int K = 23;

        int[] subset = new int[S.length];

        SubSetWithSumK ob = new SubSetWithSumK();
        ob.findSubSet(S, 0, subset, 0, K);

    }

    private void findSubSet(int[] givenSet, int index, int[] subset, int indexOfSubSet, int sum) {

        if (index >= givenSet.length || indexOfSubSet >= subset.length) {
            return;
        }
        // not taking
        findSubSet(givenSet, index + 1, subset, indexOfSubSet, sum);

        //taking
        subset[indexOfSubSet] = givenSet[index];

        int sumOfSubset = getSum(subset, indexOfSubSet);

        if (sumOfSubset == sum) {
            printSubSet(subset, indexOfSubSet);
        }

        findSubSet(givenSet, index + 1, subset, indexOfSubSet + 1, sum);

    }

    private void printSubSet(int[] subset, int indexOfSubSet) {

        for (int i = 0; i <= indexOfSubSet; i++) {
            System.out.print(subset[i] + " ");
        }
        System.out.println();
    }

    private int getSum(int[] subset, int indexOfSubset) {
        int sumt = 0;

        for (int i = 0; i <= indexOfSubset; i++) {
            sumt += subset[i];
        }
        return sumt;
    }
}
