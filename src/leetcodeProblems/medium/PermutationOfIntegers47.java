package leetcodeProblems.medium;

import java.util.ArrayList;
import java.util.List;

public class PermutationOfIntegers47 {
    public static void main(String[] args) {
        PermutationOfIntegers47 ob = new PermutationOfIntegers47();
//        int[] a = {1, 2, 3};
        int[] a = {1, 2, 2};
//        int[] a = {1};
        List<List<Integer>> permute = ob.permute(a);
        System.out.println(permute);


    }

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();

        if (nums.length == 1) {
            List<Integer> r = new ArrayList<>();
            r.add(nums[0]);
            result.add(r);
            return result;
        }

        for (int candidate = 0; candidate < nums.length; candidate++) {
            permutation(nums, 0, candidate, result);
        }

        return result;
    }

    private void permutation(int[] nums, int indexOfReplace, int candidate, List<List<Integer>> result) {

        if (indexOfReplace == nums.length - 1) {
            List<Integer> r = new ArrayList<>();
            for (int i : nums) {
                r.add(i);
            }
            if(!result.contains(r)){
                result.add(r);
            }
            return;
        }

        swap(nums, indexOfReplace, candidate);
        for (int j = indexOfReplace + 1; j <= nums.length - 1; j++) {
            permutation(nums, indexOfReplace + 1, j, result);
        }

        swap(nums, indexOfReplace, candidate);
    }

    private void swap(int[] nums, int indexOfReplace, int candidate) {
        int tmp = nums[indexOfReplace];
        nums[indexOfReplace] = nums[candidate];
        nums[candidate] = tmp;
    }

}
