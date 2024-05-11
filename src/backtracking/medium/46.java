package backtracking.medium;

import java.util.*;

// https://leetcode.com/problems/permutations/description/
// 46. Permutations
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            solve(i, nums, new ArrayList<>(), permutations, new HashSet<>());
        }

        return permutations;
    }

    private void solve(int idx, int[] nums, List<Integer> pathSoFar, List<List<Integer>> permutations,
            Set<Integer> numSet) {
        numSet.add(nums[idx]);
        pathSoFar.add(nums[idx]);

        if (pathSoFar.size() == nums.length) {
            List<Integer> copy = new ArrayList<>(pathSoFar);
            permutations.add(copy);
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (i == idx || numSet.contains(nums[i]))
                    continue;
                solve(i, nums, pathSoFar, permutations, numSet);
            }
        }
        numSet.remove(nums[idx]);
        pathSoFar.remove(pathSoFar.size() - 1);
    }
}