/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package leetcodeProblems;

public class WordSearchIn2DMatrix79 {
    public static void main(String[] args) {

        WordSearchIn2DMatrix79 ob = new WordSearchIn2DMatrix79();

        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
//        String word = "ABCCED";
//        String word = "ABCB";
        String word = "SEE";


        boolean exist = ob.exist(board, word);
        System.out.println(exist);
    }

    public boolean exist(char[][] board, String word) {
        if (word == null || word.isEmpty())
            return true;


        for (int row = 0; row < board.length; row++) {

            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == word.charAt(0)) {

                    if (existUtil(board, row, col, word.toCharArray(),
                            0, new boolean[board.length][board[0].length]))
                        return true;
                }
            }
        }

        return false;
    }

    // DFS
    private boolean existUtil(char[][] board, int row, int col, char[] word, int index,
                              boolean[][] isVisited) {

        if (!isSafe(board, row, col, isVisited) || index >= word.length) {
            return false;
        }


        if (board[row][col] != word[index]) {
            return false;
        }

        isVisited[row][col] = true;


        if (index == word.length - 1) {
            return true;
        }

        boolean result = existUtil(board, row, col - 1, word, index + 1, isVisited) ||
                existUtil(board, row, col + 1, word, index + 1, isVisited) ||
                existUtil(board, row - 1, col, word, index + 1, isVisited) ||
                existUtil(board, row + 1, col, word, index + 1, isVisited);

        isVisited[row][col] = false;        // very important - backtracking
        return result;

    }

    private boolean isSafe(char[][] board, int row, int col, boolean[][] isVisited) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || isVisited[row][col])
            return false;

        return true;
    }
}
