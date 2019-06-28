/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 *//*



public class SnakesAndLaddersGame {
    public static void main(String[] args) {
        int[][] layout = {
                {-1, -1, -1, -1, -1, -1}, //0
                {-1, -1, -1, -1, -1, -1}, // 1  L --> R
                {-1, -1, -1, -1, -1, -1}, // 2
                {-1, 35, -1, -1, 13, -1}, // 3  L --> R
                {-1, -1, -1, -1, -1, -1},  // 4
                {-1, 15, -1, -1, -1, -1}};  // 5  L --> R

//        int[][] layout =   {{-1,-1},{-1,3}};

        SnakesAndLaddersGame game = new SnakesAndLaddersGame();
        int minimumNumberOfStepsRequiredToReachDestination = game.snakesAndLadders(layout);
        System.out.println(minimumNumberOfStepsRequiredToReachDestination);
    }

    private int minStepsCount = Integer.MAX_VALUE;

    private int snakesAndLadders(int[][] board) {

        int[][] ground = intializeGround(board);
        int startRow = board.length - 1, startColumn = 0;
        boolean[][] isVisited = new boolean[board.length][board[0].length];

        dfs(board, ground, startRow, startColumn, 0, isVisited);

        if (minStepsCount == Integer.MAX_VALUE) {
            return -1;
        }

        return minStepsCount;
    }


    private void dfs(int[][] board, int[][] ground, int row, int column, int stepsCount, boolean[][] isVisited) {

        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length || isVisited[row][column]) {
            return;
        }

        System.out.println(row + " : "+ column);

        if (row == 0 && column == 0) {

//            stepsCount--;

            if (minStepsCount > stepsCount) {
                minStepsCount = stepsCount;
            }
            return;
        }

        isVisited[row][column] = true;

        if (board[row][column] > 0) {
            int[] currentLocation = move(board, ground, row, column, -1, board[row][column]);
            row = currentLocation[0];
            column = currentLocation[1];

            dfs(board, ground, row, column, stepsCount, isVisited);
        }

        int[] currentLocation;
        for (int i = 1; i <= 6; i++) {
            // moving i steps
            int tmpRow = row;
            int tmpColumn = column;

            if (board[tmpRow][tmpColumn] > 0) {
                currentLocation = move(board, ground, tmpRow, tmpColumn, 0, board[tmpRow][tmpColumn]);
            } else {
                currentLocation = move(board, ground, tmpRow, tmpColumn, i, 0);
            }

            tmpRow = currentLocation[0];
            tmpColumn = currentLocation[1];

            if (tmpRow >= 0 && tmpRow <= board.length - 1
                    && tmpColumn >= 0 && tmpColumn <= board[0].length - 1 && !isVisited[tmpRow][tmpColumn]) {

                dfs(board, ground, tmpRow, tmpColumn, stepsCount + 1, isVisited);
//                isVisited[tmpRow][tmpColumn] = false;
            }

        }
    }

    // default move is 1
    // if more than 1 length move is required , use new location
    private int[] move(int[][] board, int[][] ground, int row, int column, int length, int newLocation) {

        int[] result = new int[2];

        if (row == 0 && column == 0) {
            result[0] = row;
            result[1] = column;
            return result;
        }

        // Higher priority to new location
        if (newLocation > 0) {
            return lookup(ground, newLocation);
        }


        if (row % 2 > 0) { // odd case --> left to right

            column = column + length;

            int remaininglength = column - (ground.length - 1); // 5;

            if (remaininglength > 0) {
                row = row - 1;
                column = ground.length - remaininglength;
            }

        } else {
            column = column - length;

            if (column < 0) {
                column = column * (-1);
                column = column - 1;
                row = row - 1;
            }
        }

        result[0] = row;
        result[1] = column;
        return result;
    }


    private int[][] intializeGround(int[][] layout) {

        boolean leftToRight = true;
        int N = layout.length;
        int[][] ground = new int[N][N];
        int counter = 1;

        for (int i = N-1; i >= 0; i--) {

            if (leftToRight) {
                for (int j = 0; j < N; j++) {
                    ground[i][j] = counter++;
                }
            } else {
                for (int j = N - 1; j >= 0; j--) {
                    ground[i][j] = counter++;
                }
            }
            leftToRight = !leftToRight;
        }
        return ground;
    }


    private int[] lookup(int[][] ground, int location) {

        int[] result = new int[2];
        for (int i = 0; i <= ground.length - 1; i++) {

            for (int j = 0; j < ground[0].length - 1; j++) {
                if (ground[i][j] == location) {

                    result[0] = i;
                    result[1] = j;
                }
            }
        }

        return result;
    }
}
*/
