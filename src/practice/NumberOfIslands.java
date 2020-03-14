package practice;

public class NumberOfIslands {
    public static void main(String[] args) {

        NumberOfIslands ob = new NumberOfIslands();

//        char[][] grid = {
//                {'0','0'},
//                {'0','0'}
//        };

//        char[][] grid = {
//                        {'1', '1', '0', '0', '0'},
//                        {'1', '1', '0', '0', '0'},
//                        {'1', '1', '1', '1', '0'},
//                        {'0', '0', '0', '0', '1'}};

        char[][] grid = {
                {'1', '0', '1', '1', '1'},
                {'1', '0', '1', '0', '1'},
                {'1', '1', '1', '0', '1'}
        };

        int numIslands = ob.numIslands(grid);
        System.out.println(numIslands);
    }

    // dfs approach
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        int count = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    dfs(grid, r, c);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0')
            return;

        grid[r][c] = '0';

        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

}
