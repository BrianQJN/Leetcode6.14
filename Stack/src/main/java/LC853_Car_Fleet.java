import java.util.Arrays;
import java.util.Stack;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-17
 */
public class LC853_Car_Fleet {
    public int carFleet(int target, int[] position, int[] speed) {
        // pair each car's position with time to reach the target
        int n = position.length;
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double) (target - position[i]) / speed[i];
        }

        // sort cars by their starting positions in descending order
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        // use a stack to count the number of fleets
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            double time = cars[i][1];
            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }
        }

        return stack.size();
    }
}
