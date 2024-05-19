/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-05-18
 */
public class LC1929_Concatenation_of_Array {
    /**
     * @param nums an integer array nums of length n
     * @return an array ans of length 2n where ans[i] == nums[i] and ans[i + n] == nums[i]
     * @implSpec Given an integer array nums of length n, you want to create an array ans of length 2n where ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).
     * Specifically, ans is the concatenation of two nums arrays.
     * Return the array ans.
     * @author Brian Qu
     * @since 2024-05-18 23:53
     */
    public int[] getConcatenation(int[] nums) {
        // initialize the result array
        int[] res = new int[nums.length * 2];

        // traverse original array once to replace the result array elements
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i];
            res[i + nums.length] = nums[i];
        }

        return res;
    }
}
