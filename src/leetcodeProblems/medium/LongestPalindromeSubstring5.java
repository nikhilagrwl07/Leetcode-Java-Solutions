package leetcodeProblems.medium;

public class LongestPalindromeSubstring5 {
    public static void main(String[] args) {
        LongestPalindromeSubstring5 ob = new LongestPalindromeSubstring5();

        String s1 = "babad";
        String s2 = "cbbd";
        String s3 = "aaabaaaa";

        System.out.println(ob.longestPalindrome(s1));
        System.out.println(ob.longestPalindrome(s2));
        System.out.println(ob.longestPalindrome(s3));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty())
            return s;

        String[] result = new String[1];
        result[0] = "";

        for (int i = 0; i < s.length(); i++) {
            dfs(i, i, s, result);
            dfs(i, i + 1, s, result);
        }

        return result[0];
    }

    private void dfs(int i, int j, String s, String[] result) {

        if (i < 0 || j >= s.length())
            return;


        if (s.charAt(i) != s.charAt(j))
            return;

        if (result[0].length() < j - i + 1) {
            result[0] = s.substring(i, j + 1);
        }

        dfs(i - 1, j + 1, s, result);
    }
}
