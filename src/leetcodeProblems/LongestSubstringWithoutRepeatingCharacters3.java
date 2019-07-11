/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


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
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty())
            return 0;

        if (s.length() == 1)
            return 1;


        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int maxLength = Integer.MIN_VALUE;

        while (end <= s.length() - 1) {

            if (map.containsKey(s.charAt(end)) && map.get(s.charAt(end)) >= start) {
                //update start and end
                int lastIndex = map.get(s.charAt(end));
                start = lastIndex + 1;
            }

            map.put(s.charAt(end), end);
            maxLength = Math.max(maxLength, end - start + 1);
            end++;
        }
        return maxLength;
    }
}
