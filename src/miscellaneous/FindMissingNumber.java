/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package miscellaneous;

public class FindMissingNumber {
    public static void main(String[] args) {

        FindMissingNumber ob = new FindMissingNumber();

//        int[] a = {3, 0, 1};
        int[] a = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        int missingNumber = ob.missingNumber(a);
        System.out.println(missingNumber);
    }


    public int missingNumber(int[] nums) {

        int max = nums.length;
        int xorResult = 0;
        int xorCal = 0;

        for (int i = 1; i <= max; i++) {
            xorResult = xorResult ^ i;
            xorCal = xorCal ^ nums[i - 1];
        }

        return xorResult ^ xorCal;


    }
}
