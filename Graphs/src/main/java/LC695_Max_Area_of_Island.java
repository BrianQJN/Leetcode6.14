/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-07-20
 */
public class LC695_Max_Area_of_Island {
    private int curArea, maxArea;

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        // initialization
        int m = grid.length;
        int n = grid[0].length;
        maxArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    curArea = 0;
                    dfs(grid, i, j);
                    maxArea = Math.max(maxArea, curArea);
                }
            }
        }

        return maxArea;
    }

    private void dfs(int[][] grid, int i, int j) {
        // initialization
        int rows = grid.length;
        int cols = grid[0].length;

        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == 0) {
            return;
        }

        // curArea plus 1, and set cur grid to 0 to avoid redundant calculation
        curArea++;
        grid[i][j] = 0;

        // explore the up, down, left and right directions
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}
