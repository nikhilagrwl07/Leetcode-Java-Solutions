/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package leetcodeProblems;

public class SearchAndInsertPosition35 {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 6};
//        int target = 5;
//        int target = 2;
//        int target = 7;
        int target = 0;

        SearchAndInsertPosition35 ob = new SearchAndInsertPosition35();

        int searchIndex = ob.searchInsert(a, target);
        System.out.println(searchIndex);
    }

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (target <= nums[0])
            return 0;

        if (target == nums[nums.length - 1]) {
            return nums.length - 1;
        }

        if (target > nums[nums.length - 1]){
            return nums.length;
        }
        return searchInsertUtil(nums, target, 0, nums.length - 1);
    }

    private int searchInsertUtil(int[] nums, int target, int low, int high) {

        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;

        if (nums[mid] == target) {
            return mid;
        }

        if (nums[mid] > target && mid - 1 >= 0 && nums[mid - 1] < target) {
            return mid;
        }

        if (nums[mid] < target && (mid + 1) >= nums.length - 1 && nums[mid + 1] > target) {
            return mid + 1;
        }

        if (target < nums[mid]) {
            return searchInsertUtil(nums, target, low, mid - 1);
        } else {
            return searchInsertUtil(nums, target, mid + 1, high);
        }
    }
}
