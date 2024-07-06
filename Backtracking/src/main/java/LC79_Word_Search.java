import java.util.Arrays;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-07-05
 */
public class LC79_Word_Search {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int m, n;
    private char[][] board;
    private String word;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        this.m = board.length;
        this.n = board[0].length;

        // search
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && dfs(i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int i, int j, int index) {
        // if we matched all chars, we have found the word
        if (index == word.length()) return true;

        // check if we are out of bounds or if the cur cell doesn't match
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word.charAt(index)) {
            return false;
        }

        // mark the cur cell as visited
        char temp = board[i][j];
        board[i][j] = '#';

        // explore all four directions
        for (int[] dir : DIRECTIONS) {
            int newX = i + dir[0];
            int newY = j + dir[1];
            if (dfs(newX, newY, index + 1)) {
                return true;
            }
        }

        // backtrack: restore the cell
        board[i][j] = temp;

        return false;
    }
}
