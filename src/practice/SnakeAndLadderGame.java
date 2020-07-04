package practice;

import java.util.LinkedList;
import java.util.Queue;

public class SnakeAndLadderGame {
    public static void main(String[] args) {
        SnakeAndLadderGame ob = new SnakeAndLadderGame();

        int[][] layout = {
                {-1, -1, -1, -1, -1, -1}, //0
                {-1, -1, -1, -1, -1, -1}, // 1  L --> R
                {-1, -1, -1, -1, -1, -1}, // 2
                {-1, 35, -1, -1, 13, -1}, // 3  L --> R
                {-1, -1, -1, -1, -1, -1},  // 4
                {-1, 15, -1, -1, -1, -1}};  // 5  L --> R

        int[][] layout2 = {
                {-1, -1, -1, -1, 48, 5, -1},
                {12, 29, 13, 9, -1, 2, 32},
                {-1, -1, 21, 7, -1, 12, 49},
                {42, 37, 21, 40, -1, 22, 12},
                {42, -1, 2, -1, -1, -1, 6},
                {39, -1, 35, -1, -1, 39, -1},
                {-1, 36, -1, -1, -1, -1, 5}
        };
        int[][] layout3 = {
                {-1, -1, -1, 46, 47, -1, -1, -1},
                {51, -1, -1, 63, -1, 31, 21, -1},
                {-1, -1, 26, -1, -1, 38, -1, -1},
                {-1, -1, 11, -1, 14, 23, 56, 57},
                {11, -1, -1, -1, 49, 36, -1, 48},
                {-1, -1, -1, 33, 56, -1, 57, 21},
                {-1, -1, -1, -1, -1, -1, 2, -1},
                {-1, -1, -1, 8, 3, -1, 6, 56}};

        int[][] layout4 = {{-1, -1, 128, -1, -1, -1, 136, -1, -1, -1, 109, -1}, {-1, -1, -1, -1, -1, 103, -1, -1, 56, 10, -1, -1}, {-1, -1, -1, -1, -1, -1, 116, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1, -1, -1, 50, -1, 67, 107}, {-1, 40, -1, -1, -1, 20, -1, 59, -1, 67, -1, -1}, {-1, -1, -1, -1, -1, -1, 112, 133, 111, -1, -1, -1}, {-1, -1, 112, -1, 74, -1, -1, -1, -1, -1, -1, -1}, {23, -1, 115, -1, 129, 126, -1, -1, -1, -1, -1, -1}, {106, 143, 81, -1, -1, -1, -1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1, -1, -1, 26, 102, 1, 29}, {26, -1, -1, -1, -1, -1, -1, -1, 27, -1, -1, -1}, {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}};

        System.out.println(ob.snakesAndLadders(layout));
//        System.out.println(ob.snakesAndLadders(layout2));
//        System.out.println(ob.snakesAndLadders(layout3));
//        System.out.println(ob.snakesAndLadders(layout4));
    }

    public int snakesAndLadders(int[][] board) {

        int rStart = board.length - 1;
        int cStart = 0;
        Queue<int[]> q = new LinkedList<>();
        int step = 0;
        q.offer(new int[]{rStart, cStart});

        //even --> L to R
        //odd --> R to L
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 1; i <= size; i++) {
                int[] currentIndex = q.poll();
                int row = currentIndex[0];
                int col = currentIndex[1];

                // reached destination
                if (row == 0 && col == board.length - 1)
                    return step;

                // resolve location
                if (board[row][col] != -1) {
                    int newVal = board[row][col];
                    if (newVal > findValueFromIndexes(row, col, board.length))
                    {
                        row = findRow(newVal, board.length);
                        col = findCol(newVal, board.length);
                    }
                }
                int val = findValueFromIndexes(row, col, board.length);

                for (int jump = 1; jump <= 6; jump++) {
                    int newVal = val + jump;
                    row = findRow(newVal, board.length);
                    col = findCol(newVal, board.length);
                    q.offer(new int[]{row, col});
                }
            }
            step++;
        }
        return -1;

    }

    public int findRow(int value, int N) {
        if (value % N == 0) {
            return (N) - (value / N);
        } else {
            return (N - 1) - (value / N);
        }
    }

    public int findCol(int value, int N) {

        int colNumber;

        int rowNumber = findRow(value, N);

        if (value % N == 0)
            colNumber = N - 1;
        else
            colNumber = (value % N) - 1;

//        colNumber = N-colNumber;

        // row number --> even --> L To R
        if (rowNumber % 2 == 0) {
            return N - colNumber - 1;
        } else {
            return colNumber;
        }
    }

    public int findValueFromIndexes(int x, int y, int N) {
        int startRow = N - x - 1;
        int startValue = N * (startRow) + 1;

        if (x % 2 == 0)
            return startValue + y+1;
        else
            return startValue + (N - y);
    }
}
