package leetcodeProblems;/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostCommonWordInParagraph {
    public static void main(String[] args) {
//        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
//        String[] banned = {"hit"};

        String paragraph = "a, a, a, a, b,   b ,b,c, c";
        String[] banned = {"a"};
        String mostCommonWord = mostCommonWord(paragraph, banned);
        System.out.println(mostCommonWord);

    }


    public static String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> m = new HashMap<>();
        List<String> bannedList = Arrays.asList(banned);

        String[] p = paragraph.toLowerCase().split("[ !?',;.]+");
        String highestFrequencyWord = "";
        int highestFreq = 0;
        for (String s1 : p) {

            if (!bannedList.contains(s1)) {

                if (m.containsKey(s1)) {
                    m.put(s1, m.get(s1) + 1);
                } else {
                    m.put(s1, 1);
                }


                if (m.get(s1) > highestFreq) {
                    highestFreq = m.get(s1);
                    highestFrequencyWord = s1;
                }
            }
        }

        return highestFrequencyWord;
    }
}
