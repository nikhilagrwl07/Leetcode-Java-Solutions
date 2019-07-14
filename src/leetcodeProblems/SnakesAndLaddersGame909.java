package leetcodeProblems;
/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


import java.util.*;

public class SnakesAndLaddersGame909 {
    public static void main(String[] args) {

//        int[][] layout = {
//                {-1, -1, -1, -1, -1, -1}, //0
//                {-1, -1, -1, -1, -1, -1}, // 1  L --> R
//                {-1, -1, -1, -1, -1, -1}, // 2
//                {-1, 35, -1, -1, 13, -1}, // 3  L --> R
//                {-1, -1, -1, -1, -1, -1},  // 4
//                {-1, 15, -1, -1, -1, -1}};  // 5  L --> R

//        int[][] layout = {{-1, -1, -1, 46, 47, -1, -1, -1}, {51, -1, -1, 63, -1, 31, 21, -1}, {-1, -1, 26, -1, -1, 38, -1, -1}, {-1, -1, 11, -1, 14, 23, 56, 57}, {11, -1, -1, -1, 49, 36, -1, 48}, {-1, -1, -1, 33, 56, -1, 57, 21}, {-1, -1, -1, -1, -1, -1, 2, -1}, {-1, -1, -1, 8, 3, -1, 6, 56}};
//        int[][] layout = {{-1, -1}, {-1, 3}};
//        int[][] layout = {
//                {-1, 7, -1},
//                {-1, 6, 9},
//                {-1, -1, 2}};
//        int[][] layout = {{-1, -1, 128, -1, -1, -1, 136, -1, -1, -1, 109, -1}, {-1, -1, -1, -1, -1, 103, -1, -1, 56, 10, -1, -1}, {-1, -1, -1, -1, -1, -1, 116, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1, -1, -1, 50, -1, 67, 107}, {-1, 40, -1, -1, -1, 20, -1, 59, -1, 67, -1, -1}, {-1, -1, -1, -1, -1, -1, 112, 133, 111, -1, -1, -1}, {-1, -1, 112, -1, 74, -1, -1, -1, -1, -1, -1, -1}, {23, -1, 115, -1, 129, 126, -1, -1, -1, -1, -1, -1}, {106, 143, 81, -1, -1, -1, -1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1, -1, -1, 26, 102, 1, 29}, {26, -1, -1, -1, -1, -1, -1, -1, 27, -1, -1, -1}, {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}};
        int[][] layout = {{-1, -1, -1, -1, 48, 5, -1}, {12, 29, 13, 9, -1, 2, 32}, {-1, -1, 21, 7, -1, 12, 49}, {42, 37, 21, 40, -1, 22, 12}, {42, -1, 2, -1, -1, -1, 6}, {39, -1, 35, -1, -1, 39, -1}, {-1, 36, -1, -1, -1, -1, 5}};
//        int[][] layout = {
//                {-1, -1, -1, 46, 47, -1, -1, -1},
//                {51, -1, -1, 63, -1, 31, 21, -1},
//                {-1, -1, 26, -1, -1, 38, -1, -1},
//                {-1, -1, 11, -1, 14, 23, 56, 57},
//                {11, -1, -1, -1, 49, 36, -1, 48},
//                {-1, -1, -1, 33, 56, -1, 57, 21},
//                {-1, -1, -1, -1, -1, -1, 2, -1},
//                {-1, -1, -1, 8, 3, -1, 6, 56}};

        SnakesAndLaddersGame909 game = new SnakesAndLaddersGame909();
        int minimumNumberOfStepsRequiredToReachDestination = game.snakesAndLadders(layout);
        System.out.println(minimumNumberOfStepsRequiredToReachDestination);
    }

    public int snakesAndLadders(int[][] board) {

        Map<Integer, Integer> ground = intializeGround(board);
        int length = board.length;
        Set<Integer> isVisited = new HashSet<>();

        Location location = new Location(1, 0);
        Queue<Location> q = new LinkedList<>();
        q.add(location);

        while (!q.isEmpty()) {

            Location l = q.remove();

            if (l.vertex == (length) * (length)) {
                return l.steps;
            }

            for (int throe = 1; throe <= 6; throe++) {

                int newVertex = l.vertex + throe;

                if (newVertex <= (length * length)) {
                    int row = ground.get(newVertex) / board.length;
                    int col = ground.get(newVertex) % board.length;

                    if (board[row][col] > -1) {
                        newVertex = board[row][col];
                    }
                    if (!isVisited.contains(newVertex)) {
                        Location l1 = new Location(newVertex, l.steps + 1);
                        q.add(l1);
                        isVisited.add(newVertex);
                    }
                }
            }
        }
        return -1;

    }


    private Map<Integer, Integer> intializeGround(int[][] layout) {

        boolean leftToRight = true;
        int N = layout.length;
        int counter = 1;

        Map<Integer, Integer> ground = new HashMap<>();

        for (int row = N - 1; row >= 0; row--) {

            if (leftToRight) {
                for (int col = 0; col < N; col++) {
                    ground.put(counter++, (row * layout.length) + col); // encoding row and col
                }
            } else {
                for (int col = N - 1; col >= 0; col--) {
                    ground.put(counter++, (row * layout.length) + col); // encoding row and col
                }
            }
            leftToRight = !leftToRight;
        }
        return ground;
    }

    class Location {
        int vertex;
        int steps;

        public Location(int vertex, int steps) {
            this.vertex = vertex;
            this.steps = steps;
        }
    }
}
