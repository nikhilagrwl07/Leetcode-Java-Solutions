/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package miscellaneous;

//Source - https://leetcode.com/discuss/interview-question/322396/google-onsite-interview-robot-in-maze
public class RobotInMaze {
    public static void main(String[] args) {
        RobotInMaze rMaze = new RobotInMaze();

        int row = 4;
        int col = 5;
        int[][] maze = new int[row][col];
        int[][] currentPosition = new int[1][2];
        currentPosition[0][0] = maze.length-1 ;
        currentPosition[0][1] = 0;

        int numberOfWays = rMaze.numberOfWays(maze, currentPosition);
        System.out.println(numberOfWays);
    }


    public int numberOfWays(int[][] maze, int[][] currentPosition) {
        boolean[][] isVisited = new boolean[maze.length][maze[0].length];
        return numberOfWaysUtil(maze, currentPosition[0][0], currentPosition[0][1], isVisited);
    }


    public int numberOfWaysUtil(int[][] maze, int x, int y, boolean[][] isVisited) {

        if (!isSafe(maze, x, y, isVisited)) {
            return 0;
        }

        if (x == maze.length - 1 && y == maze[0].length - 1) {
            return 1;
        }

        isVisited[x][y] = true;


        int pathCount = numberOfWaysUtil(maze, x, y + 1, isVisited)
                + numberOfWaysUtil(maze, x - 1, y + 1, isVisited)
                + numberOfWaysUtil(maze, x + 1, y + 1, isVisited);

        isVisited[x][y] = false;
        return pathCount;
    }

    public boolean isSafe(int[][] maze, int x, int y, boolean[][] isVisited) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && !isVisited[x][y];
    }
}
