package leetcodeProblems.hard;

import java.util.*;

public class RearrangeStringKDistanceApart358 {
    public static void main(String[] args) {
        String s1 = "aabbcc";
        int k1 = 3;
        String s2 = "aaabc";
        int k2 = 3;
        String s3 = "aaadbbcc";
        int k3 = 2;
        String s4 = "abb";
        int k4 = 2;

        String s5 = "aabbccdd";
        int k5 = 3;

        System.out.println(rearrangeString(s1, k1));
        System.out.println(rearrangeString(s2, k2));
        System.out.println(rearrangeString(s3, k3));
        System.out.println(rearrangeString(s4, k4));
        System.out.println(rearrangeString(s5, k5));
    }

    public static String rearrangeString(String s, int k) {
        if (k == 0) return s;

        Map<Character, Integer> freq = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        Queue<Character> maxHeap = new PriorityQueue<>((c1, c2) -> {
            int fredDiff = freq.get(c2) - freq.get(c1);
            if (fredDiff != 0) return fredDiff;
            return c1 - c2;
        });

        for (Map.Entry<Character, Integer> e : freq.entrySet()) {
            char c = e.getKey();
            int f = e.getValue();
            maxHeap.offer(c);
        }

        StringBuilder sb = new StringBuilder(s.length());
        while (maxHeap.size() >= k) {
            int tmp = k;

            List<Character> tmpList = new ArrayList<>();

            while (tmp > 0) {
                char c = maxHeap.poll();
                if (freq.get(c) - 1 > 0) {
                    tmpList.add(c);
                    freq.put(c, freq.get(c) - 1);
                } else {
                    freq.remove(c);
                }

                sb.append(c);
                tmp--;
            }

            for (Character c : tmpList) {
                maxHeap.offer(c);
            }
        }

        while (!maxHeap.isEmpty()) {
            Character poll = maxHeap.poll();
            int f = freq.get(poll);
            if (f > 1)
                return "";
            else {
                sb.append(poll);
                freq.remove(poll);
            }
        }
        return sb.toString();
    }
}
