/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package leetcodeProblems;

import java.util.Arrays;

public class RotateArrayByK189 {
    public static void main(String[] args) {

        RotateArrayByK189 ob = new RotateArrayByK189();
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        int k = 8;
        ob.rotate(a, k);
        System.out.println(Arrays.toString(a));
    }

    public void rotate(int[] nums, int k) {

        if (k == nums.length) {
            return;
        }

        if (k > nums.length) {
            k = k % nums.length;
        }

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int s, int e) {

        while (s < e) {
            int t = nums[s];
            nums[s] = nums[e];
            nums[e] = t;
            s++;
            e--;
        }
    }

}
