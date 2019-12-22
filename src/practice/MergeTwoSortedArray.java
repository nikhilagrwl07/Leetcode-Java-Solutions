package practice;

import java.util.Arrays;
import java.util.Collections;

public class MergeTwoSortedArray {
    public static void main(String[] args) {

        MergeTwoSortedArray ob = new MergeTwoSortedArray();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};

        ob.merge(nums1, 3, nums2, 3);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int indexOfNum1 = m - 1;
        int indexOfNum2 = n - 1;
        int indexToSave = indexOfNum1 + n;

        while (indexOfNum1 >= 0 && indexOfNum2 >= 0) {

            if (nums1[indexOfNum1] >= nums2[indexOfNum2]) {
                nums1[indexToSave--] = nums1[indexOfNum1--];
            } else {
                nums1[indexToSave--] = nums2[indexOfNum2--];
            }
        }

        while (indexOfNum2 >= 0) {
            nums1[indexToSave--] = nums2[indexOfNum2--];
        }
    }
}
