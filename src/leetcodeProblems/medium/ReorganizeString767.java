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

    public String reorganizeString(String S) {
        Map<Character, Integer> freq = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        Queue<Character> maxHeap = new PriorityQueue<>((c1, c2) -> freq.get(c2) - freq.get(c1));
        for (Map.Entry<Character, Integer> e : freq.entrySet()) {
            maxHeap.offer(e.getKey());
        }

        while (maxHeap.size() >= 2) {
            char first = maxHeap.poll();
            char second = maxHeap.poll();

            int firstFreq = freq.get(first);
            int secondFreq = freq.get(second);
            if (firstFreq > 1) {
                freq.put(first, freq.get(first) - 1);
                maxHeap.offer(first);
            }
            if (secondFreq > 1) {
                freq.put(second, freq.get(second) - 1);
                maxHeap.offer(second);
            }

            sb.append(first);
            sb.append(second);
        }

        if (maxHeap.size() == 1) {
            char t = maxHeap.poll();
            int f = freq.get(t);

            if (f > 1) {
                return "";
            } else {
                sb.append(t);
            }
        }
        return sb.toString();
    }
}
