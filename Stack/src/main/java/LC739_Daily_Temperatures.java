import java.util.Stack;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-17
 */
public class LC739_Daily_Temperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        // initialize a stack to record the index of the temperatures
        int n = temperatures.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];

        // traverse through the array temperatures
        for (int i = 0; i < n; i++) {
            int curTemp = temperatures[i];

            // if curTemp is greater than the top in the stack, pop it
            while (!stack.isEmpty() && curTemp > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                res[prevIndex] = i - prevIndex;
            }

            // push cur index into the stack
            stack.push(i);
        }

        return res;
    }
}
