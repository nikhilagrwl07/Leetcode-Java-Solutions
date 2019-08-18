package leetcodeProblems;

public class FindSmallestMissingPositiveNumber41 {
    public static void main(String[] args) {

        FindSmallestMissingPositiveNumber41 ob = new FindSmallestMissingPositiveNumber41();

//        int[] a = {3, 2, -1, 1};
//        int[] a = {3, 0, -1, 1};
        int[] a = {3, 2, 4, -1};
        int firstMissingPositive = ob.firstMissingPositive(a);
        System.out.println(firstMissingPositive);
    }

    // Time Complexity - O(n)
    // Space Complexity - O(1)
    public int firstMissingPositive(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 1;
        }

        if (nums.length == 1) {
            return nums[0] == 1 ? 2 : 1;
        }


        // nums.length >=2 && if one is absent , then one will be answer
        boolean isOnePresent = findOneInArray(nums);
        if (!isOnePresent) {
            return 1;
        }

        // nums.length >=2 && if one is present ,
        // then clean data by replacing -ive , zero and number greater than n by 1
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > nums.length) {
                nums[i] = 1; // replacing by 1
            }
        }

        // for each number i , mark it's presence by overriding nums[i] to -nums[i]
        for (int i = 0; i < nums.length; i++) {

            int number = Math.abs(nums[i]);
            if (number == nums.length) {
                nums[0] = -Math.abs(nums[0]);   // Math.abs() will take care of duplicate element
            } else {
                nums[number] = -Math.abs(nums[number]); // Math.abs() will take care of duplicate element
            }
        }

        // find first positive number from left to right
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }

        return nums[0] < 0 ? nums.length + 1 : nums.length;
    }

    private boolean findOneInArray(int[] nums) {

        for (int i : nums) {
            if (i == 1) {
                return true;
            }
        }
        return false;
    }
}
