package leetcodeProblems.medium;

import java.util.PriorityQueue;
import java.util.Queue;

public class LongestRepeatingKReplacedString424 {
    public static void main(String[] args) {

        LongestRepeatingKReplacedString424 ob = new LongestRepeatingKReplacedString424();
        String s1 = "ABAB";
        int k1 = 2;

        String s2 = "AABABBA";
        int k2 = 1;


        String s3 = "AAAAAAA";
        int k3 = 0;


        String s4 = "BAAA";
        int k4 = 0;

        String s5 = "ABCDE";
        int k5 = 1;

        System.out.println(ob.characterReplacement(s1, k1));
        System.out.println(ob.characterReplacement(s2, k2));
        System.out.println(ob.characterReplacement(s3, k3));
        System.out.println(ob.characterReplacement(s4, k4));
        System.out.println(ob.characterReplacement(s5, k5));

    }


    public int characterReplacement(String str, int k) {

        if (str == null || str.isEmpty())
            return 0;

        int[] freq = new int[26];
        Queue<Character> minHeap = new PriorityQueue<>((o1, o2) -> {
            return freq[o1 - 'A'] - freq[o2 - 'A'];
        });

        int s = 0, e = 0, maxLength = 0;

        while (e < str.length()) {

            char c = str.charAt(e);
            freq[c - 'A']++;

            if (freq[c - 'A'] > 1) {
                minHeap.remove(c);
            }

            minHeap.offer(c);

            // balance by moving s to right
            //breach type - #1
            //breach type - #2
            while (s < e && ((minHeap.size() >= 2 && freq[minHeap.peek() - 'A'] > k) || (minHeap.size() >= 3))) {
                minHeap.remove(str.charAt(s));

                freq[str.charAt(s) - 'A']--;
                if (freq[str.charAt(s) - 'A'] > 0)
                    minHeap.offer(str.charAt(s));

                s++;
            }
//            System.out.println("s = " + s + " e = " + e);
            maxLength = Math.max(maxLength, e - s + 1);
            e++;
        }

        return maxLength;

    }
}
