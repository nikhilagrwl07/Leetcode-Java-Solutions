/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package leetcodeProblems;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring76 {
    public static void main(String[] args) {
        MinimumWindowSubstring76 ob = new MinimumWindowSubstring76();

//        String S = "ADOBECODEBANC", T = "ABC";
//        String S = "a", T = "aaa";
        String S = "bbaa", T = "aba";
//        String S = "ADOBECODEBANC", T = "DOB";
//        String S = "ADOBECODEBANC", T = "ANC";
//        String S = "a", T = "b";
        String minWindow = ob.minWindow(S, T);
        System.out.println(minWindow);
    }

    public String minWindow(String input, String t) {

        if (input == null || input.isEmpty() ||
                t == null || t.isEmpty() || input.length() < t.length())
            return "";

        if (input.equals(t))
            return t;

        Deque < Character > q = new ArrayDeque<>();
        Map<Character, Boolean> m = new HashMap<>();
        for (char c : t.toCharArray()) {
            m.put(c, false);
        }
        int currentIndex = 0;
        int minLength;
        String result;

        // traversing till we find matching character of t in input
        while (currentIndex <= input.length() - 1) {

            if (m.containsKey(input.charAt(currentIndex))) {
                break;
            } else
                currentIndex++;
        }

        while (!isCharFound(m) && currentIndex <= input.length() - 1) {

            if (!q.isEmpty() &&
                    q.peekFirst() == input.charAt(currentIndex)) {
                q.removeFirst();

                while (!q.isEmpty() && !m.containsKey(q.peekFirst())) {
                    q.removeFirst();
                }
            }

            q.add(input.charAt(currentIndex));
            if (m.containsKey(input.charAt(currentIndex))) {
                m.put(input.charAt(currentIndex), true);
            }
            currentIndex++;
        }

        currentIndex--;

        minLength = q.size();
        result = collectFromDequeue(q);

        while (!q.isEmpty()) {


            // remove till just before second matching element
            boolean isFirstElementRevomved = false;
            while (!q.isEmpty()) {

                if (m.containsKey(q.peekFirst()) && !isFirstElementRevomved) {
                    isFirstElementRevomved = true;
                    m.put(q.peekFirst(), false);
                }

                q.removeFirst();

                if (!q.isEmpty() && m.containsKey(q.peekFirst()) && isFirstElementRevomved) {
                    break;
                }
            }

            while (!q.isEmpty() && currentIndex + 1 <= input.length() - 1 && !isCharFound(m)) {

                currentIndex++;

                if (m.containsKey(input.charAt(currentIndex))) {

                    if (input.charAt(currentIndex) == q.peekFirst()) {
                        char character = q.removeFirst();
                        m.put(character, false);

                        while (!q.isEmpty() && !m.containsKey(q.peekFirst())) {
                            q.removeFirst();
                        }
                    }

                    q.add(input.charAt(currentIndex));
                    m.put(input.charAt(currentIndex), true);
                } else {
                    q.add(input.charAt(currentIndex));

                }
            }

            if (!q.isEmpty() && isCharFound(m) && q.size() < minLength) {
                minLength = q.size();
                result = collectFromDequeue(q);
            }
        }
        return result;
    }

    private String collectFromDequeue(Deque<Character> q) {
        StringBuilder sb = new StringBuilder();
        for (Character c : q) {
            sb.append(c);
        }
        return sb.toString();
    }

    public boolean isCharFound(Map<Character, Boolean> m) {
        return !m.values().contains(Boolean.FALSE);
    }

}
