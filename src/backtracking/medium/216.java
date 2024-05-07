package backtracking.medium;

import java.util.*;

// https://leetcode.com/problems/combination-sum-iii/description/
// 216. Combination Sum III
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> combinations = new ArrayList<>();
        solve(1, k, n, 0, new ArrayList<>(), combinations);
        return combinations;
    }

    private void solve(int curr, int limit, int target, int currSum, List<Integer> numsSoFar,
            List<List<Integer>> combinations) {

        if (numsSoFar.size() > limit)
            return;

        if (currSum == target && numsSoFar.size() == limit) {
            List<Integer> copy = new ArrayList<>(numsSoFar);
            combinations.add(copy);
            return;
        }

        for (int i = curr; i < 10; i++) {
            numsSoFar.add(i);
            solve(i + 1, limit, target, currSum + i, numsSoFar, combinations);
            numsSoFar.remove(numsSoFar.size() - 1);
        }
    }
}
