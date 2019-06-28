package leetcodeProblems;/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLaddersGameBFS {
    public static void main(String[] args) {

        int[][] layout = {
                {-1, -1, -1, -1, -1, -1}, //0
                {-1, -1, -1, -1, -1, -1}, // 1  L --> R
                {-1, -1, -1, -1, -1, -1}, // 2
                {-1, 35, -1, -1, 13, -1}, // 3  L --> R
                {-1, -1, -1, -1, -1, -1},  // 4
                {-1, 15, -1, -1, -1, -1}};  // 5  L --> R

//        int[][] layout =   {{-1,-1},{-1,3}};
//        int[][] layout = {
//                {-1, 7, -1},
//                {-1, 6, 9},
//                {-1, -1, 2}};

//        int[][] layout = {
//                {-1, -1, -1, 46, 47, -1, -1, -1},
//                {51, -1, -1, 63, -1, 31, 21, -1},
//                {-1, -1, 26, -1, -1, 38, -1, -1},
//                {-1, -1, 11, -1, 14, 23, 56, 57},
//                {11, -1, -1, -1, 49, 36, -1, 48},
//                {-1, -1, -1, 33, 56, -1, 57, 21},
//                {-1, -1, -1, -1, -1, -1, 2, -1},
//                {-1, -1, -1, 8, 3, -1, 6, 56}}; // 8*8 = 64

        SnakesAndLaddersGameBFS game = new SnakesAndLaddersGameBFS();
        int minimumNumberOfStepsRequiredToReachDestination = game.snakesAndLadders(layout);
        System.out.println(minimumNumberOfStepsRequiredToReachDestination);
    }


    private int snakesAndLadders(int[][] board) {

        int[][] ground = intializeGround(board);
        int length = board.length;

        boolean[] isVisited = new boolean[length * length];

        Location location = new Location(0, 0);
        Queue<Location> q = new LinkedList<>();
        q.add(location);
        isVisited[0] = true;

        while (!q.isEmpty()) {

            Location l = q.remove();

            if (l.vertex == (length-1) * (length-1)) {
                return l.steps;
            }

            for (int i = 1; i <= 6; i++) {

                int newVertex = l.vertex + i;
//                System.out.println(newVertex);

                if (newVertex <= ((length-1) * (length-1)) && !isVisited[newVertex]) { // newVertex is unvisited
                    int[] points = lookup(ground, newVertex+1);

                    isVisited[newVertex] = true;

                    if (board[points[0]][points[1]] > -1) {
                        newVertex = board[points[0]][points[1]];
                    }
//                    System.out.println(newVertex);
                    Location l1 = new Location(newVertex, l.steps + 1);
                    q.add(l1);
                    isVisited[newVertex] = true;
                }
            }
        }

        return -1;
    }


    private int[][] intializeGround(int[][] layout) {

        boolean leftToRight = true;
        int N = layout.length;
        int[][] ground = new int[N][N];
        int counter = 1;

        for (int i = N - 1; i >= 0; i--) {

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

            for (int j = 0; j <= ground[0].length - 1; j++) {
                if (ground[i][j] == location) {

                    result[0] = i;
                    result[1] = j;
                }
            }
        }

        return result;
    }

    static class Location {
        int vertex;
        int steps;

        public Location(int vertex, int steps) {
            this.vertex = vertex;
            this.steps = steps;
        }
    }
}
