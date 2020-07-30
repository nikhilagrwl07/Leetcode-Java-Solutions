package leetcodeProblems.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class ReorganizeString767 {
    public static void main(String[] args) {

        ReorganizeString767 ob = new ReorganizeString767();
        String input1 = "caaab"; // 5/2 = 2 -->
        String input2 = "aaab"; // 6/2 = 3 -->

        System.out.println(ob.reorganizeString(input1));
        System.out.println(ob.reorganizeString(input2));
    }

    // Time complexity - O(Count of distinct character in input string S * length of input string S)
    public String reorganizeString(String s) {

        if (s == null || s.isEmpty())
            return "";

        Map<Character, Integer> freq = new HashMap<>();
        Queue<Character> maxHeap = new PriorityQueue<>((c1, c2) -> {
            return freq.get(c2) - freq.get(c1);
        });
        for (int i = 0; i < s.length(); i++) {

            if (freq.get(s.charAt(i)) != null) {
                maxHeap.remove(s.charAt(i));
            }

            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);


            if ((s.length() % 2 == 0 && freq.get(s.charAt(i)) > s.length() / 2) ||
                    (s.length() % 2 != 0 && freq.get(s.charAt(i)) > (s.length() / 2) + 1)) {
                return "";
            }


            maxHeap.offer(s.charAt(i));
        }


        int startIndex = 0;
        char[] result = new char[s.length()];

        char tmp = maxHeap.poll();
        int ft = freq.get(tmp);
        result[startIndex] = tmp;

        if (freq.get(tmp) > 1) {
            freq.put(tmp, freq.get(tmp) - 1);
            maxHeap.offer(tmp);
        } else {
            freq.remove(tmp);
        }


        while (!maxHeap.isEmpty()) {
            char c = maxHeap.poll();
            int f = freq.get(c);
            if (result[startIndex] == c) {

                if (!maxHeap.isEmpty()) {
                    char second = maxHeap.poll();

                    if (freq.get(second) > 1) {
                        freq.put(second, freq.get(second) - 1);
                        maxHeap.offer(second);
                    } else {
                        freq.remove(second);
                    }
                    startIndex++;
                    result[startIndex] = second;

                    maxHeap.offer(c);
                } else {
                    return "";
                }

            } else {
                startIndex++;
                result[startIndex] = c;

                if (f == 1) {
                    freq.remove(c);
                } else {
                    freq.put(c, freq.get(c) - 1);
                    maxHeap.offer(c);
                }
            }
        }

        return new String(result);
    }
}
