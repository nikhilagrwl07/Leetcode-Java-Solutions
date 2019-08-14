/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package leetcodeProblems;

import java.util.Arrays;

public class DistanceFromSourceToDestinationInMaze505 {
    public static void main(String[] args) {

        int[][] maze = {
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}};

        int[] start = new int[2];
        start[0] = 0;
        start[1] = 4;

        int[] dest = new int[2];
        dest[0] = 4;
        dest[1] = 4;

//        dest[0] = 3;
//        dest[1] = 2;


//        int[][] maze = {
//                {0, 0, 1, 0, 0},
//                {0, 0, 0, 0, 0},
//                {0, 0, 0, 1, 0},
//                {1, 1, 0, 1, 1},
//                {0, 0, 0, 0, 0}
//        };
//
//        int[] start = new int[2];
//        start[0] = 0;
//        start[1] = 4;
//
//        int[] dest = new int[2];
//        dest[0] = 3;
//        dest[1] = 2;

        DistanceFromSourceToDestinationInMaze505 ob = new DistanceFromSourceToDestinationInMaze505();
        int distance = ob.shortestDistance(maze, start, dest);
        System.out.println(distance);
    }

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {

        int[][] distance = new int[maze.length][maze[0].length];

        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        int[][] directions = {
                {0, -1}, // left
                {0, 1}, // right
                {-1, 0}, // up
                {1, 0},  // down
        };
        distance[start[0]][start[1]] = 0;
        dfs(maze, start, distance, directions);

        // not passing destination coordinates in DFS
        return (distance[destination[0]][destination[1]] == Integer.MAX_VALUE) ? -1 : distance[destination[0]][destination[1]];
    }

    // Time Complexity - O(Row * Column * Max(Row, Column))
    // Space Complexity - O(Row * Column)
    private void dfs(int[][] maze, int[] start,
                     int[][] distance, int[][] directions) {

        for (int[] direction : directions) {
            int x = start[0] + direction[0];
            int y = start[1] + direction[1];

            int count = 0;
            while (x >= 0 && x <= maze.length - 1 && y >= 0 && y <= maze[0].length - 1 && maze[x][y] == 0) {
                x += direction[0];
                y += direction[1];
                count++;
            }

            int newDistance = distance[start[0]][start[1]] + count;
            int oldDistance = distance[x - direction[0]][y - direction[1]];

            if (oldDistance > newDistance) {
                distance[x - direction[0]][y - direction[1]] = newDistance;
                dfs(maze, new int[]{x - direction[0], y - direction[1]}, distance, directions);
            }
        }
    }

}
