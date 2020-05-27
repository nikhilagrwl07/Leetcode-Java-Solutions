package leetcodeProblems.hard;

public class EditDistance72 {
    public static void main(String[] args) {
        EditDistance72 ob = new EditDistance72();
//        String word1 = "horse", word2 = "ros";
//        String word1 = "intention", word2 = "execution";
//        String word1 = "abs", word2 = "";
        String word1 = "pneumonoultramicroscopicsilicovolcanoconiosis",
                word2 = "ultramicroscopically";

        int minDistance = ob.minDistance(word1, word2);
        System.out.println(minDistance);
    }

    public int minDistance(String word1, String word2) {

        if (word1 == null || word1.isEmpty()) {
            return word2.length();
        }

        if (word2 == null || word2.isEmpty()) {
            return word1.length();
        }

        int[][] d = new int[word1.length() + 1][word2.length() + 1];

        if (word1.charAt(0) != word2.charAt(0))
            d[0][0] = 0;

        // filling first row
        for (int c = 0; c < word2.length(); c++) {
            d[0][c + 1] = d[0][c - 1 + 1] + 1;
        }

        // filling first column
        for (int r = 0; r < word1.length(); r++) {
            d[r + 1][0] = d[r - 1 + 1][0] + 1;
        }


        for (int r = 1; r < word1.length(); r++) {
            for (int c = 1; c < word2.length(); c++) {
                if (word1.charAt(r) == word2.charAt(c)) {
                    d[r + 1][c + 1] = d[r - 1 + 1][c - 1 + 1];
                } else {
                    d[r + 1][c + 1] = Math.min(d[r - 1 + 1][c - 1 + 1],
                            Math.min(d[r + 1][c - 1 + 1], d[r - 1 + 1][c + 1])) + 1;
                }
            }
        }
        return d[d.length - 1][d[0].length - 1];
    }
}
