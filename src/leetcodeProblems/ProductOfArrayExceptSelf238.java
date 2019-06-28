/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package leetcodeProblems;

import java.util.Arrays;

public class ProductOfArrayExceptSelf238 {
    public static void main(String[] args) {
        ProductOfArrayExceptSelf238 ob = new ProductOfArrayExceptSelf238();

        int a[] = {1, 2, 3, 4};
        int[] product = ob.productExceptSelf(a);
        System.out.println(Arrays.toString(product));


    }

    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] product = new int[nums.length];

        int l = 1;
        int r = 1;

        left[0] = l;
        for (int j = 1; j <= nums.length - 1; j++) {
            left[j] = nums[j-1] * l;
            l = left[j];
        }

        right[nums.length - 1] = r;
        for (int j = nums.length - 2; j >= 0; j--) {
            right[j] = nums[j+1] * r;
            r = right[j];
        }


        for (int i = 0; i < nums.length; i++) {

            product[i] = left[i] * right[i];
        }

        return product;

    }
}
