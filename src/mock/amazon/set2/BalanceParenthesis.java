package mock.amazon.set2;/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


import java.util.Stack;

public class BalanceParenthesis {
    public static void main(String[] args) {
        BalanceParenthesis ob = new BalanceParenthesis();
        String input = "()[]{}";
        boolean valid = ob.isValid(input);
        System.out.println(valid);
    }

    public boolean isValid(String s) {
        if (s == null || s.isEmpty())
            return true;

        if (s.length() % 2 > 0) {
            return false;
        }

        Stack<Character> st = new Stack<>();


        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                st.push(s.charAt(i));
            } else {
                if(st.isEmpty()){
                    return false;
                }
                char popped = st.pop();

                if(c == ')' && popped != '(')
                    return false;

                if(c == '}' && popped != '{')
                    return false;

                if(c == ']' && popped != '[')
                    return false;

            }
        }

        if(!st.isEmpty())
            return false;

        return true;
    }
}
