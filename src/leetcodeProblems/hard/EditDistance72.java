package leetcodeProblems.hard;

public class EditDistance72 {
    public static void main(String[] args) {
        EditDistance72 ob = new EditDistance72();
        String word1 = "horse", word2 = "ros";
        String word3 = "intention", word4 = "execution";
        String word5 = "abs", word6 = "";
        String word7 = "pneumonoultramicroscopicsilicovolcanoconiosis", word8 = "ultramicroscopically";
        String word9 = "a", word10 = "ab";
        System.out.println(ob.minDistance(word1, word2));
        System.out.println(ob.minDistance(word3, word4));
        System.out.println(ob.minDistance(word5, word6));
        System.out.println(ob.minDistance(word7, word8));
        System.out.println(ob.minDistance(word9, word10));
    }

    // Time - O(N * M)
    // Space - O(N * M)
    public int minDistance(String word1, String word2) {
        int l1 = (word1 == null || word1.length() == 0) ? 0 : word1.length();
        int l2 = (word2 == null || word2.length() == 0) ? 0 : word2.length();

        if (l1 * l2 == 0)
            return l1 + l2;

        int[][] t = new int[l1 + 1][l2 + 1];
        char w1;
        char w2;

        for (int i = 0; i <= l1; i++) {
            t[i][0] = i;
        }
        for (int j = 0; j <= l2; j++) {
            t[0][j] = j;
        }

        for (int i = 1; i <= l1; i++) {
            w1 = word1.charAt(i - 1);
            for (int j = 1; j <= l2; j++) {
                w2 = word2.charAt(j - 1);

                if (w1 == w2) {
                    t[i][j] = t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.min(t[i - 1][j - 1], Math.min(t[i - 1][j], t[i][j - 1])) + 1;
                }
            }
        }
        return t[l1][l2];
    }
}
