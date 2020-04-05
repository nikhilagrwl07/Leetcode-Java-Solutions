/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package leetcodeProblems.medium;

import java.util.Arrays;

public class ProductOfArrayExceptSelf238 {
    public static void main(String[] args) {
        ProductOfArrayExceptSelf238 ob = new ProductOfArrayExceptSelf238();

//        int a[] = {1, 2, 3, 4};
        int a[] = {1, 2, 3};
        int[] product = ob.productExceptSelf(a);
        System.out.println(Arrays.toString(product));
    }

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int leftProduct = 1;
        int rightProduct = 1;
        for (int i = 0; i <= nums.length - 1; i++) {

            if (i > 0)
                leftProduct = leftProduct * nums[i - 1];

            int j = nums.length - 1 - i;

            if (j < nums.length - 1)
                rightProduct = rightProduct * nums[j + 1];

            if (i < j) {
                result[i] = leftProduct;
                result[j] = rightProduct;
            } else if (i == j) {
                result[i] = leftProduct * rightProduct;
            } else {
                result[i] = result[i] * leftProduct;
                result[j] = result[j] * rightProduct;
            }
        }
        return result;
    }
}
