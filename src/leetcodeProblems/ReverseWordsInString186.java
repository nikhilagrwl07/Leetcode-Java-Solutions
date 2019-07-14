/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package leetcodeProblems;

import java.util.LinkedList;
import java.util.List;

public class ReverseWordsInString186 {
    public static void main(String[] args) {

        ReverseWordsInString186 ob = new ReverseWordsInString186();
//        char[] c = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        char[] c = {'t', 'h', 'e', ' ', 's', 'k', 'y'};
        System.out.println(c);
        ob.reverseWords(c);
        System.out.println(c);
    }

    public void reverseWords(char[] s) {

        List<String> ans = new LinkedList<>();

        int last = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                ans.add(collect(s, last, i - 1));
                last = i + 1;
            }

            if (i == s.length - 1) {
                ans.add(collect(s, last, i));
                last = i + 1;
            }
        }

        int index = 0;
        for (int i = ans.size() - 1; i >= 0; i--) {
            String s1 = ans.get(i);
            for (Character c : s1.toCharArray()) {
                s[index++] = c;
            }
            if (index <= s.length - 1) {
                s[index++] = ' ';
            }
        }
    }

    private String collect(char[] s, int last, int i) {
        StringBuilder sb = new StringBuilder();
        for (int j = last; j <= i; j++) {
            sb.append(s[j]);
        }
        return sb.toString();
    }

}
