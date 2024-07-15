/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-07-13
 */
public class LC55_Jump_Game {
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;

        // start from the second to last element
        for (int i = nums.length - 2; i >= 0; i--) {
            // if we can reach last position from cur position, update last position
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }

        // if last position is 0, means we can reach the end from the start
        return lastPos == 0;
    }
}
