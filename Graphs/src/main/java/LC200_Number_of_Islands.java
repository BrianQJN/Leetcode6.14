/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-07-20
 */
public class LC200_Number_of_Islands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        // initialization
        int numIslands = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        // traverse the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    numIslands++;
                    dfs(grid, i, j);
                }
            }
        }

        return numIslands;
    }

    private void dfs(char[][] grid, int i , int j) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == '0') {
            return;
        }

        // mark cur land as visited
        grid[i][j] = '0';

        // recursively visit all adjacent lands
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}
