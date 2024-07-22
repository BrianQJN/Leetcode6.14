import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-07-22
 */
public class LC994_Rotting_Oranges {
    private final int ROTTEN = 2;
    private final int FRESH = 1;
    private final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return -1;

        // initialization
        int timeElapse = 0;
        int freshOranges = 0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        // add all rotten oranges to queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == ROTTEN) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == FRESH) {
                    freshOranges++;
                }
            }
        }

        // if there is no fresh oranges
        if (freshOranges == 0) return 0;

        // rotten oranges from the start simultaneously
        while (!queue.isEmpty() && freshOranges > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                int row = point[0];
                int col = point[1];

                for (int[] direction : DIRECTIONS) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];

                    if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || grid[newRow][newCol] != FRESH) {
                        continue;
                    }

                    // rotten the fresh orange
                    grid[newRow][newCol] = ROTTEN;
                    queue.add(new int[]{newRow, newCol});
                    freshOranges--;
                }
            }
            timeElapse++;
        }

        return freshOranges == 0 ? timeElapse : -1;
    }
}
