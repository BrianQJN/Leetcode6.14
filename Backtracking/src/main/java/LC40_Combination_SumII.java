import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-07-05
 */
public class LC40_Combination_SumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), 0, target, candidates);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> curCombination, int start, int remainingTarget, int[] candidates) {
        // base case: if remaining target is 0, we found a combination
        if (remainingTarget == 0) {
            res.add(new ArrayList<>(curCombination));
            return;
        }

        // explore possibilities
        for (int i = start; i < candidates.length; i++) {
            // if the cur candidate is greater than the remaining target, stop exploring
            if (candidates[i] > remainingTarget) break;

            // skip duplicates when not choosing the element
            if (i > start && candidates[i] == candidates[i-1]) continue;

            // include the cur element
            curCombination.add(candidates[i]);

            // recursively explore with the updated remaining target
            backtrack(res, curCombination, i+1, remainingTarget - candidates[i], candidates);

            // backtrack: remove the last added element
            curCombination.remove(curCombination.size() - 1);
        }
    }
}
