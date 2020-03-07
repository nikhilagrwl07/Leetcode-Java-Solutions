package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllPermutationOfString {
    public static void main(String[] args) {

        FindAllPermutationOfString ob = new FindAllPermutationOfString();
        String input = "AAB";

        List<String> permutations = ob.permutations(input);
        System.out.println(permutations);
    }

    public List<String> permutations(String input) {
        List<String> result = new ArrayList<>();
        permutationRecursion(input.toCharArray(), result, 0, input.length() - 1);
        return result;
    }

    public void permutationRecursion(char[] input, List<String> result, int left, int right) {
        if (left == right) {
            String ans = String.valueOf(input);

            if(!result.contains(ans)){
                result.add(ans);
            }
            return;
        }

        for (int candidate = left; candidate <= right; candidate++) {

            swap(input, left, candidate);
            permutationRecursion(input, result, left+1, right);
            swap(input, left, candidate);
        }
    }

    private void swap(char[] input, int index, int candidate) {
        char tmp = input[index];
        input[index] = input[candidate];
        input[candidate] = tmp;
    }
}
