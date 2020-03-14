package leetcodeProblems.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadderII305 {
    public static void main(String[] args) {
        WordLadderII305 ob = new WordLadderII305();
//        int m = 3, n = 3;
//        int[][] positions = {{0, 0}, {0, 1}, {1, 2}, {2, 1}};

//        int m = 3, n = 3;
//        int[][] positions = {{0, 0}, {0, 1}, {1, 2}, {1, 2}};


//        int m = 2, n = 2;
//        int[][] positions = {{0, 0}, {1, 1}, {0, 1}};

        int m = 3, n = 3;
        int[][] positions = {{0,1},{1,2},{2,1},{1,0},{0,2},{0,0},{1,1}};

        List<Integer> result = ob.numIslands2(m, n, positions);
        System.out.println(result);
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        if (n == 0 || m == 0 || positions == null || positions.length == 0)
            return new ArrayList<>();

        int[][] grid = new int[m][n];
        List<Integer> result = new ArrayList<>();
        int[] nr = new int[4];
        int counter = 1;

        Set<Integer> s = new HashSet<>();

        for (int r = 0; r < positions.length; r++) {

            int x = positions[r][0];
            int y = positions[r][1];

            if (grid[x][y] > 0) {
                result.add(result.get(result.size() - 1));
                continue;
            }

            nr[0] = getValue(grid, x - 1, y);
            nr[1] = getValue(grid, x + 1, y);
            nr[2] = getValue(grid, x, y - 1);
            nr[3] = getValue(grid, x, y + 1);

            // all neighbours are water
            if (nr[0] == 0 && nr[1] == 0 && nr[2] == 0 && nr[3] == 0) {
                grid[x][y] = counter++;
                if (result.isEmpty()) {
                    result.add(1);
                    continue;
                } else {
                    result.add(result.get(result.size() - 1) + 1);
                    continue;
                }
            }

            int maxNeighbour = Math.max(nr[0], nr[1]);
            int maxNeighbour2 = Math.max(nr[2], nr[3]);
            int maxNeighbour3 = Math.max(maxNeighbour, maxNeighbour2);
            grid[x][y] = maxNeighbour3;

            int tmp = 0;
            for (int i = 0; i < 4; i++) {
                if (nr[i] > 0 && !s.contains(nr[i])) {
                    tmp++;
                    s.add(nr[i]);
                }
            }
            s.clear();
            result.add(result.get(result.size() - 1) - tmp + 1);

            dfs(grid, maxNeighbour3, x - 1, y);
            dfs(grid, maxNeighbour3, x + 1, y);
            dfs(grid, maxNeighbour3, x, y - 1);
            dfs(grid, maxNeighbour3, x, y + 1);
        }
        return result;
    }

    private void dfs(int[][] grid, int updatedValue, int x, int y) {

        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length
                || grid[x][y] == 0 || grid[x][y] >= updatedValue)
            return;

        grid[x][y] = updatedValue;
        dfs(grid, updatedValue, x - 1, y);
        dfs(grid, updatedValue, x + 1, y);
        dfs(grid, updatedValue, x, y - 1);
        dfs(grid, updatedValue, x, y + 1);

    }

    private int getValue(int[][] grid, int x, int y) {

        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0)
            return 0;

        return grid[x][y];
    }
}
