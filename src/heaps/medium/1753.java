package heaps.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/maximum-score-from-removing-stones/description/
// 1753. Maximum Score From Removing Stones
class Solution {
    public int maximumScore(int a, int b, int c) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(a);
        pq.add(b);
        pq.add(c);

        int score = 0;

        while (!pq.isEmpty()) {
            int max = pq.poll();
            int secMax = pq.poll();

            if (max == 0 || secMax == 0)
                break;

            pq.add(max - 1);
            pq.add(secMax - 1);
            score++;
        }
        return score;
    }
}
