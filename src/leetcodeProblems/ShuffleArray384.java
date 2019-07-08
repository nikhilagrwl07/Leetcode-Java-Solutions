/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package leetcodeProblems;

import java.util.Arrays;
import java.util.Random;

public class ShuffleArray384 {
    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        Solution obj = new Solution(nums);
        int[] param_1 = obj.reset();
        System.out.println(Arrays.toString(param_1));
        int[] param_2 = obj.shuffle();
        System.out.println(Arrays.toString(param_2));
    }
}

class Solution {

    int[] original;
    int[] shuffled;
    Random random;

    public Solution(int[] nums) {
        original = nums;
        shuffled = nums.clone();
        random = new Random();

        int index = 0;
        for (int number : original) {
            shuffled[index++] = number;
        }
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        shuffled = original.clone();
        return shuffled;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        for (int i = shuffled.length - 1; i >= 0; i--) {
            int randomposition = random.nextInt(i + 1);
            swap(shuffled, i, randomposition);
        }

        return shuffled;
    }

    private void swap(int[] shuffled, int i1, int i2) {
        int t = shuffled[i1];
        shuffled[i1] = shuffled[i2];
        shuffled[i2] = t;

    }
}
