import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-07-04
 */
public class LC46_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> curPermutation, int[] nums) {
        // base case: if the cur permutation is complete, add it to the result
        if (curPermutation.size() == nums.length) {
            res.add(new ArrayList<>(curPermutation));
            return;
        }

        // try each number in the array
        for (int num : nums) {
            // skip if this number is already in the cur permutation
            if (curPermutation.contains(num)) continue;

            // add the number to the cur permutation
            curPermutation.add(num);

            // recursively build the rest of the permutation
            backtrack(res, curPermutation, nums);

            // backtrack: remove the last added number to try other possibilities
            curPermutation.remove(curPermutation.size() - 1);
        }
    }
}
