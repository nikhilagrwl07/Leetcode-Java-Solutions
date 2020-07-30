package leetcodeProblems.medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets78 {
    public static void main(String[] args) {
        Subsets78 ob = new Subsets78();
        int[] nums = {1, 2, 3};

        List<List<Integer>> subsets = ob.subsets(nums);
        System.out.println(subsets);
    }

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>();

        int[] result = new int[nums.length];
        int indexOfresult = 0, indexOfNums = 0;

        List<List<Integer>> finalResult = new ArrayList<>();
        recur(result, indexOfresult, nums, indexOfNums, finalResult);

        return finalResult;
    }


    public void recur(int[] result, int resultIndex, int[] input, int inputIndex, List<List<Integer>> finalResult) {

        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i <= resultIndex - 1; i++) {
            tmp.add(result[i]);
        }
        finalResult.add(tmp);

        for (int i = inputIndex; i < input.length; i++) {
            result[resultIndex] = input[i];

            if (i + 1 <= input.length)
                recur(result, resultIndex + 1, input, i + 1, finalResult);
        }
    }
}
