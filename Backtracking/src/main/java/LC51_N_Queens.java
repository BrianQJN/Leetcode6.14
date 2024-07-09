import java.util.*;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-07-08
 */
public class LC51_N_Queens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        backtrack(board, 0, new HashSet<>(), new HashSet<>(), new HashSet<>(), res);

        return res;
    }

    private void backtrack(char[][] board, int row, Set<Integer> cols, Set<Integer> diags, Set<Integer> antiDiags, List<List<String>> res) {
        if (row == board.length) {
            res.add(creatBoard(board));
            return;
        }

        for (int col = 0; col < board.length; col++) {
            int diag = row - col;
            int antiDiag = row + col;

            // if the queen can be placed
            if (!cols.contains(col) && !diags.contains(diag) && !antiDiags.contains(antiDiag)) {
                board[row][col] = 'Q';
                cols.add(col);
                diags.add(diag);
                antiDiags.add(antiDiag);

                // recursively process the next row
                backtrack(board, row + 1, cols, diags, antiDiags, res);

                // backtrack: reset the Queen last placed
                board[row][col] = '.';
                cols.remove(col);
                diags.remove(diag);
                antiDiags.remove(antiDiag);
            }
        }
    }

    private List<String> creatBoard(char[][] board) {
        List<String> newBoard = new ArrayList<>();
        for (char[] row : board) {
            newBoard.add(new String(row));
        }
        return newBoard;
    }
}
