/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package mock.amazon.set4;

public class MissingElementInSortedArray1060 {
    public static void main(String[] args) {

        int[] a = {1,2,4};
        int k = 3;

        int missingElement = missingElement(a, k);
        System.out.println(missingElement);
    }

    public static int missingElement(int[] nums, int k) {

        int leftmost = nums[0];

        int index = 1;
        while (k > 0 && index <= nums.length - 1) {

            if (leftmost + 1 == nums[index]) {
                index++;
            } else {
                k--;
            }
            leftmost++;
        }

        if (k == 0) {
            return leftmost;
        }

        if (index > nums.length - 1) {

            while (k > 0) {
                leftmost++;
                k--;
            }
        }

        return leftmost;
    }
}
