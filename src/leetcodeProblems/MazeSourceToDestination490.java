/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package leetcodeProblems;

public class MazeSourceToDestination490 {
    public static void main(String[] args) {

//        int[][] maze = {{0, 0, 1, 0, 0},
//                {0, 0, 0, 0, 0},
//                {0, 0, 0, 1, 0},
//                {1, 1, 0, 1, 1},
//                {0, 0, 0, 0, 0}};
//
//        int[] start = new int[2];
//        start[0] = 0;
//        start[1] = 4;
//
//        int[] dest = new int[2];
////        dest[0] = 4;
////        dest[1] = 4;
//
//        dest[0] = 3;
//        dest[1] = 2;


        int[][] maze = {
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        };

        int[] start = new int[2];
        start[0] = 0;
        start[1] = 4;

        int[] dest = new int[2];
        dest[0] = 3;
        dest[1] = 2;

        MazeSourceToDestination490 ob = new MazeSourceToDestination490();
        boolean hasPath = ob.hasPath(maze, start, dest);
        System.out.println(hasPath);
    }

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {

        boolean[][] isVisited = new boolean[maze.length][maze[0].length];
        int x = start[0];
        int y = start[1];
        boolean dfs = dfs(maze, x, y, destination, isVisited);
        return dfs;
    }

    private boolean dfs(int[][] maze, int x, int y, int[] destination, boolean[][] isVisited) {

        if (isVisited[x][y]) {
            return false;
        }

        // destination reached--> check for way out
        if (x == destination[0] && y == destination[1]) {
            return true;
        }

        isVisited[x][y] = true;

        int left = y - 1;
        while (left >= 0 &&  maze[x][left] == 0) {
            left--;
        }
        if (dfs(maze, x, left + 1, destination, isVisited)) {
            return true;
        }


        int right = y + 1;
        while (right <= maze[0].length - 1 && maze[x][right] == 0) {
            right++;
        }

        if (dfs(maze, x, right - 1, destination, isVisited)) {
            return true;
        }

        int up = x - 1;
        while (up >= 0 && maze[up][y] == 0) {
            up--;
        }

        if (dfs(maze, up + 1, y, destination, isVisited)) {
            return true;
        }

        int down = x + 1;
        while (down <= maze.length - 1 && maze[down][y] == 0) {
            down++;
        }

        if (dfs(maze, down - 1, y, destination, isVisited)) {
            return true;
        }

        return false;
    }

}
