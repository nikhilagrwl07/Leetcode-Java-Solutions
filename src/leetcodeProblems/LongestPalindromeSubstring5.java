package leetcodeProblems;
/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


public class LongestPalindromeSubstring5 {
    public static void main(String[] args) {
        String input = "babad";
//        String input = "babababa";
//        String input = "cbbd";
//        String input = "";


        String output = longestPalindrome(input);
        String outputAroundCenterApproach = longestPalindromeAroundCentreApproach(input);
        System.out.println(output);
        System.out.println(outputAroundCenterApproach);
    }

    //Time Complexity - O(N^2)
    //Space Complexity - O(1)
    private static String longestPalindromeAroundCentreApproach(String s) {
        if (s == null || s.isEmpty())
            return "";

        if (s.length() == 1) {
            return s;
        }

        char[] c = s.toCharArray();
        Integer lowerIndex = null;
        Integer upperIndex = null;


        for (int i = 1; i <= c.length - 1; i++) {

            // ODD Case
            int left = i - 1, right = i + 1;
            while (isSafe(left, c) && isSafe(right, c) && c[left] == c[right]) {

                if (lowerIndex == null || (right - left + 1 > upperIndex - lowerIndex + 1)) {
                    lowerIndex = left;
                    upperIndex = right;
                }
                left--;
                right++;
            }


            // EVEN Case
            left = i - 1;
            right = i;

            if (isSafe(left, c) && isSafe(right, c) && c[left] == c[right]) {

                if (lowerIndex == null || (right - left + 1 > upperIndex - lowerIndex + 1)) {
                    lowerIndex = left;
                    upperIndex = right;
                }


                left = left - 1;
                right = right + 1;
                while (isSafe(left, c) && isSafe(right, c) && c[left] == c[right]) {

                    if (right - left + 1 > upperIndex - lowerIndex + 1) {
                        lowerIndex = left;
                        upperIndex = right;
                    }
                    left--;
                    right++;
                }
            }

        }

        if (lowerIndex == null) {
            return s.substring(0, 1);
        }

        return s.substring(lowerIndex, upperIndex + 1);
    }

    private static boolean isSafe(int i, char[] c) {
        return i >= 0 && i < c.length;
    }


    //Time Complexity - O(N^2)
    //Space Complexity - O(N^2)
    private static String longestPalindrome(String s) {
        if (s == null || s.isEmpty())
            return "";

        if (s.length() == 1) {
            return s;
        }

        char[] c = s.toCharArray();
        boolean[][] m = new boolean[c.length][c.length];

        // substring of length 1
        for (int i = 0; i < c.length; i++) {
            m[i][i] = true;
        }

        String longestPalindromeSubString = s.substring(0, 1);

        // substring of length 2
        for (int i = 0; i < c.length; i++) {
            int row = i;
            int col = i + 1;
            if (col < c.length && c[row] == c[col]) {
                m[row][col] = true;

                if (longestPalindromeSubString.length() < (col - row + 1)) {
                    longestPalindromeSubString = s.substring(row, col + 1);
                }
            }
        }
        for (int length = 3; length <= c.length; length++) {

            for (int i = 0; i < c.length; i++) {
                int row = i;
                int col = row + length - 1;
                if (col < c.length && c[row] == c[col] && m[row + 1][col - 1]) {
                    m[row][col] = true;
                    if (longestPalindromeSubString.length() < (col - row + 1)) {
                        longestPalindromeSubString = s.substring(row, col + 1);
                    }
                }
            }
        }

        return longestPalindromeSubString;
    }
}
