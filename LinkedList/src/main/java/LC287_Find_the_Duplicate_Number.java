/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-23
 */
public class LC287_Find_the_Duplicate_Number {
    public int findDuplicate(int[] nums) {
        // find the intersection point of the two pointers
        int slow = nums[0], fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // find the entrance to the cycle
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return fast;
    }
}
