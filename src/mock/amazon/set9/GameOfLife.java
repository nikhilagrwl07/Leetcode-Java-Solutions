package mock.amazon.set9;

public class GameOfLife {
    public static void main(String[] args) {

        GameOfLife ob = new GameOfLife();
//        ob.gameOfLife();

    }

    public void gameOfLife(int[][] board) {

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                int countOfLiveCell = countLiveCells(row, col, board);

                if (board[row][col] == 1 && (countOfLiveCell < 2 || countOfLiveCell > 3)) {
                    board[row][col] = -1;
                } else if (board[row][col] == 0 && (countOfLiveCell == 3)) {
                    board[row][col] = 2;
                }
            }
        }
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == -1) {
                    board[row][col] = 0;
                } else if (board[row][col] == 2) {
                    board[row][col] = 1;
                }
            }
        }

    }

    private int countLiveCells(int row, int col, int[][] board) {

        int count = 0;
        if (row - 1 >= 0 && (board[row - 1][col] == 1 || board[row - 1][col] == -1)) {
            count++;
        }

        if (row + 1 <= board.length - 1 && (board[row + 1][col] == 1 || board[row + 1][col] == -1)) {
            count++;
        }

        if (col - 1 >= 0 && (board[row][col - 1] == 1 || board[row][col - 1] == -1)) {
            count++;
        }

        if (col + 1 <= board[0].length - 1 && (board[row][col + 1] == 1 || board[row][col + 1] == -1)) {
            count++;
        }

        // diagonal
        if (row - 1 >= 0 && col - 1 >= 0 && (board[row - 1][col - 1] == 1 || board[row - 1][col - 1] == -1)) {
            count++;
        }

        if (row - 1 >= 0 && col + 1 <= board[0].length - 1 && (board[row - 1][col + 1] == 1 || board[row - 1][col + 1] == -1)) {
            count++;
        }

        if (row + 1 <= board.length - 1 && col - 1 >= 0 && (board[row + 1][col - 1] == 1 || board[row + 1][col - 1] == -1)) {
            count++;
        }

        if (row + 1 <= board.length - 1 && col + 1 <= board[0].length - 1 && (board[row + 1][col + 1] == 1 || board[row + 1][col + 1] == -1)) {
            count++;
        }


        return count;
    }
}
