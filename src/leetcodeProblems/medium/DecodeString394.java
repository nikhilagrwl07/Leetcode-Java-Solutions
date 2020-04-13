package leetcodeProblems.medium;

import java.util.Stack;

public class DecodeString394 {
    public static void main(String[] args) {
        DecodeString394 ob = new DecodeString394();
//        String s = "3[a]2[bc]";
//        String s = "3[a2[c]]";
//        String s = "";
//        String s = "100[leetcode]";
        String s = "2[abc]3[cd]ef";
        String decodedString = ob.decodeString(s);
        System.out.println(decodedString);
    }

    //    s = "3[a]2[bc]", return "aaabcbc".
    //    s = "3[a2[c]]", return "accaccacc".
    public String decodeString(String s) {
        if (s.isEmpty())
            return s;

        StringBuilder result = new StringBuilder();
        Stack<Object> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ']') {
                st.push(s.charAt(i));
            } else {
                StringBuilder tmp = new StringBuilder();
                while (!st.isEmpty() && (char) st.peek() != '[') {
                    tmp.insert(0, st.pop());
                }
                st.pop(); // to remove '['

                StringBuilder sbOftimes = new StringBuilder();
                while (!st.isEmpty() && Character.isDigit((char) st.peek())) {
                    sbOftimes.insert(0, st.pop());
                }
                int times = Integer.parseInt(sbOftimes.toString());

                while (times > 0) {
                    for (int j = 0; j < tmp.length(); j++) {
                        st.push(tmp.charAt(j));
                    }
                    times--;
                }
            }
        }

        while (!st.isEmpty()) {
            result.insert(0, st.pop());
        }

        return result.toString();
    }

}
