/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package leetcodeProblems;

public class MaximumProductSubArray152 {
    public static void main(String[] args) {
//        int[] a = {2, 3, -2, 4};
        int[] a = {-2, -3, 0, -2, -40};

        MaximumProductSubArray152 ob = new MaximumProductSubArray152();
        int maxProduct = ob.maxProduct(a);
        System.out.println(maxProduct);
    }


    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int currentMax = nums[0], currentMin = nums[0];
        int previousMax = nums[0], previousMin = nums[0];
        int ans = nums[0];


        for (int i = 1; i <= nums.length - 1; i++) {
            currentMax = Math.max(previousMax * nums[i], Math.max(previousMin*nums[i], nums[i]));
            currentMin = Math.min(previousMax * nums[i], Math.min(previousMin*nums[i], nums[i]));

            ans = Math.max(ans, currentMax);
            previousMax = currentMax;
            previousMin = currentMin;
        }

        return ans;

    }
}
