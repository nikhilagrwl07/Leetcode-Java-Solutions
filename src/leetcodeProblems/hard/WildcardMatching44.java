package leetcodeProblems.hard;

public class WildcardMatching44 {
    public static void main(String[] args) {
        WildcardMatching44 ob = new WildcardMatching44();
        String s1 = "aa", p1 = "a";
        String s2 = "aa", p2 = "*";
        String s3 = "cb", p3 = "?a";
        String s4 = "adceb", p4 = "*a*b";
        String s5 = "acdcb", p5 = "a*c?b";
        String s6 = "a", p6 = "aa";
        String s7 = "abefcdgiescdfimde", p7 = "ab*cd?i*de";
        String s8 = "", p8 = "*";
        String s9 = "leetcode", p9 = "*e*t?d*";

        System.out.println(ob.isMatch(s1, p1));
        System.out.println(ob.isMatch(s2, p2));
        System.out.println(ob.isMatch(s3, p3));
        System.out.println(ob.isMatch(s4, p4));
        System.out.println(ob.isMatch(s5, p5));
        System.out.println(ob.isMatch(s6, p6));
        System.out.println(ob.isMatch(s7, p7));
        System.out.println(ob.isMatch(s8, p8));
        System.out.println(ob.isMatch(s9, p9));

    }

    private boolean isMatch(String text, String pattern) {
        boolean[][] match = new boolean[text.length() + 1][pattern.length() + 1];
        match[0][0] = true;

        //filling matrix with empty text
        for (int p = 0; p < pattern.length(); p++) {
            if (pattern.charAt(p) == '*') {
                match[0][p + 1] = match[0][p];
            }
        }

        //filling matrix with empty pattern
        for (int t = 0; t < text.length(); t++) {
            if (text.charAt(t) == '*') {
                match[t + 1][0] = match[t][0];
            }
        }

        for (int t = 0; t < text.length(); t++) {
            for (int p = 0; p < pattern.length(); p++) {

                //Case #1
                if (text.charAt(t) == pattern.charAt(p) || pattern.charAt(p) == '?') {
                    match[t + 1][p + 1] = match[t - 1 + 1][p - 1 + 1];
                }
                //Case #2
                else if (text.charAt(t) == pattern.charAt(p) || pattern.charAt(p) == '*') {
                    match[t + 1][p + 1] = match[t + 1][p - 1 + 1] || match[t - 1 + 1][p + 1];
                }
                //Case #3
                else {
                    match[t + 1][p + 1] = false;
                }
            }
        }
        return match[match.length - 1][match[0].length - 1];
    }
}
