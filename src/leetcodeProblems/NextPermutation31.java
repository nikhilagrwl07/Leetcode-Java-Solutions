package leetcodeProblems;

import java.util.Arrays;

public class NextPermutation31 {
    public static void main(String[] args) {

        NextPermutation31 ob = new NextPermutation31();
//        int[] a = {1, 2, 3};
//        int[] a = {1, 2, 1};
//        int[] a = {3, 2, 1};
//        int[] a = {1, 1, 5};
//        int[] a = {1, 3, 2};
//        int[] a = {2, 3, 1};
        int[] a = {2, 2, 2};
//        int[] a = {4, 2, 0, 2, 3, 2, 0};
        System.out.println(Arrays.toString(a));
        ob.nextPermutation(a);
        System.out.println(Arrays.toString(a));
    }

    public void nextPermutation(int[] nums) {

        if (nums == null || nums.length == 1) {
            return;
        }

        // right to left, find first nums[left] < nums[right] and swap
        boolean swapped = false;
        for (int i = nums.length - 2; i >= 0; i--) {

            int elementToRightOfI = i + 1;
            if (nums[elementToRightOfI] > nums[i]) {

                // index i represent first smaller number traversed from right to left
                int indexJustGreaterThanItoRight = findElementJustGreaterThanI(nums, i);

                // no
                if (indexJustGreaterThanItoRight == -1)
                    continue;

                // swap index elementToRightOfI with indexJustGreaterThanItoRight
                swapInplace(nums, indexJustGreaterThanItoRight, i);

                // sort array in asc order from i+1 to nums.length
                Arrays.sort(nums, i + 1, nums.length);
                swapped = true;

            }
            if (swapped) {
                break;
            }
        }

        // all numbers are in desc order
        if (!swapped) {
            reverseNums(nums);
        }
    }

    private int findElementJustGreaterThanI(int[] nums, int j) {

        int diff = Integer.MAX_VALUE;
        int index = -1;

        for (int i = j + 1; i < nums.length; i++) {

            if (nums[i] > nums[j] && (nums[i] - nums[j]) < diff) {
                diff = nums[i] - nums[j];
                index = i;
            }
        }
        return index;
    }


    private void reverseNums(int[] nums) {

        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            swapInplace(nums, low, high);
            low++;
            high--;
        }
    }

    private void swapInplace(int[] nums, int low, int high) {
        int t = nums[low];
        nums[low] = nums[high];
        nums[high] = t;
    }
}
