package heaps.easy;

import java.util.PriorityQueue;

// https://leetcode.com/problems/relative-ranks/description/
// 506. Relative Ranks
class Solution {
    class Score {
        int idx;
        int num;

        public Score(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }

    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Score> pq = new PriorityQueue<>((a, b) -> b.num - a.num);

        for (int i = 0; i < score.length; i++) {
            pq.add(new Score(score[i], i));
        }

        String[] result = new String[score.length];
        int rank = 0;

        while (!pq.isEmpty()) {
            Score s = pq.poll();
            switch (rank) {

                case 0:
                    result[s.idx] = "Gold Medal";
                    break;

                case 1:
                    result[s.idx] = "Silver Medal";
                    break;

                case 2:
                    result[s.idx] = "Bronze Medal";
                    break;

                default:
                    result[s.idx] = String.valueOf(rank + 1);
            }

            rank++;
        }

        return result;
    }
}