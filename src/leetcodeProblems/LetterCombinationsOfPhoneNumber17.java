package leetcodeProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber17 {
    public static void main(String[] args) {

        LetterCombinationsOfPhoneNumber17 ob = new LetterCombinationsOfPhoneNumber17();
        String keyPressSequence = "89";
        List<String> combination = ob.letterCombinations(keyPressSequence);
        System.out.println(combination);

    }

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty())
            return new ArrayList<>();

        List<String> result = new ArrayList<>();
        Map<Integer, String> dialpad = new HashMap<>(8);
        dialpad.put(2, "abc");
        dialpad.put(3, "def");
        dialpad.put(4, "ghi");
        dialpad.put(5, "jkl");
        dialpad.put(6, "mno");
        dialpad.put(7, "pqrs");
        dialpad.put(8, "tuv");
        dialpad.put(9, "wxyz");

        List<String> input = new ArrayList<>();
        char[] comb = new char[digits.length()];

        for (int i = 0; i < digits.length(); i++) {
            input.add(dialpad.get(Character.getNumericValue(digits.charAt(i))));
        }

        dfs(input, 0, comb, result);
        return result;
    }

    private void dfs(List<String> input, int index, char[] comb, List<String> result) {

        if (index > comb.length) {
            return;
        }
        if (index == comb.length) {
            result.add(new String(comb));
            return;
        }

        for (int i = 0; i < input.get(index).length(); i++) {
            comb[index] = input.get(index).charAt(i);
            dfs(input, index + 1, comb, result);
        }
    }
}
