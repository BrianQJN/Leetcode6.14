import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-16
 */
public class LC15_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        // initialize the res list and sort the array
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        // iterate through the array nums
        for (int i = 0; i < nums.length - 2; i++) {
            // if the num is new one
            if (i == 0 || nums[i] != nums[i-1]) {
                // initialize the two pointers and sum
                int sum = -nums[i];
                int left = i + 1, right = nums.length - 1;

                // iterate through the new interval to find the sum
                while (left < right) {
                    int curSum = nums[left] + nums[right];
                    if (curSum > sum) {
                        right--;
                    } else if (curSum < sum) {
                        left++;
                    } else {
                        // add the combinations to result array
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                        // to avoid duplicates, move both of left and right to next number
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        // move to the new number
                        left++;
                        right--;
                    }
                }
            }
        }

        return res;
    }
}
