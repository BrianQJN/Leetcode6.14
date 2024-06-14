import java.util.HashSet;
import java.util.Set;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-14
 */
public class LC217_Contains_Duplicate {
    /**
     * @param nums an integer array
     * @return boolean - return true if any value appears at least twice, otherwise return false
     * @implSpec Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
     * @author Brian Qu
     * @since 2024-06-14 14:30
     */
    public boolean containsDuplicate(int[] nums) {
        // initialize an empty set
        Set<Integer> uniqueElements = new HashSet<>();

        // iterate through the array
        for (int num : nums) {
            // for each value, check if it already exists in the set
            if (!uniqueElements.add(num)) {
                return true;
            }
        }

        // if we complete the iteration, return false
        return false;
    }
}
