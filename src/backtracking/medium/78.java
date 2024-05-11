package backtracking.medium;

import java.util.*;

// https://leetcode.com/problems/subsets/description/
// 78. Subsets

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        solve(0, nums, new ArrayList<>(), result);
        return result;
    }

    void solve(int idx, int[] nums, List<Integer> psf, List<List<Integer>> result) {

        result.add(new ArrayList<>(psf));
        for (int i = idx; i < nums.length; i++) {
            psf.add(nums[i]);
            solve(i + 1, nums, psf, result);
            psf.remove(psf.size() - 1);
        }
    }

}