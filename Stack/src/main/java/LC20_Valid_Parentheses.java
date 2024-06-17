import java.util.Stack;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-17
 */
public class LC20_Valid_Parentheses {
    public boolean isValid(String s) {
        // edge case
        if (s.length() == 1) return false;

        // initialize a stack to store the parentheses
        Stack<Character> stack = new Stack<>();

        // iterate through the whole string
        for (char c : s.toCharArray()) {
            // if the char is open bracket, push into stack
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                // if the char is close bracket and there is no open bracket exists in the stack
                if (stack.isEmpty()) return false;
                // if the char is close bracket but the open bracket in the stack can't match
                if ((c == ')' && stack.peek() != '(') || (c == ']' && stack.peek() != '[') || (c == '}' && stack.peek() != '{')) {
                    return false;
                } else {
                    // if the brackets match
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }
}
