package mock.amazon;/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


public class FindUniqueElement {
    public static void main(String[] args) {

//        int[] a = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        int[] a = {3,3,7,7,10,11,11};
        FindUniqueElement ob = new FindUniqueElement();
        int singleNonDuplicate = ob.singleNonDuplicate(a);
        System.out.println(singleNonDuplicate);
    }

    public int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;

        if(nums.length==1){
            return nums[0];
        }

        return binarySearch(nums, 0, nums.length - 1);

    }

    public int binarySearch(int[] nums, int low, int high) {

        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;


        if (mid == 0 && nums[mid] != nums[mid + 1]) {
            return nums[mid];
        }

        if (mid == nums.length - 1 && nums[mid] != nums[mid - 1]) {
            return nums[mid];
        }

        if (mid > 0 && nums[mid] != nums[mid - 1] &&
                mid < nums.length - 1 && nums[mid] != nums[mid + 1])
            return nums[mid];

        int left = binarySearch(nums, low, mid - 1);

        if (left == -1) {
            return binarySearch(nums, mid + 1, high);
        } else
            return left;

    }
}
