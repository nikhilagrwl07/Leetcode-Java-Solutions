/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package mock.microsoft.set2;

import java.util.Stack;

public class SmallestSubSequenceWithAllCharacters1081 {
    public static void main(String[] args) {
        SmallestSubSequenceWithAllCharacters1081 ob = new SmallestSubSequenceWithAllCharacters1081();

//        String input = "cdadabcc";
//        String input = "abcd";
//        String input = "ecbacba";
        String input = "leetcode";
        String smallestSubsequence = ob.smallestSubsequence(input);
        System.out.println(smallestSubsequence);
    }


//    Explanation:
//    Find the index of last occurrence for each character.
//    Use a stack to keep the characters for result.
//    Loop on each character in the input string S,
//            if the current character is smaller than the last character in the stack,
//    and the last character exists in the following stream,
//    we can pop the last character to get a smaller result.

//    Time Complexity = O(N), N = Length of text
//    Space Complexity = Max(26, N), N = Length of text
    public String smallestSubsequence(String text) {

        if (text == null || text.isEmpty())
            return text;

        boolean[] seen = new boolean[26];

        int[] lastOccurrence = new int[26];

        for (int i = 0; i < text.length(); i++) {
            lastOccurrence[text.charAt(i) - 'a'] = i;
        }

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < text.length(); i++) {

            char currentChar = text.charAt(i);
            if (seen[currentChar - 'a'])
                continue;

            while (!st.isEmpty() && st.peek() > currentChar
                    && lastOccurrence[st.peek() - 'a'] > i) {
                seen[st.pop() - 'a'] = false;
            }

            st.push(currentChar);
            seen[currentChar - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();

        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}

//Source of stack solution - https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/discuss/308210/JavaPython-Stack-Solution-O(N)