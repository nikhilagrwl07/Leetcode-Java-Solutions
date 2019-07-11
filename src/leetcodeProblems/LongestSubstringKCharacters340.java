/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package leetcodeProblems;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKCharacters340 {
    public static void main(String[] args) {

        String input = "eceba";
        int k = 2;

//        String input = "aabaaa";
//        int k = 1;

//        String input = "aabbbcccc";
//        int k = 1;

//        String input = "LOVELEETCODE";
//        int k = 4;

        LongestSubstringKCharacters340 ob = new LongestSubstringKCharacters340();
        int lengthOfLongestSubstringKDistinct = ob.lengthOfLongestSubstringKDistinct(input, k);
        System.out.println(lengthOfLongestSubstringKDistinct);
    }

    // Worst Case Time Complexity - O(N*k) where N is total length of input String s
    // and k is given number of distinct input characters
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k <= 0 || s == null || s.isEmpty()) {
            return 0;
        }

        int start = 0;
        int end = 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = Integer.MIN_VALUE;

        while (start <= end && end <= s.length() - 1) {

            map.put(s.charAt(end), end);

            if (map.size() > k) {

                int min = Integer.MAX_VALUE;
                char cMin = 0;

                for (Map.Entry<Character, Integer> eset : map.entrySet()) {
                    if (min > eset.getValue()) {
                        min = eset.getValue();
                        cMin = eset.getKey();
                    }
                }
                map.remove(cMin);
                start = min + 1;
                maxLength = Math.max(maxLength, end - start + 1);

            } else {
                maxLength = Math.max(maxLength, end - start + 1);
                end++;
            }
        }
        return maxLength;
    }
}

