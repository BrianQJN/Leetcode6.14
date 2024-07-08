import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-07-07
 */
public class LC17_Letter_Combinations_of_a_Phone_Number {
    private static final String[] LETTERS = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
    };
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.isEmpty()) {
            return res;
        }
        backtrack(res, new StringBuilder(), digits, 0);
        return res;
    }

    private void backtrack(List<String> res, StringBuilder curCombination, String digits, int index) {
        // if we have processed all digits, add the cur combination to the result
        if (index == digits.length()) {
            res.add(curCombination.toString());
            return;
        }

        // get the letters corresponding to the current digit
        String letters = LETTERS[digits.charAt(index) - '0'];

        // try all letters for the cur digit
        for (char letter : letters.toCharArray()) {
            // add the cur letter to combination
            curCombination.append(letter);
            // recursively process the next digit
            backtrack(res, curCombination, digits, index + 1);
            // backtrack: remove the last letter to try next one
            curCombination.deleteCharAt(curCombination.length() - 1);
        }
    }
}
