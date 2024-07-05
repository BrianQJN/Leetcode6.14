import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-07-04
 */
public class LC90_SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> curSubset, int[] nums, int start) {
        // base case: add the cur subset to result
        res.add(new ArrayList<>(curSubset));

        // explore all possible elements to add to the cur subset
        for (int i = start; i < nums.length; i++) {
            // skip duplicates when not choosing the element
            if (i > start && nums[i] == nums[i-1]) continue;

            // include cur element
            curSubset.add(nums[i]);

            // recursively generate subsets with the cur element included
            backtrack(res, curSubset, nums, i+1);

            // backtrack
            curSubset.remove(curSubset.size() - 1);
        }
    }
}
