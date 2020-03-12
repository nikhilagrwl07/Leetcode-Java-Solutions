package leetcodeProblems.easy;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges994 {
    public static void main(String[] args) {

        RottingOranges994 ob = new RottingOranges994();
//        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
//        int[][] grid = {{0, 2}};
//        int[][] grid = {{0}};
//        int[][] grid = {{1}};
//        int[][] grid = {{2}};
        int[][] grid = {{0, 1}, {2, 0}};

        int timeTaken = ob.orangesRotting(grid);
        System.out.println(timeTaken);

    }


    //    the value 0 representing an empty cell;
//    the value 1 representing a fresh orange;
//    the value 2 representing a rotten orange.
    public int orangesRotting(int[][] grid) {

        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        int timeElapsed = 0;
        boolean gridContainsRottenOranges = false;
        boolean gridContainsFreshOranges = false;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 2) {
                    q.offer(new Pair<>(r, c));
                    gridContainsRottenOranges = true;
                } else if (grid[r][c] == 1) {
                    gridContainsFreshOranges = true;
                }
            }
        }


        if (!gridContainsFreshOranges) {
            return 0;
        }

        if (!gridContainsRottenOranges) {
            return -1;
        }

        int[][] neighbours = {
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0},
        };

        while (!q.isEmpty()) {

            int size = q.size();
            boolean actionPerformed = false;
            for (int i = 0; i < size; i++) {
                Pair<Integer, Integer> polledNode = q.poll();
                int x = polledNode.getKey();
                int y = polledNode.getValue();

                for (int[] neighbour : neighbours) {
                    int nr = neighbour[0] + x;
                    int nc = neighbour[1] + y;

                    if (nr >= 0 && nr <= grid.length - 1 &&
                            nc >= 0 && nc <= grid[0].length - 1
                            && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        q.offer(new Pair<>(nr, nc));
                        actionPerformed = true;
                    }
                }
            }
            if (actionPerformed)
                timeElapsed++;
        }

        if (timeElapsed == 0) {
            return -1;
        }


        for (int[] ints : grid) {
            for (int c = 0; c < grid[0].length; c++) {
                if (ints[c] == 1) {
                    return -1;
                }
            }
        }

        return timeElapsed;
    }
}
