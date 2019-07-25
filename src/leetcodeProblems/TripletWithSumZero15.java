package leetcodeProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletWithSumZero15 {
    public static void main(String[] args) {

        TripletWithSumZero15 ob = new TripletWithSumZero15();

//        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
        List<List<Integer>> triplets = ob.threeSum(nums);
        System.out.println(triplets);
    }

    public List<List<Integer>> threeSum(int[] nums) {

        if (nums == null || nums.length <= 2) {
            return new ArrayList<>();
        }

        Arrays.sort(nums); // sorting

        List<List<Integer>> triplets = new ArrayList<>();


        int topSum = 0;
        for (int i = 0; i + 2 < nums.length; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) // skipping the same result
                continue;

            int remainingSum = topSum - nums[i];

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) { // exploring all option of left and right pair for given i
                if (nums[left] + nums[right] == remainingSum) {

                    triplets.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (right > left && nums[right] == nums[right + 1]) {
                        right--;
                    }

                } else if (nums[left] + nums[right] < remainingSum) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return triplets;
    }

//    public List<List<Integer>> threeSum(int[] nums) {
//
//        if (nums == null || nums.length <= 2) {
//            return new ArrayList<>();
//        }
//
//        Arrays.sort(nums); // sorting
//
//        Map<Integer, List<List<Integer>>> firstToTripletMapping = new HashMap<>();
//
//        int topSum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            int remainingSum = topSum - nums[i];
//
//            int left = i + 1;
//            int right = nums.length - 1;
//
//            while (left < right) {
//                if (nums[left] + nums[right] == remainingSum) {
//
//                    if (firstToTripletMapping.get(nums[i]) != null) {
//
//                        List<List<Integer>> lasttriplet = firstToTripletMapping.get(nums[i]);
//
//                        boolean doesExist = false;
//                        for (List<Integer> pair : lasttriplet) {
//                            if (pair.get(0) == nums[left] && pair.get(1) == nums[right]) {
//                                doesExist = true;
//                                break;
//                            }
//                        }
//                        if (!doesExist) {
//                            List<Integer> found = new ArrayList<>();
//                            found.add(nums[left]);
//                            found.add(nums[right]);
//                            lasttriplet.add(found);
//                            firstToTripletMapping.put(nums[i], lasttriplet);
//                        }
//
//                    } else {
//                        List<Integer> found = new ArrayList<>();
//                        found.add(nums[left]);
//                        found.add(nums[right]);
//                        List list = new ArrayList<>();
//                        list.add(found);
//                        firstToTripletMapping.put(nums[i], list);
//
//                    }
//
//                    left++;
//                    right--;
//
//                } else if (nums[left] + nums[right] < remainingSum) {
//                    left++;
//                } else {
//                    right--;
//                }
//            }
//
//        }
//
//
//        List<List<Integer>> triplets = new ArrayList<>();
//        for (Map.Entry<Integer, List<List<Integer>>> entry : firstToTripletMapping.entrySet()) {
//
//            Integer first = entry.getKey();
//            List<List<Integer>> combination = entry.getValue();
//
//            for (List<Integer> c : combination) {
//                List<Integer> element = new ArrayList<>();
//                element.add(first);
//                element.addAll(c);
//                triplets.add(element);
//            }
//        }
//        return triplets;
//    }
}
