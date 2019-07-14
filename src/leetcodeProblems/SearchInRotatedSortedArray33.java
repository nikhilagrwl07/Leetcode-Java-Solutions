/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package leetcodeProblems;

public class SearchInRotatedSortedArray33 {
    public static void main(String[] args) {

        SearchInRotatedSortedArray33 ob = new SearchInRotatedSortedArray33();

//        int[] a = {1, 2, 3, 4};
//        int target = 4;

//        int[] a = {1, 2, 4, 7, 0};
        int[] a = {1, 2, 4, 7, 0};
        int target = 1;

        int searchindex = ob.search(a, target);
        System.out.println(searchindex);


    }

    public int search(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        if (nums.length == 1) {
            if (nums[0] == target)
                return 0;
            else
                return -1;
        }

        int pivotIndex;

        if (nums[nums.length - 1] > nums[0]) {
            pivotIndex = nums.length - 1;
        } else {
            pivotIndex = findPivotIndex(nums, 0, nums.length - 1);
        }

        if (target >= nums[0] && target <= nums[pivotIndex]) {
            return binarySearch(nums, 0, pivotIndex, target);
        } else
            return binarySearch(nums, pivotIndex + 1, nums.length - 1, target);


    }

    private int binarySearch(int[] nums, int low, int high, int target) {

        if (low > high)
            return -1;

        int mid = low + (high - low) / 2;

        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return binarySearch(nums, mid + 1, high, target);
        } else {
            return binarySearch(nums, low, mid - 1, target);
        }
    }

    private int findPivotIndex(int[] a, int low, int high) {
        if (low > high)
            return -1;

        int mid = low + (high - low) / 2;


        if (mid - 1 >= low && a[mid] > a[mid - 1] && mid + 1 <= high && a[mid] > a[mid + 1]) {
            return mid;
        }

        if (mid + 1 <= high && a[mid] > a[mid + 1]) {
            return mid;
        }

        if (mid - 1 >= low && a[mid] < a[mid - 1]) {
            return mid - 1;
        }

        if (a[low] < a[mid]) {
            return findPivotIndex(a, mid + 1, high);
        } else {
            return findPivotIndex(a, low, mid - 1);
        }
    }
}
