package leetcodeProblems.medium;

public class TargetSum494 {
    public static void main(String[] args) {
        TargetSum494 ob = new TargetSum494();

        int[] nums = {1, 1, 1, 1, 1};
        int targetSum=3;

        int targetSumWays = ob.findTargetSumWays(nums, targetSum);
        System.out.println(targetSumWays);
    }

    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0)
            return 0;

        char[] operator = {'+', '-'};

        int[] resultCount = new int[1];

        dfs(nums, operator, 0, 0, S, resultCount);
        return resultCount[0];
    }

    private void dfs(int[] nums, char[] operator, int index, int currentSum, int targetSum, int[] resultCount) {

        if (index >= nums.length)
            return;

        for (int i = 0; i < operator.length; i++) {
            int currentVal = (operator[i] == '+') ? (currentSum + nums[index]) : (currentSum - nums[index]);

            if (currentVal == targetSum && index == nums.length - 1) {
                resultCount[0] += 1;
            } else {
                dfs(nums, operator, index + 1, currentVal, targetSum, resultCount);
            }
        }
    }

}
