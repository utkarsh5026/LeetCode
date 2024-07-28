package graphs.medium;

import java.util.*;

// https://leetcode.com/problems/numbers-with-same-consecutive-differences/description/
// 967. Numbers With Same Consecutive Differences
class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> result = new ArrayList<>();

        if (n == 1) {
            for (int i = 0; i <= 9; i++) {
                result.add(i);
            }
            return listToArray(result);
        }

        for (int i = 1; i <= 9; i++) {
            dfs(n - 1, k, i, result);
        }

        return listToArray(result);
    }

    private void dfs(int n, int k, int num, List<Integer> result) {
        if (n == 0) {
            result.add(num);
            return;
        }

        int lastDigit = num % 10;
        if (k > 0 && lastDigit + k < 10)
            dfs(n - 1, k, num * 10 + (lastDigit + k), result);

        if (k > 0 && lastDigit - k >= 0)
            dfs(n - 1, k, num * 10 + (lastDigit - k), result);

        // If k == 0, we only need to add the same digit
        if (k == 0)
            dfs(n - 1, k, num * 10 + lastDigit, result);

    }

    private int[] listToArray(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}