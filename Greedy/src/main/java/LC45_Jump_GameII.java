/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-07-14
 */
public class LC45_Jump_GameII {
    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }

        int jumps = 0;
        int curMax = 0;
        int nextMax = 0;

        for (int i = 0; i < nums.length; i++) {
            nextMax = Math.max(nextMax, i + nums[i]);

            if (i == curMax) {
                jumps++;
                curMax = nextMax;

                if (curMax >= nums.length - 1) {
                    break;
                }
            }
        }

        return jumps;
    }
}
