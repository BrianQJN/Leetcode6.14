/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-07-22
 */
public class LC130_Surrounded_Regions {
    private int m, n;
    private final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public void solve(char[][] board) {
        // initialization
        m = board.length;
        n = board[0].length;

        // mark all '0's on the border and their connected '0's to 'T'
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }

        for (int j = 0; j < n; j++) {
            dfs(board, 0, j);
            dfs(board, m - 1, j);
        }

        // flip '0's to 'X's and 'T's to '0's
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= m || j < 0 ||j >= n || board[i][j] != 'O') {
            return;
        }

        board[i][j] = 'T';

        // traverse four directions
        for (int[] direction : DIRECTIONS) {
            int newI = i + direction[0];
            int newJ = j + direction[1];

            dfs(board, newI, newJ);
        }
    }
}
