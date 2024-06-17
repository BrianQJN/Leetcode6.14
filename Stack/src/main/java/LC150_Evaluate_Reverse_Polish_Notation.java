import java.util.Stack;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-17
 */
public class LC150_Evaluate_Reverse_Polish_Notation {
    public int evalRPN(String[] tokens) {
        // initialize a stack to store the operands
        Stack<Integer> stack = new Stack<>();

        // traverse through the array tokens
        for (String str : tokens) {
            if (isOperator(str)) {
                // retrieve the operands from the stack
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int res = applyOperation(str, operand1, operand2);
                stack.push(res);
            } else {
                // the str is operand, directly push into stack
                stack.push(Integer.parseInt(str));
            }
        }

        return stack.pop();
    }

    private boolean isOperator(String str) {
        if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
            return true;
        }
        return false;
    }

    private int applyOperation(String operator, int operand1, int operand2) {
        switch (operator) {
            case "+" -> {
                return operand1 + operand2;
            }
            case "-" -> {
                return operand1 - operand2;
            }
            case "*" -> {
                return operand1 * operand2;
            }
            case "/" -> {
                return operand1 / operand2;
            }
            default -> {
                throw new IllegalArgumentException("Invalid Operator");
            }
        }
    }
}
