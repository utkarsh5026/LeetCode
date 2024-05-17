package backtracking.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/permutations-ii/description/
// 47. Permutations II
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort the array to easily handle duplicates
        boolean[] used = new boolean[nums.length]; // To keep track of used numbers in each permutation
        backtrack(nums, new ArrayList<>(), used, result);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> currentPerm, boolean[] used, List<List<Integer>> result) {
        if (currentPerm.size() == nums.length) {
            result.add(new ArrayList<>(currentPerm));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue; // Skip if the number is already used or if it's a duplicate that hasn't been
                          // used yet
            }
            currentPerm.add(nums[i]); // Add the current number to the permutation
            used[i] = true; // Mark the number as used
            backtrack(nums, currentPerm, used, result); // Recursively generate permutations
            currentPerm.remove(currentPerm.size() - 1); // Backtrack: remove the last added number
            used[i] = false; // Mark the number as unused for the next iteration
        }
    }
}
