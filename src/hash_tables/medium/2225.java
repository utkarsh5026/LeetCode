package hash_tables.medium;

import java.util.*;

// https://leetcode.com/problems/find-players-with-zero-or-one-losses/description/
// 2225. Find Players With Zero or One Losses
class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> looseCnt = new HashMap<>();

        for (int[] match : matches) {
            int winner = match[0];
            int looser = match[1];

            looseCnt.computeIfAbsent(winner, cnt -> 0);
            looseCnt.computeIfAbsent(looser, cnt -> 0);

            looseCnt.put(looser, looseCnt.get(looser) + 1);
        }

        List<Integer> lostOnlyOnce = new ArrayList<>();
        List<Integer> lostNone = new ArrayList<>();
        for (Map.Entry<Integer, Integer> player : looseCnt.entrySet()) {
            int lost = player.getValue();
            if (lost == 1)
                lostOnlyOnce.add(player.getKey());

            else if (lost == 0)
                lostNone.add(player.getKey());
        }

        List<List<Integer>> result = new ArrayList<>();
        Collections.sort(lostOnlyOnce);
        Collections.sort(lostNone);
        result.add(lostNone);
        result.add(lostOnlyOnce);
        return result;
    }
}