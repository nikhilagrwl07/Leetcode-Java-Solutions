package leetcodeProblems.medium;/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands200 {
    public static void main(String[] args) {
        NumberOfIslands200 ob = new NumberOfIslands200();
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
                {{'1', '1', '0', '0', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '1', '0', '0'},
                        {'0', '0', '0', '1', '1'}};

        int countOfIslands = ob.numIslands(grid);
        System.out.println(countOfIslands);
    }

    // DFS using explicit stack
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        // BFS approach
//        return bfs(grid);

        int count = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    count++;
                    dfs(r, c, grid);
                }
            }
        }

        return count;
    }

    // Time - O(Row* Column)
    // Space - O(Longest path of a given island which could be Row * Column)
    private void dfs(int r, int c, char[][] grid) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0')
            return;

        grid[r][c] = '0';

        // push all children to stack
        dfs(r - 1, c, grid);
        dfs(r + 1, c, grid);
        dfs(r, c - 1, grid);
        dfs(r, c + 1, grid);
    }

    private static int bfs(char[][] grid) {
        int islandCount = 0;
        Queue<Integer> queue = new LinkedList<>();
        int numberOfRows = grid.length;
        int numberOfColumns = grid[0].length;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {

                if (grid[r][c] == '1') {

                    // mark is as visited by replacing it with '0'
                    grid[r][c] = '0';
                    islandCount++;
                    queue.add(r * numberOfColumns + c);

                    while (!queue.isEmpty()) {
                        Integer coordinate = queue.remove();
                        int x = coordinate / numberOfColumns;
                        int y = coordinate % numberOfColumns;

                        if (isSafe(x + 1, y, grid) && grid[x + 1][y] == '1') {
                            grid[x + 1][y] = '0';
                            queue.add((x+1) * numberOfColumns + y);
                        }

                        if (isSafe(x - 1, y, grid) && grid[x - 1][y] == '1') {
                            grid[x - 1][y] = '0';
                            queue.add((x - 1) * numberOfColumns + y);
                        }

                        if (isSafe(x, y - 1, grid) && grid[x][y - 1] == '1') {
                            grid[x][y - 1] = '0';
                            queue.add(x * numberOfColumns + (y - 1));
                        }

                        if (isSafe(x, y + 1, grid) && grid[x][y + 1] == '1') {
                            grid[x][y + 1] = '0';
                            queue.add(x * numberOfColumns + (y + 1));
                        }
                    }
                }
            }
        }
        return islandCount;
    }

    private static boolean isSafe(int x, int y, char[][] grid) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
    }
}


