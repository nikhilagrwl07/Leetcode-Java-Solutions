package leetcodeProblems;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters3 {
    public static void main(String[] args) {

        LongestSubstringWithoutRepeatingCharacters3 ob = new LongestSubstringWithoutRepeatingCharacters3();

        String input = "abcabcbb";
//        String input = "bbbbbbbb";
//        String input = "pwwkew";
        int lengthOfLongestSubstring = ob.lengthOfLongestSubstring(input);
        System.out.println(lengthOfLongestSubstring);
    }

    // Time Complexity - O(N) where N is length of input string s
    // Space Complexity - O(M) where M is length of longest substring without repeating chars
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty())
            return 0;

        int longestSubString = 0;
        int start = 0, end;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (map.get(currentChar) == null) {
                end = i;
            } else {
                int index = map.get(currentChar);
                if (index < start) {
                    end = i;
                } else {
                    end = i;
                    start = index + 1;
                }
            }
            map.put(currentChar, i);
            longestSubString = Math.max(longestSubString, end - start + 1);
        }
        return longestSubString;
    }
}
