/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


public class KMP {
    public static void main(String[] args) {
//        String txt = "ABABDABACDABABCABAB";
//        String pat = "ABABCABAB";

        String txt = "AABAACAADAABAABA";
        String pat = "AABA";

//        String txt = "AAAAABAAABA";
//        String pat = "AAAA";

        search(txt, pat);

    }

    private static void search(String txt, String pat) {
        if (txt == null || pat == null || txt.isEmpty() || pat.isEmpty())
            return;

        int[] lps = computeLPS(pat);

        char[] text = txt.toCharArray();
        char[] pattern = pat.toCharArray();

        int patIndex = 0;
        int textIndex = 0;

        while (textIndex < text.length) {

            if (pattern[patIndex] == text[textIndex]) {
                patIndex++;
                textIndex++;
            }
            else {
                if (patIndex != 0) {
                    patIndex = lps[patIndex - 1];
                } else {
                    textIndex++;
                }
            }

            if (patIndex == pattern.length) {
                System.out.println("Pattern Matched at index - " + (textIndex - pat.length()));
                patIndex = lps[patIndex - 1];
            }


            if (textIndex == text.length)
                break;
        }

    }

    private static int[] computeLPS(String pat) {

        if (pat == null || pat.isEmpty())
            return null;


        int[] lps = new int[pat.length()];
        lps[0] = 0;
        int i = 1;
        int len = 0;

        char[] p = pat.toCharArray();

        while (i < pat.length()) {

            if (p[i] == p[len]) {
                len++;
                lps[i] = len;
                i++;
            } else {

                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}
