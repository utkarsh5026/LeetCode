package graphs.medium;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/minimum-cost-for-tickets/description/
// 983. Minimum Cost For Tickets
class Solution {
    private int[] costs;
    private Integer[] memo;
    private Set<Integer> daySet;

    public int mincostTickets(int[] days, int[] costs) {
        this.costs = costs;
        this.memo = new Integer[366];
        this.daySet = new HashSet<>();

        // Add all travel days to the set for quick lookup
        for (int day : days) {
            daySet.add(day);
        }

        return minCost(1);
    }

    private int minCost(int day) {
        if (day > 365) {
            return 0;
        }

        if (memo[day] != null) {
            return memo[day];
        }

        if (daySet.contains(day)) {
            int cost1 = minCost(day + 1) + costs[0];
            int cost7 = minCost(day + 7) + costs[1];
            int cost30 = minCost(day + 30) + costs[2];
            memo[day] = Math.min(cost1, Math.min(cost7, cost30));
        } else {
            memo[day] = minCost(day + 1);
        }

        return memo[day];
    }
}
