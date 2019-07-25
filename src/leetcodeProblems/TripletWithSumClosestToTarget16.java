package leetcodeProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletWithSumClosestToTarget16 {
    public static void main(String[] args) {

        TripletWithSumClosestToTarget16 ob = new TripletWithSumClosestToTarget16();

//        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        int tripletSum = ob.threeSumClosest(nums, target);
        System.out.println(tripletSum);
    }

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums); // sorting

        List<Integer> triplets = new ArrayList<>();

        int closestSum = Integer.MAX_VALUE;
        for (int i = 0; i + 2 < nums.length; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) // skipping the same result
                continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) { // exploring all option of left and right pair for given i

                int currentSum = nums[i] + nums[left] + nums[right];

                if (Math.abs(target - currentSum) < closestSum) {

                    triplets = Arrays.asList(nums[i], nums[left], nums[right]);
                    closestSum = Math.abs(target - currentSum);
                }

                if (target == currentSum) {
                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (right > left && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (target > currentSum) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        int sum = 0;
        for (int i : triplets) sum += i;
        return sum;
    }
}
