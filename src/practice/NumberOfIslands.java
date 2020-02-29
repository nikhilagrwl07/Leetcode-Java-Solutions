package practice;

import java.util.HashSet;
import java.util.Set;

public class NumberOfIslands {
    public static void main(String[] args) {

        char[][] grid =
                {{'1', '0', '1', '1', '1'},
                        {'1', '0', '1', '0', '1'},
                        {'1', '1', '1', '0', '1'}};


//        char[][] grid =
//                        {{'1', '1', '0', '0', '0'},
//                        {'1', '1', '0', '0', '0'},
//                        {'1', '1', '1', '1', '0'},
//                        {'0', '0', '0', '0', '1'}};

//        char[][] grid = {{'1', '1', '0', '0', '0'},
//            {'1', '1', '0', '0', '0'},
//            {'0', '0', '1', '0', '0'},
//            {'0', '0', '0', '1', '1'}};

//        char[][] grid = {};
//        char[][] grid = {{'1'}};

        NumberOfIslands ob = new NumberOfIslands();
        int numOfIslands = ob.numIslands(grid);
        System.out.println(numOfIslands);
    }

    // DFS approach
    // Time Complexity - O(Rows * Columns)
    // Space Complexity - O(Rows * Columns) in worst case if all entries are land recursion goes deep
//    public int numIslands(char[][] grid) {
//        if (grid == null || grid.length == 0)
//            return 0;
//
//        int numberOfIslands = 0;
//        for (int r = 0; r < grid.length; r++) {
//            for (int c = 0; c < grid[0].length; c++) {
//                if (grid[r][c] == '1') {
//                    numberOfIslands++;
//                    dfs(grid, r, c);
//                }
//
//            }
//        }
//        return numberOfIslands;
//    }

//    private void dfs(char[][] grid, int r, int c) {
//        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0')
//            return;
//
//        // marked as visited
//        grid[r][c]='0';
//
//        dfs(grid, r+1, c);
//        dfs(grid, r-1, c);
//        dfs(grid, r, c+1);
//        dfs(grid, r, c-1);
//    }

    // BFS approach
    // Time complexity - O(Rows * Columns)
    // Space complexity - O(Min(Rows, Columns))
//    public int numIslands(char[][] grid) {
//        if (grid == null || grid.length== 0) {
//            return 0;
//        }
//
//        Queue<Integer> q = new LinkedList<>();
//        int numberOfIsland = 0;
//        int totalRows = grid.length;
//        int totalCols = grid[0].length;
//
//        for (int r = 0; r < grid.length; r++) {
//            for (int c = 0; c < grid[0].length; c++) {
//
//                if (grid[r][c] == '1') {
//                    grid[r][c] = '0';
//                    numberOfIsland++;
//                    q.offer(r * totalCols + c);
//
//                    while (!q.isEmpty()) {
//                        Integer pc = q.poll();
//                        int currentRow = pc / totalCols;
//                        int currentCol = pc % totalCols;
//
//                        if (isSafe(currentRow + 1, currentCol, grid) && isLand(currentRow + 1, currentCol, grid)) {
//                            grid[currentRow + 1][currentCol] = '0';
//                            q.add((currentRow+1)*totalCols + currentCol);
//                        }
//
//                        if (isSafe(currentRow - 1, currentCol, grid) && isLand(currentRow - 1, currentCol, grid)) {
//                            grid[currentRow - 1][currentCol] = '0';
//                            q.add((currentRow-1)*totalCols + currentCol);
//                        }
//
//                        if (isSafe(currentRow, currentCol + 1, grid) && isLand(currentRow, currentCol + 1, grid)) {
//                            grid[currentRow][currentCol + 1] = '0';
//                            q.add((currentRow)*totalCols + (currentCol+1));
//                        }
//
//                        if (isSafe(currentRow, currentCol - 1, grid) && isLand(currentRow, currentCol - 1, grid)) {
//                            grid[currentRow][currentCol - 1] = '0';
//                            q.add((currentRow)*totalCols + (currentCol-1));
//                        }
//                    }
//                }
//            }
//        }
//        return numberOfIsland;
//    }

    private boolean isLand(int r, int c, char[][] grid) {
        return grid[r][c] == '1';
    }

    private boolean isSafe(int r, int c, char[][] grid) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }

    int[] parent;
    int[] rank;
    int numberOfDisconnectedComp = 0;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        int r = grid.length;
        int c = grid[0].length;
        parent = new int[r * c];
        rank = new int[r * c];

        // initializing the rank and parent array
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int index = (i * c) + j;
                rank[index] = 0;
                parent[index] = index;
                numberOfDisconnectedComp++;
            }
        }

        for (int i = 0; i < parent.length; i++) {
            int x1 = i / c;
            int y1 = i % c;

            if (grid[x1][y1] == '1') {

                grid[x1][y1] = '0';

                if (x1 - 1 >= 0 && grid[x1 - 1][y1] == '1') {
                    union(i, ((x1 - 1) * c) + y1, grid);
                }
                if (x1 + 1 < grid.length && grid[x1 + 1][y1] == '1') {
                    union(i, ((x1 + 1) * c) + y1, grid);
                }

                if (y1 - 1 >= 0 && grid[x1][y1 - 1] == '1') {
                    union(i, (x1 * c) + (y1 - 1), grid);
                }

                if (y1 + 1 < grid[0].length && grid[x1][y1 + 1] == '1') {
                    union(i, (x1 * c) + (y1 + 1), grid);
                }
            }
        }

        return numberOfDisconnectedComp;
    }

    // union by rank
    public void union(int x, int y, char[][] grid) {
        int parentOfX = find(x);
        int parentOfY = find(y);

        if (parentOfX != parentOfY) {
            if (rank[parentOfX] < rank[parentOfY]) {
                parent[parentOfX] = parentOfY;
            } else if (rank[parentOfX] > rank[parentOfY]) {
                parent[parentOfY] = parentOfX;
            } else {
                parent[parentOfX] = parentOfY;
                rank[parentOfY]++;
            }
            numberOfDisconnectedComp--;
        }
    }

    // return top most parent of request node
    public int find(int x) {

        if (parent[x] != x) {
            parent[x] = find(parent[x]);        // applying path compression along the way
        }
        return parent[x];
    }


    private boolean neighbour(int x1, int y1, int x2, int y2) {
//        System.out.println("x1 " + x1 +",y1 " + y1 + " x2 " + x2 +",y2 " + y2 );
        int xDistance = Math.abs(x1 - x2);
        int yDistance = Math.abs(y1 - y2);

        if ((xDistance == 0 && yDistance == 1) || (xDistance == 1 && yDistance == 0)) {
            return true;
        }
        return false;
    }


}
