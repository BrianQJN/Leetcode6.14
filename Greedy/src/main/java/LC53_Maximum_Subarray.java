/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-07-13
 */
public class LC53_Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        // edge cases
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // initialization
        int maxSum = nums[0];
        int currentSum = nums[0];

        // start from the second element in the array
        for (int i = 1; i < nums.length; i++) {
            // choose between starting a new subarray or extending the existing one
            currentSum = Math.max(nums[i], currentSum + nums[i]);

            // update the max sum
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
