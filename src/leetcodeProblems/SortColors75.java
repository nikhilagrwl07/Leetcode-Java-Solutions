/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package leetcodeProblems;

import java.util.Arrays;

public class SortColors75 {
    public static void main(String[] args) {

        SortColors75 ob = new SortColors75();
//        int[] a = {2, 1, 2, 1, 0, 0};
        int[] a = {1, 0, 2, 1, 1, 0};
//        int[] a = {};
        System.out.println(Arrays.toString(a));
        ob.sortColors(a);
        System.out.println(Arrays.toString(a));

    }

    public void sortColors(int[] nums) {
        int low = 0, current = 0, high = nums.length - 1;

        // (0,low-1) -->  0
        // (low,high) -->  1
        // (high+1 , nums.length-1) -->  2
        while (current <= high) {

            if (nums[current] == 0) {
                swap(nums, low, current);
                low++;
                current++;
            } else if (nums[current] == 2) {
                swap(nums, current, high);
                high--;
            } else {
                current++;
            }
        }
    }

    private void swap(int[] nums, int i, int i1) {
        int t = nums[i];
        nums[i] = nums[i1];
        nums[i1] = t;
    }
}
