package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationOfString {
    public static void main(String[] args) {
        PermutationOfString ob = new PermutationOfString();
//        String input = "ABC";
        String input = "AAC";
        List<String> permutation = ob.permutation(input);
        System.out.println(permutation);
    }

    public List<String> permutation(String input) {

        List<String> result = new ArrayList<>();
        if (input == null || input.isEmpty())
            return result;

        if (input.length() == 1) {
            result.add(input);
            return result;
        }

        char[] cs = input.toCharArray();
        int indexOfReplace = 0;

        for (int candidate = 0; candidate < cs.length; candidate++) {
            permutation(cs, indexOfReplace, candidate, result);
        }

        return result;
    }

    private void permutation(char[] cs, int indexOfReplace, int candidate, List<String> result) {

        if (indexOfReplace == cs.length - 1) {
            String s = Arrays.toString(cs);
            if(!result.contains(s))
            {
                result.add(Arrays.toString(cs));
            }

            return;
        }

        swap(cs, indexOfReplace, candidate);

        for (int j = indexOfReplace + 1; j <= cs.length - 1; j++) {

            permutation(cs, indexOfReplace+1, j, result);
        }

        swap(cs, indexOfReplace, candidate);
    }

    private void swap(char[] cs, int indexOfReplace, int candidate) {
        char tmp = cs[indexOfReplace];
        cs[indexOfReplace] = cs[candidate];
        cs[candidate]= tmp;
    }
}
