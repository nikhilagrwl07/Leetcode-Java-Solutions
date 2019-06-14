/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public static void main(String[] args) {
//        char[][] grid = {
//                {
//                        '1', '1', '1', '1', '0'
//                },
//                {
//                        '1', '1', '0', '1', '0'
//                },
//                {
//                        '1', '1', '0', '0', '0'
//                },
//                {
//                        '0', '0', '0', '0', '0'
//                },
//        };

        char[][] grid =
        {{'1','1','0','0','0'},
        {'1','1','0','0','0'},
        {'0','0','1','0','0'},
        {'0','0','0','1','1'}};

        int countOfIslands = numIslands(grid);
        System.out.println(countOfIslands);
    }

    public static int numIslands(char[][] grid) {

        if(grid == null || grid.length==0)
            return 0;


        // BFS approach
        return bfs(grid);


        // DFS approach

//        int islandCount = 0;
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if (dfsModified(i, j, grid))
//                    islandCount++;
//            }
//        }
//        return islandCount;

    }


    private static int bfs(char[][] grid) {

        int islandCount = 0;
        Queue<Coordinate> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if(grid[i][j] == '1')
                {

                    // mark is as visited by replacing it with '0'
                    grid[i][j] = '0';
                    islandCount++;
                    queue.add(new Coordinate(i, j));

                    while(!queue.isEmpty()){
                        Coordinate coordinate = queue.remove();
                        int x = coordinate.getX();
                        int y = coordinate.getY();

                        if(isSafe(x+1, y, grid) && grid[x+1][y] == '1'){
                            grid[x+1][y] = '0';
                            queue.add(new Coordinate(x+1, y));
                        }

                        if(isSafe(x-1, y, grid) && grid[x-1][y] == '1'){
                            grid[x-1][y] = '0';
                            queue.add(new Coordinate(x-1, y));
                        }

                        if(isSafe(x, y-1, grid) && grid[x][y-1] == '1'){
                            grid[x][y-1] = '0';
                            queue.add(new Coordinate(x, y-1));
                        }

                        if(isSafe(x, y+1, grid) && grid[x][y+1] == '1'){
                            grid[x][y+1] = '0';
                            queue.add(new Coordinate(x, y+1));
                        }
                    }
                }
            }
        }
        return islandCount;
    }

    //Time Complexity - O(N^2)
    //Space Complexity - O(1)
    private static boolean dfsModified(int x, int y, char[][] grid) {
        if (!isSafe(x, y, grid) || grid[x][y] == '0')
            return false;

        // mark x and y as visited
        grid[x][y] = '0';
//        isVisited[x][y] = true;

        // up
        dfsModified(x - 1, y, grid);
        // down
        dfsModified(x + 1, y, grid);
        //left
        dfsModified(x, y - 1, grid);
        //right
        dfsModified(x, y + 1, grid);
        return true;
    }


    //Time Complexity - O(N^2)
    //Space Complexity - O(N^2)
    private static boolean dfs(int x, int y, char[][] grid, boolean[][] isVisited) {
        if (!isSafe(x, y, grid) || isVisited[x][y] || grid[x][y] == '0')
            return false;

        // mark x and y as visited
        isVisited[x][y] = true;

        // up
        dfs(x - 1, y, grid, isVisited);
        // down
        dfs(x + 1, y, grid, isVisited);
        //left
        dfs(x, y - 1, grid, isVisited);
        //right
        dfs(x, y + 1, grid, isVisited);
        return true;
    }

    private static boolean isSafe(int x, int y, char[][] grid) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length)
            return false;

        return true;

    }

    static class Coordinate{
        int x , y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}


