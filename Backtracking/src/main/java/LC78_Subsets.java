import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-07-03
 */
public class LC78_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> curSubset, int[] nums, int start) {
        // add the cur subset to the res
        res.add(new ArrayList<>(curSubset));

        // explore all possible elements to add to the cur subset
        for (int i = start; i < nums.length; i++) {
            // include the cur element
            curSubset.add(nums[i]);

            // recursively generate subsets with the cur element included
            backtrack(res, curSubset, nums, i+1);

            // backtrack, remove the cur element to explore other possibilities
            curSubset.remove(curSubset.size() - 1);
        }
    }
}
