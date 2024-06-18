/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-18
 */
public class LC704_Binary_Search {
    public int search(int[] nums, int target) {
        // initialize two pointers
        int left = 0, right = nums.length - 1;
        int mid;

        // shrink the interval
        while (left <= right) {
            mid = left + (right - left) / 2;

            // mid > target, left interval, mid < target, right interval
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
