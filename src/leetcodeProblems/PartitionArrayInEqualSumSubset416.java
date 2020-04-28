/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package leetcodeProblems;

import java.util.Arrays;

public class PartitionArrayInEqualSumSubset416 {
    public static void main(String[] args) {

//        int[] arr = {1, 5, 11, 5};
//        int[] arr = {1, 2, 3, 5};
//        int[] arr = {1};
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        PartitionArrayInEqualSumSubset416 ob = new PartitionArrayInEqualSumSubset416();
        boolean canPartition = ob.canPartition(arr);
        System.out.println(canPartition);

    }

    public boolean canPartition(int[] nums) {

        if (nums.length <= 1) {
            return false;
        }
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;
        int leftSum = nums[left];
        int rightSum = nums[right];

        while (right - left > 1) {

            while (left + 1 < right && leftSum + nums[left + 1] <= rightSum) {
                left++;
                leftSum += nums[left];

            }

            while (right - 1 > left && rightSum + nums[right - 1] >= leftSum) {
                right--;
                rightSum += nums[right];
            }
        }

        return leftSum == rightSum;

    }
}
