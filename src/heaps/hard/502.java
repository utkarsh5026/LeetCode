package heaps.hard;

import java.util.*;

// https://leetcode.com/problems/ipo/description/
// 502. IPO
class Solution {

    class Project {
        int capital;
        int profit;

        public Project(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        PriorityQueue<Project> maxHeap = new PriorityQueue<>((a, b) -> {
            return (b.profit - b.capital) - (a.profit - a.capital);
        });

        int n = profits.length;
        for (int i = 0; i < n; i++) {
            maxHeap.add(new Project(capital[i], profits[i]));
        }

        while (k > 0 && !maxHeap.isEmpty()) {
            List<Project> skip = new ArrayList<>();
            while (!maxHeap.isEmpty() && maxHeap.peek().capital > w) {
                skip.add(maxHeap.poll());
            }

            if (maxHeap.isEmpty())
                return w;

            Project p = maxHeap.poll();
            w += p.profit - p.capital;

            for (int i = 0; i < skip.size(); i++) {
                maxHeap.add(skip.get(i));
            }
        }

        return w;
    }
}