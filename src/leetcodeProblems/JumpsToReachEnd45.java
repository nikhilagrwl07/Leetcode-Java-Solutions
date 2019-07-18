/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package leetcodeProblems;

public class JumpsToReachEnd45 {
    public static void main(String[] args) {
//        int[] jumps = {2, 3, 0, 1, 4};
//        int[] jumps = {2,3,1,1,4};
        int[] jumps = {5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0};
//        int[] jumps = {5, 6, 4, 4, 6, 9, 4, 4, 7, 4, 4, 8, 2, 6, 8, 1, 5, 9, 6, 5, 2, 7, 9, 7, 9, 6, 9, 4, 1, 6, 8, 8, 4, 4, 2, 0, 3, 8, 5};

        JumpsToReachEnd45 ob = new JumpsToReachEnd45();
        int minimumJumps = ob.jump(jumps);
        System.out.println(minimumJumps);
    }

    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int[] jumps = new int[nums.length];
        jumps[0] = 0;

        for (int currentIndex = 0; currentIndex <= nums.length - 1; currentIndex++) {


            for (int j = 1; (j <= nums[currentIndex] && currentIndex + j <= nums.length - 1); j++) {
                if (jumps[currentIndex + j] == 0) {
                    jumps[currentIndex + j] = jumps[currentIndex] + 1;
                }
            }

            if (jumps[nums.length - 1] != 0)
                return jumps[nums.length - 1];
        }

        return jumps[nums.length - 1];
    }
}
