import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-07-03
 */
public class LC39_Combination_Sum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> curCombine, int[] candidates, int remainingTarget, int start) {
        // base case: if the remaining target is 0, means we found a valid combination
        if (remainingTarget == 0) {
            res.add(new ArrayList<>(curCombine));
            return;
        }

        // explore candidates
        for (int i = start; i < candidates.length; i++) {
            // if the cur candidate is greater than the remaining target, skip
            if (candidates[i] > remainingTarget) continue;

            // include the cur candidate
            curCombine.add(candidates[i]);

            // recursively explore with the updated remaining target
            // we pass index i as the new start to allow reusing the cur element
            backtrack(res, curCombine, candidates, remainingTarget - candidates[i], i);

            // backtrack, exclude the cur candidate
            curCombine.remove(curCombine.size() - 1);
        }
    }
}
