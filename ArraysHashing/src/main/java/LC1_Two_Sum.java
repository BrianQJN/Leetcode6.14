import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-14
 */
public class LC1_Two_Sum {
    public int[] twoSum(int[] nums, int target) {
        // initialize a HashMap to store the number and its index
        Map<Integer, Integer> numIndex = new HashMap<>();

        // iterate through array nums
        for (int i = 0; i < nums.length; i++) {
            int remaining = target - nums[i];

            // check if the remaining exists in the hashmap
            if (numIndex.containsKey(remaining)) {
                return new int[]{numIndex.get(remaining), i};
            }

            // if not found, add the cur number and index to the hashmap
            numIndex.put(nums[i], i);
        }

        throw new IllegalArgumentException("No Solution");
    }
}
