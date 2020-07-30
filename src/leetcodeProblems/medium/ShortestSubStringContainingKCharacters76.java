package leetcodeProblems.medium;

import java.util.HashMap;
import java.util.Map;

public class ShortestSubStringContainingKCharacters76 {
    public static void main(String[] args) {
        ShortestSubStringContainingKCharacters76 ob = new ShortestSubStringContainingKCharacters76();
        String pattern1 = "ABC";
        String text1 = "ADOBECODEBANC";

        String pattern2 = "aba";
        String text2 = "bbaa";

        String pattern3 = "aa";
        String text3 = "a";

        String pattern4 = "b";
        String text4 = "a";

        String pattern5 ="abcdd";
        String text5 ="aaaaaaaaaaaabbbbbcdd";

        System.out.println(ob.minWindow(text1, pattern1));
        System.out.println(ob.minWindow(text2, pattern2));
        System.out.println(ob.minWindow(text3, pattern3));
        System.out.println(ob.minWindow(text4, pattern4));
        System.out.println(ob.minWindow(text5, pattern5));

    }

    public String minWindow(String text, String pattern) {
        Map<Character, Integer> patternFreq = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            patternFreq.put(pattern.charAt(i), patternFreq.getOrDefault(pattern.charAt(i), 0) + 1);
        }

        Map<Character, Integer> textFreq = new HashMap<>();
        int s = 0, e = 0;
        int[] answer = {-1, 0, 0};  // length, leftIndex, rightIndex
        int required = patternFreq.size();
        int formed = 0;

        while (e <= text.length() - 1) {

            if (patternFreq.containsKey(text.charAt(e))) {
                textFreq.put(text.charAt(e), textFreq.getOrDefault(text.charAt(e), 0) + 1);

                if (textFreq.get(text.charAt(e)).intValue() == patternFreq.get(text.charAt(e)).intValue())
                    formed++;
            }

            // remove char until window becomes undesirable
            while (s <= e && formed == required) {
                if (patternFreq.containsKey(text.charAt(s))) {
                    textFreq.put(text.charAt(s), textFreq.getOrDefault(text.charAt(s), 0) - 1);
                }
                if (patternFreq.containsKey(text.charAt(s)) &&
                        textFreq.get(text.charAt(s)) < patternFreq.get(text.charAt(s)))
                    formed--;

                if (answer[0] == -1 || ((answer[2] - answer[1] + 1) > (e - s + 1))) {
                    answer[0] = (e - s + 1);
                    answer[1] = s;
                    answer[2] = e;
                }
                s++;
            }
            e++;
        }
        return answer[0] == -1 ? "" : text.substring(answer[1], answer[2] + 1);
    }
}
