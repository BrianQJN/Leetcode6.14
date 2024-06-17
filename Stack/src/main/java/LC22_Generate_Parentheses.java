import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-17
 */
public class LC22_Generate_Parentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, "", 0, 0, n);
        return res;
    }

    private void backtrack(List<String> res, String cur, int open, int close, int max) {
        // base case: if the cur string has reached the maximum length
        if (cur.length() == 2 * max) {
            res.add(cur);
            return;
        }

        // if we can add an open parentheses, add it and recurse
        if (open < max) {
            backtrack(res, cur + "(", open + 1, close, max);
        }

        // if we can add a close parentheses, add it and recurse
        if (close < open) {
            backtrack(res, cur + ")", open, close + 1, max);
        }
    }
}
