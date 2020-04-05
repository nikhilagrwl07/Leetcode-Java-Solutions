package leetcodeProblems.hard;

public class TrapRainWater42 {
    public static void main(String[] args) {
        TrapRainWater42 ob = new TrapRainWater42();
//        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] height = {2, 0, 2};
        int trappedWater = ob.trap(height);
        System.out.println(trappedWater);

    }

    public int trap(int[] height) {
        if (height == null || height.length == 0)
            return 0;

        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];


        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);

            int j = height.length - 1 - i;
            rightMax[j] = Math.max(rightMax[j + 1], height[j + 1]);
        }

        int result = 0;
        for (int i = 0; i < height.length; i++) {
            int min = Math.min(leftMax[i], rightMax[i]);
            result += min <= height[i] ? 0 : (min - height[i]);
        }
        return result;
    }
}
