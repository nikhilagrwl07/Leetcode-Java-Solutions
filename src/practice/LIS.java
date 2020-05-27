package practice;

public class LIS {
    public static void main(String[] args) {
        LIS ob = new LIS();
        int[] a1 = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] a2 = {18};
        int[] a3 = {18, 11};
        int[] a4 = {18, 11, 12};
        int[] a5 = {};
        int[] a6 = {4, 10, 4, 3, 8, 9};

//        System.out.println(ob.lengthOfLIS(a1));
//        System.out.println(ob.lengthOfLIS(a2));
//        System.out.println(ob.lengthOfLIS(a3));
//        System.out.println(ob.lengthOfLIS(a4));
//        System.out.println(ob.lengthOfLIS(a5));
        System.out.println(ob.lengthOfLIS(a6));
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int[][] maxLISLength = new int[nums.length][nums.length];

        return Math.max(1 + lengthOfLIS(nums, 1, 0, maxLISLength),
                lengthOfLIS(nums, 1, null, maxLISLength));
    }

    private int lengthOfLIS(int[] nums, Integer index, Integer historyIndex, int[][] maxLISLength) {
        if (index > nums.length - 1)
            return 0;

        if (historyIndex != null && maxLISLength[historyIndex][index] > 0)
            return maxLISLength[historyIndex][index];
        else if (historyIndex == null && maxLISLength[index][index] > 0) {
            return maxLISLength[index][index];
        }

        int taken = 0;
        if (historyIndex != null && nums[historyIndex] < nums[index]) {
            taken = Math.max(taken, 1 + lengthOfLIS(nums, index + 1, index, maxLISLength));
        } else if (historyIndex == null) {
            taken = Math.max(taken, 1 + lengthOfLIS(nums, index + 1, index, maxLISLength));
        }

        taken = Math.max(taken, lengthOfLIS(nums, index + 1, historyIndex, maxLISLength));

        if (historyIndex != null) {
            maxLISLength[historyIndex][index] = taken;
        } else {
            maxLISLength[index][index] = taken;

        }
        return taken;
    }
}
