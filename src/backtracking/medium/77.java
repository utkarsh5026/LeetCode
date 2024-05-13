package backtracking.medium;

import java.util.*;

// https://leetcode.com/problems/combinations/description/
// 77. Combinations
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> solutions = new ArrayList<>();
        solve(1, n, k, new ArrayList<>(), solutions);
        return solutions;
    }

    void solve(int curr, int end, int size, List<Integer> combination, List<List<Integer>> solutions) {
        if (combination.size() == size) {
            List<Integer> copy = new ArrayList<>(combination);
            solutions.add(copy);
            return;
        }
        for (int i = curr; i <= end - size + combination.size() + 1; i++) {
            combination.add(i);
            solve(i + 1, end, size, combination, solutions);
            combination.remove(combination.size() - 1);
        }
    }
}