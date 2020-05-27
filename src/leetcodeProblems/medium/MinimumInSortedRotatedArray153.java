package leetcodeProblems.medium;

public class MinimumInSortedRotatedArray153 {
    public static void main(String[] args) {
        MinimumInSortedRotatedArray153 ob = new MinimumInSortedRotatedArray153();
        int[] a1 = {3, 4, 5, 1, 2};
        int[] a2 = {4, 5, 6, 7, 0, 1, 2};
        int[] a3 = {0, 1, 2};
        int[] a4 = {1, 2, 0};
        int[] a5 = {1};
        int[] a6 = {2, 1};
        int[] a7 = {2, 3, 4, 5, 1};

//        int minElement1 = ob.findMin(a1);
//        int minElement2 = ob.findMin(a2);
//        int minElement3 = ob.findMin(a3);
//        int minElement4 = ob.findMin(a4);
//        int minElement5 = ob.findMin(a5);
//        int minElement6 = ob.findMin(a6);
//        int minElement7 = ob.findMin(a7);

        int minElement1 = ob.findMinIterative(a1);
        int minElement2 = ob.findMinIterative(a2);
        int minElement3 = ob.findMinIterative(a3);
        int minElement4 = ob.findMinIterative(a4);
        int minElement5 = ob.findMinIterative(a5);
        int minElement6 = ob.findMinIterative(a6);
        int minElement7 = ob.findMinIterative(a7);


        System.out.println(minElement1);
        System.out.println(minElement2);
        System.out.println(minElement3);
        System.out.println(minElement4);
        System.out.println(minElement5);
        System.out.println(minElement6);
        System.out.println(minElement7);
    }


    public int findMin(int[] nums) {
        return findMinUtil(nums, 0, nums.length - 1);
    }

    private int findMinUtil(int[] nums, int low, int high) {
        if (low > high)
            return -1;

        if (low == high)
            return nums[low];

        // one element OR unrotated
        if (nums[low] < nums[high])
            return nums[low];

        int mid = low + (high - low) / 2;

        // two OR more element
        if (nums[mid] > nums[mid + 1])
            return nums[mid + 1];

        // two OR more element
        if (nums[mid - 1] > nums[mid])
            return nums[mid];

        if (nums[mid] > nums[high]) {
            return findMinUtil(nums, mid + 1, high);
        } else {
            return findMinUtil(nums, low, mid - 1);
        }
    }

    public int findMinIterative(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high])
                low = mid + 1;
            else
                high = mid;
        }
        return nums[low];
    }
}
