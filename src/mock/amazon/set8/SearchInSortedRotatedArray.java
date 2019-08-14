package mock.amazon.set8;

public class SearchInSortedRotatedArray {
    public static void main(String[] args) {

        SearchInSortedRotatedArray ob = new SearchInSortedRotatedArray();
//        int[] nums = {4, 5, 6, 7, 0, 1, 2};
//        int target = 0;
//        int target = 2;
        int[] nums = {0, 1, 2, 4, 5, 6, 7};
        int target = 6;

        int index = ob.search(nums, target);
        System.out.println(index);
    }

    public int search(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int pivotIndex = findPivotIndex(nums, 0, nums.length - 1);

        if (pivotIndex == -1) {
            pivotIndex = nums.length - 1;
        }

        if (nums[pivotIndex] == target) {
            return pivotIndex;
        }

        if (target >= nums[0] && target < nums[pivotIndex]) {
            return searchTarget(nums, 0, pivotIndex, target);
        } else {
            return searchTarget(nums, pivotIndex + 1, nums.length - 1, target);
        }

    }

    private int searchTarget(int[] nums, int low, int high, int target) {
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;

        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return searchTarget(nums, mid + 1, high, target);
        } else {
            return searchTarget(nums, low, mid - 1, target);
        }
    }

    private int findPivotIndex(int[] nums, int low, int high) {

        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;

//        if()

        if (mid - 1 >= low && nums[mid - 1] > nums[mid]) {
            return mid - 1;
        }

        if (mid + 1 <= high && nums[mid + 1] < nums[mid]) {
            return mid;
        }


        int pivotIndexToLeft = findPivotIndex(nums, low, mid - 1);

        if (pivotIndexToLeft != -1) {
            return pivotIndexToLeft;
        }

        return findPivotIndex(nums, mid + 1, high);

    }
}
