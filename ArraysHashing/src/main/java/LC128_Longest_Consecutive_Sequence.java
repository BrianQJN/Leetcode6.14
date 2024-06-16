import java.util.HashSet;
import java.util.Set;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-16
 */
public class LC128_Longest_Consecutive_Sequence {
    public int longestConsecutive(int[] nums) {
        // create a set to store the elements
        Set<Integer> numSet = new HashSet<>();
        int maxLength = 0;

        for (int num : nums) {
            numSet.add(num);
        }

        // iterate through the array
        for (int num : numSet) {
            // check if cur num is the start of a sequence
            if (!numSet.contains(num - 1)) {
                int curNum = num;
                int curLength = 1;

                while (numSet.contains(curNum + 1)) {
                    curNum += 1;
                    curLength += 1;
                }

                // update the maximum sequence length
                maxLength = Math.max(curLength, maxLength);
            }
        }

        return maxLength;
    }
}
