/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package mock.microsoft.set3;

import java.util.ArrayList;
import java.util.List;

public class WordSearchInDictionary212 {
    public static void main(String[] args) {
//        char[][] board = {
//                {'o','a','a','n'},
//                {'e','t','a','e'},
//                {'i','h','k','r'},
//                {'i','f','l','v'}
//        };

//        String[] words = new String[4];
//        words[0]="oath";
//        words[1]="pea";
//        words[2]="eat";
//        words[3]="rain";

        char[][] board = {{'a','b'},{'c','d'}};

        String[] words = {"ab","cb","ad","bd","ac","ca","da","bc","db","adcb","dabc","abb","acb"};


        WordSearchInDictionary212 ob = new WordSearchInDictionary212();
        List<String> selectedWord = ob.findWords(board, words);
        System.out.println(selectedWord);


    }

    public List<String> findWords(char[][] board, String[] words) {

        if (words == null || words.length == 0 || board.length == 0 || board[0].length == 0)
            return new ArrayList<>();

        List<String> result = new ArrayList<>();

        boolean[][] isVisisted = new boolean[board.length][board[0].length];


        for (String s : words) {

            char c = s.charAt(0);

            for (int i = 0; i < board.length; i++) {

                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == c) {

                        char[] ct = new char[s.length()];
                        if (dfs(board, s, 0, ct, isVisisted, i, j, result)) {
                            result.add(s);
                        }
                    }
                }
            }
        }

        return result;
    }

    private boolean dfs(char[][] board, String input, int index, char[] ct, boolean[][] isVisisted,
                        int row, int col, List<String> result) {

        if (index >= input.length() || !isSafe(row, col, board, isVisisted))
            return false;

        if (board[row][col] != input.charAt(index))
            return false;

        ct[index] = board[row][col];
        isVisisted[row][col] = true;

        if (index == input.length() - 1) {

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <= index; i++) {
                sb.append(ct[i]);
            }

            if (!result.contains(sb.toString())) {
                isVisisted[row][col] = false;
                return true;
            }
        }

        boolean r = dfs(board, input, index + 1, ct, isVisisted, row - 1, col, result) ||
                dfs(board, input, index + 1, ct, isVisisted, row + 1, col, result) ||
                dfs(board, input, index + 1, ct, isVisisted, row, col - 1, result) ||
                dfs(board, input, index + 1, ct, isVisisted, row, col + 1, result);

        isVisisted[row][col] = false;
        return r;

    }

    private boolean isSafe(int row, int col, char[][] board, boolean[][] isVisisted) {

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || isVisisted[row][col])
            return false;

        return true;
    }


}
