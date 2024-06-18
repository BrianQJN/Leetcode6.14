/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-18
 */
public class LC_153_Find_Minimum_in_Rotated_Sorted_Array {
    public int findMin(int[] nums) {
        // initialize two pointers
        int n = nums.length;
        int left = 0, right = n - 1;
        int mid;

        // shrink the interval
        while (left < right) {
            mid = left + (right - left) / 2;

            // compare middle value with rightmost element
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }
}
