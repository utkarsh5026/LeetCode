package backtracking.medium;

import java.util.*;

// https://leetcode.com/problems/combination-sum/description/
// 39. Combination Sum
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        solve(0, candidates, target, 0, new ArrayList<>(), combinations);
        return combinations;
    }

    private void solve(int idx, int[] candidates, int target, int currSum, List<Integer> numsSoFar,
            List<List<Integer>> combinations) {
        if (target == currSum) {
            List<Integer> copied = new ArrayList<>(numsSoFar);
            combinations.add(copied);
            return;
        }

        if (idx >= candidates.length || currSum > target)
            return;

        int curr = candidates[idx];

        numsSoFar.add(curr);
        solve(idx, candidates, target, currSum + curr, numsSoFar, combinations);
        numsSoFar.remove(numsSoFar.size() - 1);
        solve(idx + 1, candidates, target, currSum + curr, numsSoFar, combinations);

    }
}