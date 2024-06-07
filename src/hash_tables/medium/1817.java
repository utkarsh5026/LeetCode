package hash_tables.medium;

import java.util.*;

// https://leetcode.com/problems/finding-the-users-active-minutes/description/
// 1817. Finding the Users Active Minutes
class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] uam = new int[k];
        Map<Integer, Set<Integer>> minutes = new HashMap<>();
        for (int[] log : logs) {
            int user = log[0];
            int time = log[1];

            minutes.computeIfAbsent(user, times -> new HashSet<>());
            minutes.get(user).add(time);
        }

        for (Map.Entry<Integer, Set<Integer>> user : minutes.entrySet()) {
            int activeMinutes = user.getValue().size();
            uam[activeMinutes - 1]++;
        }
        return uam;
    }
}
