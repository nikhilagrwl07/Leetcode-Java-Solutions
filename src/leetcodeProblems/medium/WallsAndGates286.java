package leetcodeProblems.medium;

import java.util.Arrays;

public class WallsAndGates286 {
    public static void main(String[] args) {
        WallsAndGates286 ob = new WallsAndGates286();

//        INF  -1  0  INF
//        INF INF INF  -1
//        INF  -1 INF  -1
//        0  -1 INF INF
        int[][] grid = {
                {Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
                {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1},
                {0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE}
        };

//        int[][] grid = {};

        ob.wallsAndGates(grid);
        System.out.println(Arrays.deepToString(grid));
    }

    // DFS
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null)
            return;

        if (rooms.length == 0)
            return;


        for (int r = 0; r < rooms.length; r++) {
            for (int c = 0; c < rooms[0].length; c++) {
                if (rooms[r][c] == 0) { // gate found so
                    dfs(rooms, r, c, 0);
                }
            }
        }

    }

    private void dfs(int[][] rooms, int r, int c, int counter) {

        if (r < 0 || r >= rooms.length || c < 0 || c >= rooms[0].length
                || rooms[r][c] < counter)
            return;

        rooms[r][c] = counter;
        dfs(rooms, r - 1, c, counter + 1);
        dfs(rooms, r + 1, c, counter + 1);
        dfs(rooms, r, c - 1, counter + 1);
        dfs(rooms, r, c + 1, counter + 1);
    }


    // BFS
//    public void wallsAndGates(int[][] rooms) {
//        if (rooms == null)
//            return;
//
//        if (rooms.length == 0)
//            return;
//
//        int[][] directions = {
//                {-1, 0},
//                {1, 0},
//                {0, -1},
//                {0, 1},
//        };
//
//        Queue<int[]> q = new LinkedList<>();
//
//        int totalCells = rooms.length * rooms[0].length;
//        int currentCount = 0;
//        for (int r = 0; r < rooms.length; r++) {
//            for (int c = 0; c < rooms[0].length; c++) {
//                if (rooms[r][c] == 0) {
//                    int[] pair = new int[2];
//                    pair[0] = r;
//                    pair[1] = c;
//                    q.offer(pair);
//                    currentCount++;
//                }
//            }
//        }
//
//        while (!q.isEmpty()) {
//
//            if (currentCount == totalCells)
//                return;
//
//            int[] pair = q.poll();
//
//            for (int[] direction : directions) {
//                int newR = pair[0] + direction[0];
//                int newC = pair[1] + direction[1];
//
//                if (newR >= 0 && newR <= rooms.length - 1 &&
//                        newC >= 0 && newC <= rooms[0].length - 1
//                        && rooms[newR][newC] == Integer.MAX_VALUE) {
//
//                    int[] newPair = new int[2];
//                    newPair[0] = newR;
//                    newPair[1] = newC;
//                    rooms[newR][newC] = rooms[pair[0]][pair[1]] + 1;
//                    q.offer(newPair);
//                    currentCount++;
//                }
//            }
//        }
//    }
}
