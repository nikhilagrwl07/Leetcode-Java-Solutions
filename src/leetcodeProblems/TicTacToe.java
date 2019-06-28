package leetcodeProblems;/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


public class TicTacToe {


    public static void main(String[] args) {
        int n = 3;

        TicTacToe obj = new TicTacToe(n);
        int param_1 = obj.move(0, 0, 1);
        System.out.println(param_1);

        param_1 = obj.move(1, 1, 1);
        System.out.println(param_1);

        param_1 = obj.move(2, 2, 2);
        System.out.println(param_1);

        param_1 = obj.move(2, 0, 2);
        System.out.println(param_1);

        param_1 = obj.move(2, 1, 2);
        System.out.println(param_1);

    }

    int[][] board;

    /**
     * Initialize your data structure here.
     */
    public TicTacToe(int n) {
        board = new int[n][n];
    }

    /**
     * Player {player} makes a move at ({row}, {col}).
     *
     * @param row    The row of the board.
     * @param col    The column of the board.
     * @param player The player, can be either 1 or 2.
     * @return The current winning condition, can be either:
     * 0: No one wins.
     * 1: Player 1 wins.
     * 2: Player 2 wins.
     */
    public int move(int row, int col, int player) {

        board[row][col] = player;

        boolean horizontal = checkHorizontal(row, col, player);

        boolean vertical = checkvertical(row, col, player);


        boolean diagonalToRight = diagonalToRight(row, col, player);
        boolean diagonalToleft = diagonalToleft(row, col, player);


        if (horizontal || vertical || diagonalToleft || diagonalToRight) {
            return player;
        }

        return 0;

    }

    private boolean diagonalToleft(int row, int col, int player) {
        int r = 0, c = 0;

        while (c <= board.length - 1 && r <= board.length - 1) {
            if (board[r][c] != player) {
                return false;
            }
            r++;
            c++;
        }

        return true;
    }

    private boolean diagonalToRight(int row, int col, int player) {

        int r = 0, c = board.length - 1;

        while (r <= board.length - 1 && c >= 0) {
            if (board[r][c] != player) {
                return false;
            }
            r++;
            c--;
        }

        return true;
    }

    private boolean checkvertical(int row, int col, int player) {

        for (int i = 0; i < board[0].length; i++) {
            if (board[i][col] != player)
                return false;
        }

        return true;
    }

    private boolean checkHorizontal(int row, int col, int player) {

        for (int i = 0; i < board.length; i++) {
            if (board[row][i] != player)
                return false;
        }
        return true;
    }


}
