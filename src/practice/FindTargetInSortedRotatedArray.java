package practice;

public class FindTargetInSortedRotatedArray {
    public static void main(String[] args) {
        FindTargetInSortedRotatedArray ob = new FindTargetInSortedRotatedArray();
        int[] a1 = {4,5,6,7,0,1,2};
        int[] a2 = {3,1};

        System.out.println(ob.search(a1, 0));
        System.out.println(ob.search(a1, 3));
        System.out.println(ob.search(a2, 1));

    }

    public int search(int[] nums, int target) {

        int low = 0, high = nums.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] == target)
                return mid;

            // first half is sorted
            if (nums[low] <= nums[mid]) {

                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else
                    low = mid + 1;
            } else {

                // second half is sorted
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else
                    high = mid - 1;
            }
        }
        return -1;
    }
}
