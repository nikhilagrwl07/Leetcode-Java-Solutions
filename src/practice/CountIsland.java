package practice;

public class CountIsland {
    public static void main(String[] args) {
        CountIsland ob = new CountIsland();
//        char[][] grid =
//                {{'1', '1', '0', '0', '0'},
//                        {'1', '1', '0', '0', '0'},
//                        {'0', '0', '1', '0', '0'},
//                        {'0', '0', '0', '1', '1'}};

        char[][] grid = {
                {
                        '1', '1', '1', '1', '0'
                },
                {
                        '1', '1', '0', '1', '0'
                },
                {
                        '1', '1', '0', '0', '0'
                },
                {
                        '0', '0', '0', '0', '0'
                },
        };

        int numIslands = ob.numIslands(grid);
        System.out.println(numIslands);


    }

    // DFS using explicit stack
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

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

}
