package arrays.easy;

import java.util.*;

// https://leetcode.com/problems/height-checker/description/
// 1051. Height Checker
class Solution {
    public int heightChecker(int[] heights) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int height : heights) {
            count.put(height, count.getOrDefault(height, 0) + 1);
        }

        List<Integer> distinct = new ArrayList<>(count.keySet());

        Collections.sort(distinct);

        int idx = 0;
        int notMatch = 0;
        for (int height : distinct) {
            int cnt = count.get(height);
            for (int i = 0; i < cnt; i++) {
                if (height != heights[idx])
                    notMatch++;
                idx++;
            }
        }

        return notMatch;
    }
}
