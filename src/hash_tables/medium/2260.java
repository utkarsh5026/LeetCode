package hash_tables.medium;

import java.util.*;

// https://leetcode.com/problems/minimum-consecutive-cards-to-pick-up/description/
// 2260. Minimum Consecutive Cards to Pick Up
class Solution {
    public int minimumCardPickup(int[] cards) {
        Map<Integer, Integer> cardsIdx = new HashMap<>();

        int minGap = Integer.MAX_VALUE;
        for (int i = 0; i < cards.length; i++) {
            int card = cards[i];
            if (cardsIdx.containsKey(card)) {
                int gap = i - cardsIdx.get(card) - 1;
                minGap = Math.min(gap, minGap);
            }

            cardsIdx.put(card, i);
        }

        return minGap == Integer.MAX_VALUE ? -1 : minGap;
    }
}