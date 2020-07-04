package practice;

public class HouseRobber198 {
    public static void main(String[] args) {
        HouseRobber198 ob = new HouseRobber198();

        int[] a1 = {2, 3, 2};
        int[] a2 = {1, 2, 3, 1};
        int[] a3 = {1, 3, 1, 3, 100};
        System.out.println(ob.rob(a1));
        System.out.println(ob.rob(a2));
        System.out.println(ob.rob(a3));

    }

    public int rob(int[] nums) {

        if(nums== null || nums.length==0)
            return 0;

        if (nums.length == 1)
            return nums[0];

        int[] max = new int[nums.length];
        max[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int first = max[i - 1];
            int second = (i - 2) >= 0 ? max[i - 2] + nums[i] : nums[i];
            max[i] = Math.max(first, second);
        }
        return max[nums.length-1];
    }
}
