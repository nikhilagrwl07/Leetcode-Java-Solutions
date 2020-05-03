package leetcodeProblems.medium;

import java.util.*;

public class ReorganizeString767 {
    public static void main(String[] args) {

        ReorganizeString767 ob = new ReorganizeString767();
//        String input = "caaab"; // 5/2 = 2 -->
        String input = "aaab"; // 6/2 = 3 -->

        String reorganizedString = ob.reorganizeString(input);
        System.out.println(reorganizedString);
    }

    // Time complexity - O(Count of distinct character in input string S * length of input string S)
    public String reorganizeString(String S) {
        StringBuilder result = new StringBuilder(S.length());
        int coolingperiod = 1;

        Map<Character, Integer> charToFreq = new HashMap<>(26);


        // calculating char to occurrence
        for (char c : S.toCharArray()) {
            charToFreq.put(c, charToFreq.get(c) == null ? 1 : charToFreq.get(c) + 1);
        }

        // map heap based on occurrence of char
        Queue<Character> pq = new PriorityQueue<>(26, (o1, o2) ->
                charToFreq.get(o2) - charToFreq.get(o1));

        for (Character c : charToFreq.keySet()) {

            Integer f = charToFreq.get(c);

            if ((S.length() % 2 == 0 && f > S.length()/2) ||
                    (S.length() % 2 != 0 && f > (S.length()/2)+1)) {
                return "";
            }
            pq.offer(c);
        }

        List<Character> temp = new ArrayList<>();
        while (!pq.isEmpty()) {

            temp.clear();
            int coolingtimer = 0;

            while (coolingtimer <= coolingperiod && !pq.isEmpty()) {

                if (result.length() != 0 && result.charAt(result.length() - 1) == pq.peek()) {
                    return "";
                }

                if (charToFreq.get(pq.peek()) > 1) {
                    Character polledChar = pq.poll();
                    // update result
                    result.append(polledChar);
                    // update map of freq map
                    charToFreq.put(polledChar, charToFreq.get(polledChar) - 1);
                    // update temp list
                    temp.add(polledChar);

                } else {
                    Character polledChar = pq.poll();
                    // update result
                    result.append(polledChar);
                    // update map of freq map
                    charToFreq.remove(polledChar);
                }

                coolingtimer++;
            }

            pq.addAll(temp);
        }
        return result.toString();
    }
}
