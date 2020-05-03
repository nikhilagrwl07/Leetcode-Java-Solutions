package leetcodeProblems;

public class MaximumSumSubArrayInArray53 {
    public static void main(String[] args) {
        int[] a = {-2,1,-3,4,-1,2,1,-5,4};
//        int[] a = {-2, -3, -1};
        MaximumSumSubArrayInArray53 ob = new MaximumSumSubArrayInArray53();
//        int maxSumSubArray = ob.maxSubArray(a);
        int maxSumSubArray = ob.maxSubArrayWithDCApproach(a);
        System.out.println(maxSumSubArray);
    }

    // Approach #1 - Greedy
    // Time - O(N)
    // Space - O(1)
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int maxSumTillNow = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            // case #1 -  nums[i] is positive and currentSum is negative
            // i.e., atleast one positive number is present
            if (nums[i] >= 0 && currentSum <= 0) {
                currentSum = nums[i];
            } else // case #2 -  Either nums[i] is negative OR currentSum is positive OR both
            { // i.e., no positive number is present
                currentSum = currentSum + nums[i];
            }
            maxSumTillNow = Math.max(maxSumTillNow, currentSum);
        }
        return maxSumTillNow;
    }


    // Approach #1 - DC approach
    // Time - O()
    // Space - O()
    public int maxSubArrayWithDCApproach(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return helper(nums, 0, nums.length - 1);
    }

    private int helper(int[] nums, int low, int high) {
        if (low == high)
            return nums[low];

        int mid = (low + high) / 2;

        int leftSubSum = helper(nums, low, mid);
        int rightSubSum = helper(nums, mid + 1, high);
        int crossOverSum = crossOverSum(nums, low, high, mid);

        return Math.max(leftSubSum, Math.max(rightSubSum, crossOverSum));
    }

    private int crossOverSum(int[] nums, int low, int high, int mid) {

        System.out.println("low = " + low+" mid = "+ mid+ " high = "+high);
        int currentSum = 0;
        int leftSumSoFar = Integer.MIN_VALUE;

        for (int i = mid; i >= low; i--) {
            currentSum += nums[i];
            leftSumSoFar = Math.max(leftSumSoFar, currentSum);
        }

        currentSum = 0;
        int rightSumSoFar = Integer.MIN_VALUE;

        for (int i = mid + 1; i <= high; i++) {
            currentSum += nums[i];
            rightSumSoFar = Math.max(rightSumSoFar, currentSum);
        }
        return leftSumSoFar + rightSumSoFar;
    }

}
