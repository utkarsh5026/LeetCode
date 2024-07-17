package graphs.medium;

import java.util.*;

// https://leetcode.com/problems/lexicographical-numbers/description/
// 386. Lexicographical Numbers
class Solution {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            dfs(i, 1, result, n);
        }
        return result;
    }

    void dfs(int start, int power, List<Integer> result, int limit) {
        if (start > limit)
            return;

        result.add(start);
        for (int i = 0; i <= 9; i++) {
            int num = (start * 10) + i;
            dfs(num, power + 1, result, limit);
        }
    }

}