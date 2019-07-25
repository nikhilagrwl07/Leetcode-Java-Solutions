/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package miscellaneous;

public class SearchElementInNearlySortedArray {
    public static void main(String[] args) {
        int arr[] = {10, 3, 40, 20, 50, 80, 70};
        int key = 40;
//        int key = 50;
        SearchElementInNearlySortedArray ob = new SearchElementInNearlySortedArray();
        int index = ob.searchInNearlySortedArray(arr, key);
        System.out.println(index);
    }

    public int searchInNearlySortedArray(int[] nums, int target) {

        if (nums == null)
            return -1;

        if (nums.length == 1) {

            if (nums[0] == target) {
                return 0;
            } else
                return -1;
        }

        if (target < Math.min(nums[0], nums[1])) {
            return -1;
        }

        if (target > Math.max(nums[nums.length - 1], nums[nums.length - 2])) {
            return -1;
        }

        return searchInNearlySortedArrayUtil(nums, 0, nums.length - 1, target);

    }

    // Time Complexity - O(logn) where n is total number of element
    // Space Complexity - O(1)
    public int searchInNearlySortedArrayUtil(int[] nums, int low, int high, int target) {

        if (low > high)
            return -1;

        int mid = low + (high - low) / 2;

        if (nums[mid] == target) {
            return mid;
        }

        if (mid - 1 >= low && nums[mid - 1] == target) {
            return mid - 1;
        }

        if (mid + 1 <= high && nums[mid + 1] == target) {
            return mid + 1;
        }

        if (target < nums[mid]) {
            return searchInNearlySortedArrayUtil(nums, low, mid - 2, target);
        } else {
            return searchInNearlySortedArrayUtil(nums, mid + 2, high, target);
        }
    }
}
