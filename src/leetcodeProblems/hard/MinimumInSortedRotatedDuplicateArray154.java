package leetcodeProblems.hard;

public class MinimumInSortedRotatedDuplicateArray154 {
    public static void main(String[] args) {
        MinimumInSortedRotatedDuplicateArray154 ob = new MinimumInSortedRotatedDuplicateArray154();

        int[] a1 = {3, 4, 5, 1, 2};
        int[] a2 = {2, 2, 2, 0, 1};
        int[] a3 = {2, 2, 2, 0, 2, 2};

        int minElement1 = ob.findMin(a1);
        int minElement2 = ob.findMin(a2);
        int minElement3 = ob.findMin(a3);

        System.out.println(minElement1);
        System.out.println(minElement2);
        System.out.println(minElement3);
    }

    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high])
                low = mid + 1;
            else if (nums[low] > nums[mid]) // nums[mid] <=nums[high]
                high = mid;
            else                    // nums[mid] <=nums[high] && nums[low] <=nums[mid]
                high--;
        }
        return nums[low];
    }
}
