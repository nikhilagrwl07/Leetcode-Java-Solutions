/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package mock.microsoft.set1;

import java.util.Arrays;

public class SortThreeColor {
    public static void main(String[] args) {

        SortThreeColor ob = new SortThreeColor();
        int[] color = {2, 0, 2, 1, 1, 0};
        System.out.println(Arrays.toString(color));
        ob.sortColors(color);
        System.out.println(Arrays.toString(color));
    }

    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0)
            return;

        int zeroCount = 0, oneCount = 0, twoCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            } else if (nums[i] == 1) {
                oneCount++;
            } else {
                twoCount++;
            }
        }

        int index = 0;
        for (int i = 1; i <= zeroCount; i++) {
            nums[index++] = 0;
        }

        for (int i = 1; i <= oneCount; i++) {
            nums[index++] = 1;
        }

        for (int i = 1; i <= twoCount; i++) {
            nums[index++] = 2;
        }
    }
}
