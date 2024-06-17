import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-17
 */
public class LC239_Sliding_Window_Maximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // initialize a deque to record the elements and their indices
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        // move the window
        for (int i = 0; i < n; i++) {
            // remove indices from the back if the elements are less than the cur element
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            // add the cur index to the back of the deque
            deque.addLast(i);

            // remove the front index if it is out of the cur window's range
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // add the maximum element of the cur window to the result list
            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return res;
    }
}
