package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllPermutationOfString {
    public static void main(String[] args) {

        FindAllPermutationOfString ob = new FindAllPermutationOfString();
        String input = "ABC";

        List<String> permutations = ob.permutations(input);
        System.out.println(permutations);
    }

    public List<String> permutations(String input) {
        List<String> result = new ArrayList<>();
        permutationRecursion(input.toCharArray(), result, 0);
        return result;
    }

    public void permutationRecursion(char[] input, List<String> result, int index) {
        if (index >= input.length) {
            return;
        }

        for (int candidate = index; candidate < input.length; candidate++) {
            swap(input, index, candidate);
            result.add(Arrays.toString(input));
            permutationRecursion(input, result, candidate+1);
            swap(input, index, candidate);
        }
    }

    private void swap(char[] input, int index, int candidate) {
        char tmp = input[index];
        input[index] = input[candidate];
        input[candidate] = tmp;
    }
}
