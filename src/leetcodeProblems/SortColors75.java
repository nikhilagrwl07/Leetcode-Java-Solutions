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
        int[] a = {2, 1, 2, 1, 0, 0};
        System.out.println(Arrays.toString(a));
        ob.sortColors(a);
        System.out.println(Arrays.toString(a));

    }

    public void sortColors(int[] nums) {

        if (nums == null || nums.length == 0) {
            return;
        }

        int low = 0, index = 0, high = nums.length - 1;

        // see below code as low and high are inclusive boundaries of number 1
        // and (0,low-1) is contained with 0
        // and (high+1,nums.length-1) is contained with 2
        // and (low,high) is contained with 1

        while (index <= high) {

            if (nums[index] == 0) {
                swap(nums, low, index);

                low++;
                index++;
            } else if (nums[index] == 2) {
                swap(nums, index, high);
                high--;
            } else {
                index++;
            }
        }
        System.out.println("low = " + low + " High = " + high);
    }

    private void swap(int[] nums, int i, int i1) {
        int t = nums[i];
        nums[i] = nums[i1];
        nums[i1] = t;
    }


}
