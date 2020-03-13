package leetcodeProblems.hard;

import java.util.ArrayList;
import java.util.List;

public class WordLadderII305 {
    public static void main(String[] args) {
        WordLadderII305 ob = new WordLadderII305();
        int m = 3, n = 3;
        int[][] positions = {{0,0}, {0,1}, {1,2}, {2,1}};

        List<Integer> result = ob.numIslands2(m, n, positions);
        System.out.println(result);
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        if (n == 0 || m == 0 || positions == null || positions.length == 0)
            return new ArrayList<>();

        int[][] grid = new int[m][n];
        List<Integer> result = new ArrayList<>();

        for (int r = 0; r < positions.length; r++) {

            int x = positions[r][0];
            int y = positions[r][1];

            if (r == 0) {
                grid[x][y] = 1;
                result.add(1);
                continue;
            }

            boolean isConnected = dfs(grid, x - 1, y) || dfs(grid, x + 1, y)
                    || dfs(grid, x, y - 1) || dfs(grid, x, y + 1);

            grid[x][y] = 1;

            if (isConnected) {
                result.add(result.get(result.size() - 1));
            } else {
                result.add(result.get(result.size() - 1) + 1);
            }
        }
        return result;
    }

    private boolean dfs(int[][] grid, int x, int y) {

        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0)
            return false;

        if (grid[x][y] == 1)
            return true;

        if (dfs(grid, x - 1, y) || dfs(grid, x + 1, y) || dfs(grid, x, y + 1) || dfs(grid, x, y - 1))
            return true;

        return false;
    }
}
