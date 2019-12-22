package practice;

import java.util.Random;

public class FindMajorityElement {
    public static void main(String[] args) {
        FindMajorityElement ob = new FindMajorityElement();
//        int[] inputArray = {2, 2, 1, 1, 1, 2, 2};
        int[] inputArray = {6,5,5};
//        int majorityElement = ob.majorityElement(inputArray);
//        int majorityElement = ob.majorityElementDivideAndConquer(inputArray);
        int majorityElement = ob.majorityElementBoyerVoting(inputArray);
        System.out.println(majorityElement);
    }

    // Approach - Boyer Voting
    // Time - O(n)
    // Space - O(1)
    public int majorityElementBoyerVoting(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int i = 0; i < nums.length; i++) {

            if (count == 0) {
                count = 1;
                candidate = nums[i];
                continue;
            }

            count += nums[i] == candidate ? 1 : -1;
        }
        return candidate;
    }

    // Approach - Divide and Conquer
    // Time - O(n log n)
    // Space - O(log n)
    public int majorityElementDivideAndConquer(int[] nums) {
        return majorityElementDivideAndConquer(nums, 0, nums.length - 1);
    }

    private int majorityElementDivideAndConquer(int[] nums, int low, int high) {

        System.out.println("low - " + low + " high  - " + high);
        int mid = low + (high - low) / 2;

        // base case
        if (low == high) {
            return nums[low];
        }

        int left = majorityElementDivideAndConquer(nums, low, mid);
        int right = majorityElementDivideAndConquer(nums, mid + 1, high);


        if (left == right)
            return left;

        int leftCount = findOccurrenceCount(nums, low, mid, left);
        int rightCount = findOccurrenceCount(nums, low, mid + 1, right);

        return leftCount > rightCount ? left : right;
    }

    private int findOccurrenceCount(int[] nums, int low, int mid, int left) {
        int count = 0;
        for (int i = low; i <= mid; i++) {
            if (nums[i] == left) {
                count++;
            }
        }
        return count;
    }


    // Randomized Approach
    // Time - O(Infinity)
    // Space - O(1)
    public int majorityElement(int[] nums) {
        Random random = new Random();
        while (true) {
            int index = random.nextInt(nums.length);
            boolean isMajorityElement = verifyMajorityElement(nums, index);
            if (isMajorityElement) {
                return nums[index];
            }
        }
    }

    private boolean verifyMajorityElement(int[] nums, int index) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[index]) {
                count++;
            }
            if (count > nums.length / 2)
                return true;
        }
        return false;
    }


}
