package leetcodeProblems.medium;

import java.util.Arrays;

public class LongestIncreasingSubSequence300 {
    public static void main(String[] args) {
        LongestIncreasingSubSequence300 ob = new LongestIncreasingSubSequence300();
        int[] a1 = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] a2 = {18};
        int[] a3 = {18, 11};
        int[] a4 = {18, 11, 12};
        int[] a5 = {};
        int[] a6 = {4, 10, 4, 3, 8, 9};
        int[] a7 = {0, 8, 4, 12, 2};

        System.out.println(ob.lengthOfLIS(a1));
        System.out.println(ob.lengthOfLIS(a2));
        System.out.println(ob.lengthOfLIS(a3));
        System.out.println(ob.lengthOfLIS(a4));
        System.out.println(ob.lengthOfLIS(a5));
        System.out.println(ob.lengthOfLIS(a6));
        System.out.println(ob.lengthOfLISUsingBinarySearch(a7));
    }

    // Time - O(N * logN)
    // Space - O(N)
    public int lengthOfLISUsingBinarySearch(int[] nums) {

        if (nums == null || nums.length == 0)
            return 0;

        int lis[] = new int[nums.length];
        int indexOfNums = 0, indexOfLis = 0;

        lis[indexOfLis] = nums[indexOfNums];
        indexOfNums++;

        while (indexOfNums < nums.length) {

            int index = binarySearch(lis, 0, indexOfLis, nums[indexOfNums]);

            if (index == -1) {
                indexOfLis++;
                lis[indexOfLis] = nums[indexOfNums];
            } else {
                lis[index] = nums[indexOfNums];
            }
            indexOfNums++;
        }

        return indexOfLis + 1;
    }

    private int binarySearch(int[] lis, int low, int high, int target) {

        if (low > high)
            return -1;

        int mid = low + (high - low) / 2;

        if (lis[mid] == target) return mid;

        if(lis[high] < target)
            return -1;

        if(target < lis[low])
            return low;

        if (mid - 1 >= 0 && lis[mid - 1] < target && lis[mid] > target)
                return mid;

        if(lis[mid] < target)
            return binarySearch(lis, mid+1, high, target);

        return binarySearch(lis, low, mid-1, target);

    }

    // Time - O(N*N)
    // Space - O(N)
    public int lengthOfLIS(int[] nums) {

        if (nums == null || nums.length == 0)
            return 0;

        int[] lisLength = new int[nums.length];
        Arrays.fill(lisLength, 1);
        int max = Integer.MIN_VALUE;

        for (int j = 0; j < nums.length; j++) {

            for (int i = 0; i < j; i++) {

                if (nums[i] < nums[j]) {
                    lisLength[j] = Math.max(lisLength[j], lisLength[i] + 1);
                }
            }
            max = Math.max(max, lisLength[j]);
        }

        return max;
    }
}
