import java.util.HashSet;
import java.util.Set;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-16
 */
public class LC36_Valid_Sudoku {
    public boolean isValidSudoku(char[][] board) {
        // create set to track digits for each row, column, block
        Set<String> seen = new HashSet<>();

        // iterate through each cell to verify
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char curChar = board[i][j];

                // only check filled cells
                if (curChar != '.') {
                    String rowKey = "row" + i + curChar;
                    String columnKey = "column" + j + curChar;
                    String blockKey = "block" + (i/3) + (j/3) + curChar;

                    // verify the unique in each row, column and block
                    if (!seen.add(rowKey) || !seen.add(columnKey) || !seen.add(blockKey)) {
                        return false; // duplicates found
                    }
                }
            }
        }

        // no duplicates found
        return true;
    }
}
