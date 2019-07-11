package miscellaneous;/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


import java.util.*;
import java.util.stream.Collectors;

public class ListOfMostCommonWordInParagraph {
    public static void main(String[] args) {
//        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
//        String[] banned = {"hit"};

        String paragraph = "Jack and Jill went to the market to buy bread and cheese. Cheese is Jack's and Jill's favorite food.";
        String[] banned = {"and", "he", "the", "to", "is", "Jack", "Jill"};
        List<String> mostCommonWord = mostCommonWord(paragraph, banned);
        System.out.println(mostCommonWord);

    }


    public static List<String> mostCommonWord(String paragraph, String[] banned) {
        List<String> bannedList = Arrays.stream(banned).map(String::toLowerCase).collect(Collectors.toList());

        String[] p = paragraph.toLowerCase().split("[ !?',;.]+");


        List<String> highestFrequencyWordList = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        int highestFreq = Integer.MIN_VALUE;
        for (String s1 : p) {

            if (!bannedList.contains(s1)) {

                Integer freq = map.getOrDefault(s1, 0);
                map.put(s1, freq + 1);
                if (freq + 1 > highestFreq) {
                    highestFreq = freq + 1;
                }
            }
        }

        for (Map.Entry<String, Integer> es : map.entrySet()) {
            if (es.getValue() == highestFreq) {
                highestFrequencyWordList.add(es.getKey());
            }
        }

        return highestFrequencyWordList;
    }
}
