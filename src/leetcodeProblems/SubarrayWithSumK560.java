/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package leetcodeProblems;

import java.util.HashMap;
import java.util.Map;

public class SubarrayWithSumK560 {
    public static void main(String[] args) {

        SubarrayWithSumK560 ob = new SubarrayWithSumK560();

//        int a[] = {3, 4, 4};
//        int sum = 3;

//        int a[] = {28, 54, 7, -70, 22, 65, -6};
//        int sum = 100;

        int a[] = {1, 1, 2, 1, 2, 1};
        int sum = 3;

//        int a[] = {1};
//        int sum = 0;

        int subarraySum = ob.subarraySum(a, sum);
        System.out.println(subarraySum);
    }

    //Time Complexity - O(N^2)
    //Space Complexity - O(1)
//    public int subarraySum(int[] nums, int k) {
//
//        int count = 0;
//        for (int start = 0; start <= nums.length - 1; start++) {
//            int sum = 0;
//            for (int end = start; end <= nums.length - 1; end++) {
//
//                sum += nums[end];
//                if (sum == k) {
//                    count++;
//                }
//            }
//        }
//        return count;
//    }


    //Time Complexity - O(N^2)
    //Space Complexity - O(N)
//    public int subarraySum(int[] nums, int k) {
//        int[] sum = new int[nums.length + 1];
//        sum[0] = 0;
//
//
//        for (int i = 1; i <= nums.length; i++) {
//            sum[i] = sum[i - 1] + nums[i - 1];
//        }
//
//        int count = 0;
//        for (int start = 0; start <= sum.length - 1; start++) {
//
//            for (int end = start + 1; end <= sum.length - 1; end++) {
//                if (sum[end] - sum[start] == k) {
//                    count++;
//                }
//
//            }
//        }
//
//        return count;
//    }


    // Time Complexity - O(N) (Most optimized as compared to above 2 approaches)
    // Space Complexity - O(N)
    public int subarraySum(int[] nums, int k) {

        int subArrayCountWithSumK = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Key is sum; Value is number of subarray

        int cumulativeSum = 0;

        for (int i = 0; i < nums.length; i++) {

            cumulativeSum += nums[i];

            int numberOfSubArray = map.getOrDefault(cumulativeSum, 0) + 1;

            int sumRemainingAfterK = cumulativeSum - k;
            subArrayCountWithSumK += map.getOrDefault(sumRemainingAfterK, 0);

            map.put(cumulativeSum, numberOfSubArray);
        }

        return subArrayCountWithSumK;
    }
}
