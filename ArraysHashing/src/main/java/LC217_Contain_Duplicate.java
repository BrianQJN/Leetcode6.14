import java.util.HashSet;
import java.util.Set;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-05-18
 */
public class LC217_Contain_Duplicate {
    /**
     * @param nums an integer array
     * @return boolean - return true if any value appears at least twice in the array
     * @implSpec Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
     * @author Brian Qu
     * @since 2024-05-18 10:40
     */
    public boolean containsDuplicate(int[] nums) {
        // initialize an empty set to track elements appearance
        Set<Integer> seen = new HashSet<>();

        // traverse the array
        for (int num : nums) {
            // check if the number exists in the set
            if (!seen.add(num)) {
                return true;
            }
        }

        return false;
    }
}
