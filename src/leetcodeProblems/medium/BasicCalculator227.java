package leetcodeProblems.medium;

import java.util.LinkedList;

public class BasicCalculator227 {
    public static void main(String[] args) {
        BasicCalculator227 ob = new BasicCalculator227();
        String e1 = " 3+5 / 2 ";
        String e2 = "3+2*2";
        String e3 = " 3/2 ";
        String e4 = " 62 ";
        String e5 = "1*2-3/4+5*6-7*8+9/10";
        String e6 = "0";
        String e7 = "1+2*5/3+6/4*2";
//        System.out.println(ob.calculate(e1));
//        System.out.println(ob.calculate(e2));
//        System.out.println(ob.calculate(e3));
//        System.out.println(ob.calculate(e4));
//        System.out.println(ob.calculate(e5));
//        System.out.println(ob.calculate(e6));
        System.out.println(ob.calculate(e7));
    }

    // space --> 1
    // *, /  --> 2
    // +, -  --> 3
//    public int calculate(String input) {
//        char lastSign = '+';
//        Stack<Integer> st = new Stack<>();
//        int num = 0;
//        int i = 0;
//        while (i < input.length()) {
//
//            char current = input.charAt(i);
//            if (Character.isDigit(current)) {
//                num = num * 10 + current - '0';
//            }
//
//            if ((!Character.isDigit(current) && current != ' ') || i == input.length() - 1) {
//
//                if (lastSign == '+') {
//                    st.push(num);
//                }
//
//                if (lastSign == '-') {
//                    st.push(-num);
//                }
//
//                if (lastSign == '*') {
//                    st.push(st.pop() * num);
//                }
//
//                if (lastSign == '/') {
//                    st.push(st.pop() / num);
//                }
//
//                lastSign = current;
//                num = 0;
//            }
//            i++;
//        }
//
//        int total = 0;
//        while (!st.isEmpty()) total += st.pop();
//
//        return total;
//    }


    public int calculate(String input) {
        char lastSign = '+';
        LinkedList<Integer> list = new LinkedList<>();
        int num = 0;
        int i = 0;
        while (i < input.length()) {

            char current = input.charAt(i);
            if (Character.isDigit(current)) {
                num = num * 10 + current - '0';
            }

            if ((!Character.isDigit(current) && current != ' ') || i == input.length() - 1) {

                if (lastSign == '+') {
                    list.addLast(num);
                }

                if (lastSign == '-') {
                    list.addLast(-num);
                }

                if (lastSign == '*') {
                    list.addLast(list.removeLast() * num);
                }

                if (lastSign == '/') {
                    list.addLast(list.removeLast() / num);
                }

                lastSign = current;
                num = 0;
            }
            i++;
        }

        int total = 0;
        while (!list.isEmpty()) total += list.remove();

        return total;
    }
}
