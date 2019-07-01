/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package mock.amazon.set3;

import java.util.Arrays;

public class ProductExceptItself {
    public static void main(String[] args) {

        ProductExceptItself ob = new ProductExceptItself();
        int a[] = {1, 2, 3, 4};

        int[] productExceptSelf = ob.productExceptSelf(a);
        System.out.println(Arrays.toString(productExceptSelf));
    }


    // Problem - https://leetcode.com/problems/product-of-array-except-self/
    // Time Complexity - O(N)
    // Space Complexity - O(1) - Not counting the output product array
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];

        output[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            output[i] = output[i + 1] * nums[i + 1];
        }

        int left = 1;

        for (int i = 0; i < nums.length; i++) {
            output[i] = output[i] * left;
            left = left * nums[i];
        }

        return output;
    }

    // Time Complexity - O(N)
    // Space Complexity - O(N)
//    public int[] productExceptSelf(int[] nums) {
//
//        int[] left = new int[nums.length];
//        int[] right = new int[nums.length];
//
//        left[0] = 1;
//
//        for (int i = 1; i < left.length; i++) {
//            left[i] = nums[i - 1] * left[i - 1];
//        }
//
//        right[nums.length - 1] = 1;
//        for (int i = nums.length - 2; i >= 0; i--) {
//            right[i] = right[i + 1] * nums[i + 1];
//        }

//
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = left[i] * right[i];
//        }
//
//        return nums;
//    }
}
