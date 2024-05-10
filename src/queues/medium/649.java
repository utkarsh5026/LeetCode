package queues.medium;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/dota2-senate/description/
// 649. Dota2 Senate
class Solution {
    public String predictPartyVictory(String senate) {
        int candidates = senate.length();
        Deque<Integer> dire = new ArrayDeque<>();
        Deque<Integer> radiant = new ArrayDeque<>();

        for (int i = 0; i < senate.length(); i++) {
            char party = senate.charAt(i);
            if (party == 'R')
                radiant.add(i);
            else
                dire.add(i);
        }

        return determineWinner(dire, radiant, candidates);
    }

    private String determineWinner(Deque<Integer> dire, Deque<Integer> radiant, int candidates) {

        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int direPos = dire.pollFirst();
            int radiantPos = radiant.pollFirst();

            if (direPos < radiantPos)
                radiant.add(radiantPos + candidates);

            else if (radiantPos < direPos)
                dire.add(direPos + candidates);
        }

        return radiant.isEmpty() ? "Radiant" : "Dire";
    }
}