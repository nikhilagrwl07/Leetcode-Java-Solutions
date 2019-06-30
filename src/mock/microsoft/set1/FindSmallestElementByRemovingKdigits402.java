/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package mock.microsoft.set1;

import java.util.Stack;

public class FindSmallestElementByRemovingKdigits402 {
    public static void main(String[] args) {
        FindSmallestElementByRemovingKdigits402 ob = new FindSmallestElementByRemovingKdigits402();
        int k = 1;
//        String input = "1432219";
        String input = "100";
//        String input = "10200";
//        String input = "1000";
//        String input = "112";

        String removeKdigits = ob.removeKdigits(input, k);
        System.out.println(removeKdigits);

    }

    public String removeKdigits(String num, int k) {

        if (num.length() == k) {
            return "0";
        }

        Stack<Character> s = new Stack<>();


        for (char c : num.toCharArray()) {

            while (!s.isEmpty() && s.peek() > c && k > 0) {
                s.pop();
                k--;
            }
            s.push(c);
        }

        while (k > 0 && !s.isEmpty()) {
            s.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();

        while (!s.isEmpty()) {
            sb.append(s.pop());
        }

        while ((sb.length() - 1) >= 0 && sb.charAt(sb.length() - 1) == '0') {
            sb.deleteCharAt(sb.length() - 1);
        }

        String result = sb.reverse().toString();
        return result.isEmpty() ? "0" : result;

    }
}
