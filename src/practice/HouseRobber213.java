package practice;

public class HouseRobber213 {
    public static void main(String[] args) {
        HouseRobber213 ob = new HouseRobber213();

        int[] a1 = {2, 3, 2};
        int[] a2 = {1, 2, 3, 1};
        int[] a3 = {1, 3, 1, 3, 100};
        int[] a4 = {1, 2, 1, 1};

        System.out.println(ob.rob(a1));
        System.out.println(ob.rob(a2));
        System.out.println(ob.rob(a3));
        System.out.println(ob.rob(a4));

    }

    // Not Working
    public int rob(int[] nums) {

        if(nums== null || nums.length==0)
            return 0;

        if (nums.length == 1)
            return nums[0];

        // ignore last Index
        int[] max = new int[nums.length-1];
        max[0] = nums[0];

        for (int i = 1; i < nums.length-1; i++) {

            int first = max[i - 1];
            int second = (i - 2) >= 0 ? max[i - 2] + nums[i] : nums[i];
            max[i] = Math.max(first, second);
        }


        // ignore first Index
        int[] max2 = new int[nums.length-1];
        max2[0] = nums[1];

        for (int i = 2; i <= nums.length-1; i++) {

            int indexOfMax = i-1;

            int first = max2[indexOfMax];
            int second = (indexOfMax - 2) >= 0 ? max2[indexOfMax-2] + nums[i] : nums[i];

            max2[indexOfMax] = Math.max(first, second);
        }

        return Math.max(max[max.length-1], max2[max.length-1]);
    }
}
