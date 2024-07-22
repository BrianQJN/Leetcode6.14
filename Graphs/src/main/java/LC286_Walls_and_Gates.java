import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-07-22
 */
public class LC286_Walls_and_Gates {
    private final int EMPTY = Integer.MAX_VALUE;
    private final int GATE = 0;
    private final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }

        int m = rooms.length;
        int n = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();

        // add all gates to the queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == GATE) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int row = point[0];
            int col = point[1];

            for (int[] direction : DIRECTIONS) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || rooms[newRow][newCol] != EMPTY) {
                    continue;
                }

                rooms[newRow][newCol] = rooms[row][col] + 1;
                queue.add(new int[]{newRow, newCol});
            }
        }
    }
}
