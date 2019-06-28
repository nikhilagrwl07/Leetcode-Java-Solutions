/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package leetcodeProblems;

public class JumpsToReachEnd55 {
    public static void main(String[] args) {
//        int[] jumps = {5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0};
//        int[] jumps = {2,3,1,1,4};
        int[] jumps = {3,2,1,0,4};
//        int[] jumps = {2, 0};

        JumpsToReachEnd55 ob = new JumpsToReachEnd55();
        boolean canJump = ob.canJump(jumps);
        System.out.println(canJump);
    }

    public boolean canJump(int[] nums) {

        if (nums == null || nums.length == 0) {
            return false;
        }

        Status[] memo = new Status[nums.length];
        for (int i = 0; i <= nums.length - 2; i++) {
            memo[i] = Status.UNKNOWN;
        }
        memo[nums.length - 1] = Status.GOOD;

//        return canJumpUtilTopDownDP(nums, memo, 0);
//        return canJumpUtilBottomUpDP(nums, memo);
        return canJumpUtilGreedyApproach(nums);
    }

    // Top down approach as recursion is happening
    // Time complexity - O(n^2)
    // Space complexity - O(n)
    private boolean canJumpUtilTopDownDP(int[] nums, Status[] memo, int index) {

        if (memo[index] == Status.GOOD)
            return true;

        if (memo[index] == Status.BAD)
            return false;

        for (int jumps = index + 1;
             jumps <= Math.min(index + nums[index], nums.length - 1); jumps++) {

            if (canJumpUtilTopDownDP(nums, memo, jumps)) {
                memo[index] = Status.GOOD;
                return true;
            }
        }

        memo[index] = Status.BAD;
        return false;
    }

    // Bottom up approach as recursion is NOT happening
    // Time complexity - O(n^2)
    // Space complexity - O(n)
    private boolean canJumpUtilBottomUpDP(int[] nums, Status[] memo) {

        for (int position = nums.length - 2; position >= 0; position--) {

            int maxJumpPossible = Math.min(position + nums[position], nums.length - 1);

            for (int jump = position+1; jump <= maxJumpPossible; jump++) {
                if (memo[jump] == Status.GOOD) {
                    memo[position] = Status.GOOD;
                    break;
                }
            }
        }
        return memo[0] == Status.GOOD;

    }

    private boolean canJumpUtilGreedyApproach(int[] nums) {

        int leftMostGood = nums.length-1;

        for (int position = nums.length - 2; position >= 0; position--) {

            int maxJumpPossible = Math.min(position + nums[position], nums.length - 1);
            if(maxJumpPossible>=leftMostGood){
                leftMostGood = position;
            }
        }

        return leftMostGood == 0;

    }

    enum Status {
        GOOD,
        BAD,
        UNKNOWN;
    }
}
