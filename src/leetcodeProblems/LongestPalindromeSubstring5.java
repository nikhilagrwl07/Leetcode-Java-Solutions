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
//        String input = "cbbd";
//        String input = "";


        String output = longestPalindrome(input);
        String outputAroundCenterApproach = longestPalindromeAroundCentreApproach(input);
        System.out.println(output);
        System.out.println(outputAroundCenterApproach);
    }


    private static String longestPalindromeAroundCentreApproach(String s) {
        if (s == null || s.isEmpty())
            return "";

        if (s.length() == 1) {
            return s;
        }

        char[] c = s.toCharArray();
        String longestPalindromeSubstring = String.valueOf(c[0]);

        // ODD Case

        for (int i = 1; i <= c.length - 1; i++) {
            int left = i - 1, right = i + 1;
            while (isSafe(left, c) && isSafe(right, c) && c[left] == c[right]) {
                String ss = s.substring(left, right + 1);
                if (ss.length() > longestPalindromeSubstring.length()) {
                    longestPalindromeSubstring = ss;
                }
                left--;
                right++;
            }

        }

        // EVEN Case
        for (int i = 1; i <= c.length - 1; i++) {
            int centerLeft = i-1, centerRight = i;

            if(isSafe(centerLeft, c) && isSafe(centerRight, c) && c[centerLeft] == c[centerRight]){

                if (centerRight-centerLeft+1 > longestPalindromeSubstring.length()) {
                    longestPalindromeSubstring = s.substring(centerLeft, centerRight+1);;
                }


                int left = centerLeft - 1, right = centerRight + 1;
                while (isSafe(left, c) && isSafe(right, c) && c[left] == c[right]) {
                    String ss = s.substring(left, right + 1);
                    if (ss.length() > longestPalindromeSubstring.length()) {
                        longestPalindromeSubstring = ss;
                    }
                    left--;
                    right++;
                }
            }
        }
        return longestPalindromeSubstring;
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
