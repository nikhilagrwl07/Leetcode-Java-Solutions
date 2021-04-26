package practice;

public class CheckTwoStringsAreSame {
    public static void main(String[] args) {
        CheckTwoStringsAreSame ob = new CheckTwoStringsAreSame();
//        System.out.println(ob.solution("A2Le", "2pL1"));
//        System.out.println(ob.solution("a10", "10a"));
//        System.out.println(ob.solution("ba1", "1Ad"));
//        System.out.println(ob.solution("3x2x", "8"));
//        System.out.println(ob.solution("10a1", "10A1"));
//        System.out.println(ob.solution("2abc1", "1abc1"));
        System.out.println(ob.solution("2A", "1A1"));
//        System.out.println(ob.solution("2", "3"));
    }

    public boolean solution(String S, String T) {
        StringBuilder s = expandString(S);
        StringBuilder t = expandString(T);

        if (s.length() != t.length()) return false;

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (sChar == '*' || tChar == '*') {
                continue;
            } else if (sChar != tChar) {
                return false;
            }
        }
        return true;
    }

    public StringBuilder expandString(String str){
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (Character.isDigit(c)) {
                int count = (int) c - '0';
                while (count > 0) {
                    s.append("*");
                    count--;
                }
            } else {
                s.append(c);
            }
        }
        return s;
    }
}
