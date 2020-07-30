package leetcodeProblems.medium;

import java.util.ArrayList;
import java.util.List;

public class PermutationsOfArray46 {
    public static void main(String[] args) {
        PermutationsOfArray46 ob = new PermutationsOfArray46();
        int[] a1 = {1,2,3};
        System.out.println(ob.permute(a1));

    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int index = 0;
        backtrack(nums, index, result);
        return result;
    }

    private void backtrack(int[] nums, int index, List<List<Integer>> result) {
        if (index == nums.length - 1) {
            List<Integer> tmpList = new ArrayList<>();
            for (int t : nums) {
                tmpList.add(t);
            }
            result.add(tmpList);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            backtrack(nums, index + 1, result);
            swap(nums, i, index);
        }

    }

    private void swap(int[] nums, int i, int index) {
        int t = nums[i];
        nums[i] = nums[index];
        nums[index] = t;
    }
}
