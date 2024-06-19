/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-19
 */
public class LC33_Search_in_Rotated_Sorted_Array {
    public int search(int[] nums, int target) {
        // initialize two pointers
        int n = nums.length;
        int left = 0, right = n - 1;
        int mid, midValue;

        // shrink the interval
        while (left <= right) {
            mid = left + (right - left) / 2;
            midValue = nums[mid];

            // compare the mid-value with target
            if (midValue == target) {
                return mid;
            }

            // if mid-value is not equal to target, check which side is sorted
            if (nums[left] <= midValue) {
                // if left side is well sorted, check where is the target
                if (nums[left] <= target && target < midValue) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // if right side is well sorted
                if (midValue < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
