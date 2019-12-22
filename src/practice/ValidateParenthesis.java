package practice;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ValidateParenthesis {
    public static void main(String[] args) {
        ValidateParenthesis ob = new ValidateParenthesis();
//        boolean isValid = ob.isValid("()[]{}");
        boolean isValid = ob.isValid("([)]");
        System.out.println(isValid);

    }

    public boolean isValid(String s) {
        if (s == null || s.isEmpty())
            return true;

        List<Character> opening = Arrays.asList('{', '(', '[');
        List<Character> closing = Arrays.asList('}', ')', ']');

        Stack<Character> stack = new Stack<>();
        int index = 0;

        if (closing.contains(s.charAt(index)))
            return false;

        stack.push(s.charAt(index++));

        while (index < s.length()) {

            if (opening.contains(s.charAt(index))) {
                stack.push(s.charAt(index++));
                continue;
            }

            if (stack.isEmpty())
                return false;

            char topElement = stack.pop();

            if (topElement == '{' && s.charAt(index) != '}')
                return false;

            if (topElement == '[' && s.charAt(index) != ']')
                return false;

            if (topElement == '(' && s.charAt(index) != ')')
                return false;

            index++;
        }
        return stack.isEmpty();
    }
}
