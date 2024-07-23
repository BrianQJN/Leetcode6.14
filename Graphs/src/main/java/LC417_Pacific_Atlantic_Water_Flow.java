import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-07-22
 */
public class LC417_Pacific_Atlantic_Water_Flow {
    private final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int m, n;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // initialization
        this.m = heights.length;
        this.n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        List<List<Integer>> res = new ArrayList<>();

        // dfs from top and left edges (Pacific)
        for (int i = 0; i < m; i++) {
            dfs(heights, i, 0, pacific);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, 0, j, pacific);
        }

        // dfs from bottom and right edges (Atlantic)
        for (int i = 0; i < m; i++) {
            dfs(heights, i, n - 1, atlantic);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, m - 1, j, atlantic);
        }

        // find cells that are reachable from both oceans
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    private void dfs(int[][] heights, int i, int j, boolean[][] ocean) {
        // set cur cell to be reachable by cur ocean
        ocean[i][j] = true;

        // traverse four directions
        for (int[] direction : DIRECTIONS) {
            int newRow = i + direction[0];
            int newCol = j + direction[1];

            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && heights[newRow][newCol] >= heights[i][j] && !ocean[newRow][newCol]) {
                dfs(heights, newRow, newCol, ocean);
            }
        }
    }
}
