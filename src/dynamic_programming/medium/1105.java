package dynamic_programming.medium;

import java.util.*;

// https://leetcode.com/problems/filling-bookcase-shelves/description/
// 1105. Filling Bookcase Shelves
class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        return solve(0, books, new HashMap<>(), shelfWidth);
    }

    int solve(int idx, int[][] books, Map<Integer, Integer> memo, int shelfWidth) {

        if (idx == books.length)
            return 0;

        if (memo.containsKey(idx))
            return memo.get(idx);

        int result = Integer.MAX_VALUE;
        int width = 0;
        int height = 0;

        for (int j = idx; j < books.length; j++) {
            int newWidth = width + books[j][0];
            if (newWidth > shelfWidth)
                break;

            width += books[j][0];
            height = Math.max(height, books[j][1]);
            result = Math.min(result, height + solve(j + 1, books, memo, shelfWidth));
        }

        memo.put(idx, result);
        return result;
    }
}