package practice;

public class RemoveDuplicateFromSortedArray {
    public static void main(String[] args) {
        RemoveDuplicateFromSortedArray ob = new RemoveDuplicateFromSortedArray();
        int[] a1 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] a2 = {1, 1, 2};

        System.out.println(ob.removeDuplicates(a1));
        System.out.println(ob.removeDuplicates(a2));

    }


    public int removeDuplicates(int[] nums) {

        if (nums == null || nums.length == 0) return 0;

        int lastIndex = 0;
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] != nums[lastIndex]) {
                lastIndex++;
                nums[lastIndex] = nums[i];
            }
        }

        return lastIndex + 1;
    }
}
