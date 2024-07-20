/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-07-19
 */
public class LC678_Valid_Parenthesis_String {
    public boolean checkValidString(String s) {
        int leftMin = 0, leftMax = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftMin++;
                leftMax++;
            } else if (c == ')') {
                leftMin--;
                leftMax--;
            } else {
                leftMin--;
                leftMax++;
            }

            if (leftMax < 0) return false;

            if (leftMin < 0) leftMin = 0; // treat the * as empty
        }

        return leftMin == 0;
    }
}
