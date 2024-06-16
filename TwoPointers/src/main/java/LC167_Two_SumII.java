/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-16
 */
public class LC167_Two_SumII {
    public int[] twoSum(int[] numbers, int target) {
        // initialize two pointers
        int left = 0, right = numbers.length - 1;

        // traverse through the array
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            // if cur sum is greater than target, move right pointer left
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++; // if cur sum is less than target, move left pointer right
            } else {
                return new int[]{left + 1, right + 1};
            }
        }

        throw new IllegalArgumentException("No solution");
    }
}
