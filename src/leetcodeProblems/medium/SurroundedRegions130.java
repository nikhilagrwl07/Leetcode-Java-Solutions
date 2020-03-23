package leetcodeProblems.medium;

import java.util.Arrays;

public class SurroundedRegions130 {
    public static void main(String[] args) {
        SurroundedRegions130 ob = new SurroundedRegions130();
        char[][] board = {
                {'X', 'X', 'X', 'O'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };

//        char[][] board = {
//                {'O', 'X', 'X', 'O', 'X'},
//                {'X', 'O', 'O', 'X', 'O'},
//                {'X', 'O', 'X', 'O', 'X'},
//                {'O', 'X', 'O', 'O', 'O'},
//                {'X', 'X', 'O', 'X', 'O'}};

//        char[][] board = {
//                {'X', 'O', 'X'},
//                {'X', 'O', 'X'},
//                {'X', 'O', 'X'},
//        };

//        char[][] board = {
//                {'X', 'X', 'X'},
//                {'X', 'O', 'X'},
//                {'X', 'X', 'X'},
//        };

        System.out.println(Arrays.deepToString(board));
        ob.solve(board);
        System.out.println(Arrays.deepToString(board));
    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0)
            return;

        preProcessBoard(board);

        for (int r = 1; r <= board.length - 2; r++) {
            for (int c = 1; c <= board[0].length - 2; c++) {
                if (board[r][c] == 'O') {
                    dfs(r, c, board);
                }
            }
        }

        postProcessBoard(board);
    }

    private void postProcessBoard(char[][] board) {

        for (int r = 0; r <= board.length - 1; r++) {
            for (int c = 0; c <= board[0].length - 1; c++) {
                if (board[r][c]== 'F'){
                    board[r][c]='O';
                }
            }
        }
    }

    private void preProcessBoard(char[][] board) {

        for (int r = 0; r <= board.length - 1; r++) {
            for (int c = 0; c <= board[0].length - 1; c++) {
                if ((r == 0 || r == board.length - 1 || c == 0 || c == board[0].length - 1)
                        && board[r][c]=='O') {
                    dfsMarkNA(board, r, c);
                }
            }
        }
    }

    private void dfsMarkNA(char[][] board, int r, int c) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c]!= 'O')
            return;

        board[r][c]='F';

        dfsMarkNA(board, r-1, c);
        dfsMarkNA(board, r+1, c);
        dfsMarkNA(board, r, c-1);
        dfsMarkNA(board, r, c+1);
    }

    private void dfs(int r, int c, char[][] board) {
        if (r <= 0 || r >= board.length - 1 || c <= 0 || c >= board[0].length - 1
                || board[r][c] == 'X' || board[r][c]=='F')
            return;

        if ((r - 1 == 0 && board[r - 1][c] == 'O')
                || (r + 1 == board.length - 1 && board[r + 1][c] == 'O')
                || (c - 1 == 0 && board[r][c - 1] == 'O')
                || (c + 1 == board[0].length - 1 && board[r][c + 1] == 'O'))
            return;


        if ((r - 1 >= 0 && board[r - 1][c] == 'X') ||
                (r + 1 <= board.length - 1 && board[r + 1][c] == 'X') ||
                (c - 1 >= 0 && board[r][c - 1] == 'X') ||
                (c + 1 <= board[0].length - 1 && board[r][c + 1] == 'X')) {
            board[r][c] = 'X';
        } else {
            return;
        }

        dfs(r - 1, c, board);
        dfs(r + 1, c, board);
        dfs(r, c - 1, board);
        dfs(r, c + 1, board);
    }
}
