package leetcodeProblems.medium;

public class SearchInRotatedSortedArray33 {
    public static void main(String[] args) {

        SearchInRotatedSortedArray33 ob = new SearchInRotatedSortedArray33();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int target2 = 3;

        int[] nums2 = {1, 3};
        int target3 = 3;

        int[] nums3 = {5, 1, 3};
        int target4 = 5;

        int index = ob.search(nums, target);
        int index2 = ob.search(nums, target2);
        int index3 = ob.search(nums2, target3);
        int index4 = ob.search(nums3, target4);

        System.out.println(index);
        System.out.println(index2);
        System.out.println(index3);
        System.out.println(index4);
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target)
                return mid;

            // rotation happened
            if (nums[low] > nums[high]) {
                // mid < target < high
                if (target == nums[high])
                    return high;
                else
                    high--;
            }
            // no rotation
            else {
                if (target < nums[low] || nums[high] < target)
                    return -1;

//                low <= target < mid
                if (nums[low] <= target && target < nums[mid])
                    high = mid - 1;

//                mid < target <= high
                if (nums[mid] < target && target <= nums[high])
                    low = mid + 1;
            }
        }

        if (nums[low] == target)
            return low;
        else
            return -1;
    }
}
