package arrays.easy;

import java.util.*;

// https://leetcode.com/problems/h-index/description/
// 274. H-Index
class Solution {
    public int hIndex(int[] citations) {
        Map<Integer, Integer> citCount = new HashMap<>();
        for (int citation : citations) {
            citCount.put(citation, citCount.getOrDefault(citation, 0) + 1);
        }

        return getHIndex(citCount);
    }

    int getHIndex(Map<Integer, Integer> count) {
        List<Integer> citations = new ArrayList<>(count.keySet());
        Collections.sort(citations, Comparator.reverseOrder());

        Map<Integer, Integer> hIdxCount = new HashMap<>();
        int atLeast = 0;
        for (int citation : citations) {
            atLeast += count.get(citation);
            hIdxCount.put(citation, atLeast);
        }

        int hIndex = 0;
        for (int citation : citations) {
            if (citation <= hIdxCount.get(citation)) {
                hIndex = Math.max(hIndex, citation);
            } else {
                hIndex = Math.max(hIndex, hIdxCount.get(citation));
            }
        }

        return hIndex;
    }
}