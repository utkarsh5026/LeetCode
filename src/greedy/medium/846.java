package greedy.medium;

import java.util.*;

// https://leetcode.com/problems/hand-of-straights/description/
// 846. Hand of Straights
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        if (hand.length % groupSize != 0)
            return false;

        Map<Integer, Integer> handCnt = new HashMap<>();
        for (int i = 0; i < hand.length; i++) {
            int h = hand[i];
            handCnt.put(h, handCnt.getOrDefault(h, 0) + 1);
        }

        while (!handCnt.keySet().isEmpty()) {
            int min = Collections.min(handCnt.keySet());
            int cnt = 0;
            while (cnt < groupSize) {
                if (!handCnt.containsKey(min))
                    return false;

                handCnt.put(min, handCnt.get(min) - 1);
                if (handCnt.get(min) == 0)
                    handCnt.remove(min);
                cnt++;
                min++;
            }
        }
        return true;
    }
}
