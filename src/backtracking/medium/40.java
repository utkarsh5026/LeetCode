package backtracking.medium;

import java.util.*;

// https://leetcode.com/problems/combination-sum-ii/description/
// 40. Combination Sum II
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> combinations = new ArrayList<>();
        solve(0, candidates, target, 0, new ArrayList<>(), combinations);
        return combinations;
    }

    private void solve(int idx, int[] candidates, int target, int currentSum, List<Integer> candidatesSoFar,
            List<List<Integer>> combinations) {
        if (currentSum == target) {
            List<Integer> copy = new ArrayList<>(candidatesSoFar);
            combinations.add(copy);
            return;
        }

        if (idx >= candidates.length || currentSum > target)
            return;

        for (int i = idx; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i + 1])
                continue;
            candidatesSoFar.add(candidates[i]);
            solve(i + 1, candidates, target, currentSum + candidates[i], candidatesSoFar, combinations);
            candidatesSoFar.remove(candidatesSoFar.size() - 1);
        }
    }
}