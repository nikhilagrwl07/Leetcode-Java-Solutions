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

        List<String> result = new ArrayList<>();
        Map<Character, String> map = new HashMap<>(8);
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        char[] currentList = new char[digits.length()];
        dfs(digits.toCharArray(), 0, currentList, result, map);
        return result;
    }

    private void dfs(char[] digits, int indexOfDigit, char[] currentList,
                     List<String> result, Map<Character, String> lookup) {

        if (indexOfDigit >= digits.length) {
            return;
        }

        String mapping = lookup.get(digits[indexOfDigit]);

        for (int i = 0; i < mapping.length(); i++) {
            currentList[indexOfDigit] = mapping.charAt(i);

            if (indexOfDigit == digits.length - 1) {
                result.add(new String(currentList));
            } else {
                dfs(digits, indexOfDigit + 1, currentList, result, lookup);
            }
        }
    }
}
