package greedy.medium;

import java.util.*;

// https://leetcode.com/problems/maximize-happiness-of-selected-children/description/
// 3075. Maximize Happiness of Selected Children
class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        PriorityQueue<Integer> children = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < happiness.length; i++) {
            children.add(happiness[i]);
        }

        int turns = 0;

        long maxHappiness = 0;
        while (turns != k) {
            int mostHappy = children.poll() - turns;
            maxHappiness += determineHappy(mostHappy);
            turns++;
        }

        while (!children.isEmpty()) {
            int happy = children.poll() - turns;
            maxHappiness += determineHappy(happy);
        }

        return maxHappiness;
    }

    private int determineHappy(int happy) {
        return happy >= 0 ? happy : 0;
    }
}