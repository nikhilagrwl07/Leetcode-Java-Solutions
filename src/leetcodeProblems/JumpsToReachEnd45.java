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

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] storedJumps = new int[nums.length];

        int jumpsCount = jumpsCount(nums, 0, storedJumps);
        return jumpsCount;

    }


    public int jumpsCount(int[] jumps, int currentIndex, int[] storedJumps) {


        if (currentIndex == jumps.length - 1) {
            storedJumps[currentIndex] = 0;
            return 0;
        }

        if (storedJumps[currentIndex] > 0) {
            return storedJumps[currentIndex];
        }
        int maxJumpsPossible = jumps[currentIndex];
        int minJumps = Integer.MAX_VALUE;

        for (int j = 1; j <= maxJumpsPossible && (currentIndex + j) <= jumps.length - 1; j++) {

            if (jumps[currentIndex + j] > 0 || currentIndex + j == jumps.length - 1) {

                int count = 1 + jumpsCount(jumps, currentIndex + j, storedJumps);

                if (count >= 1 && count < Integer.MAX_VALUE) {
                    if (count < minJumps) {
                        minJumps = count;
                    }
                }

                if ((storedJumps[currentIndex + j] > minJumps)) {
                    storedJumps[currentIndex + j] = minJumps;
                }
            }
        }
        return minJumps;
    }
}
