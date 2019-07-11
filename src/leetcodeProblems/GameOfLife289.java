/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package leetcodeProblems;

import java.util.Arrays;

public class GameOfLife289 {
    public static void main(String[] args) {

        int[][] board =
                {
                        {0, 1, 0
                        },

                        {0, 0, 1
                        },

                        {1, 1, 1
                        },

                        {0, 0, 0
                        }
                };

        GameOfLife289 ob = new GameOfLife289();

        System.out.println(Arrays.deepToString(board));
        ob.gameOfLife(board);
        System.out.println(Arrays.deepToString(board));
    }

    public void gameOfLife(int[][] board) {

        if (board == null || board.length == 0 || board[0].length == 0)
            return;


        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                int livingNieghbourCount = 0;
                // upper left
                if (row - 1 >= 0 && col - 1 >= 0 &&
                        (board[row - 1][col - 1] == -1 || board[row - 1][col - 1] == 1)) {
                    livingNieghbourCount++;
                }
                //upper
                if (row - 1 >= 0 &&
                        (board[row - 1][col] == -1 || board[row - 1][col] == 1)) {
                    livingNieghbourCount++;
                }

                // upper right
                if (row - 1 >= 0 && col + 1 <= (board[0].length - 1) &&
                        (board[row - 1][col + 1] == -1 || board[row - 1][col + 1] == 1)) {
                    livingNieghbourCount++;
                }

                // left
                if (col - 1 >= 0 &&
                        (board[row][col - 1] == -1 || board[row][col - 1] == 1)) {
                    livingNieghbourCount++;
                }

                //right
                if (col + 1 <= (board[0].length - 1) &&
                        (board[row][col + 1] == -1 || board[row][col + 1] == 1)) {
                    livingNieghbourCount++;
                }

                // down left
                if (row + 1 <= (board.length - 1) && col - 1 >= 0 && (board[row + 1][col - 1] == -1 || board[row + 1][col - 1] == 1)) {
                    livingNieghbourCount++;
                }

                // down
                if (row + 1 <= (board.length - 1) &&
                        (board[row + 1][col] == -1 || board[row + 1][col] == 1)) {
                    livingNieghbourCount++;
                }

                // down right
                if (row + 1 <= (board.length - 1) && col + 1 <= (board[0].length - 1) &&
                        (board[row + 1][col + 1] == -1 || board[row + 1][col + 1] == 1)) {
                    livingNieghbourCount++;
                }
                ruleOne(board, row, col, livingNieghbourCount);
//                ruleTwo(board, row, col, livingNieghbourCount);
                ruleThree(board, row, col, livingNieghbourCount);
                ruleFour(board, row, col, livingNieghbourCount);
            }
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {

                if (board[row][col] == -1) {
                    board[row][col] = 0;
                }

                if (board[row][col] == 2) {
                    board[row][col] = 1;
                }

            }
        }

    }

    public void ruleOne(int[][] board, int row, int col, int livingNeighbours) {

        if (livingNeighbours < 2 && board[row][col] == 1) {
            board[row][col] = -1; // means state change from 1 to 0
        }

    }

    public void ruleThree(int[][] board, int row, int col, int livingNeighbours) {

        if (livingNeighbours > 3 && board[row][col] == 1) {
            board[row][col] = -1; // means state change from 1 to 0
        }
    }


    public void ruleFour(int[][] board, int row, int col, int livingNeighbours) {

        if (livingNeighbours == 3 && board[row][col] == 0) {
            board[row][col] = 2; // means state change from 0 to 1
        }

    }

}
