package heaps.medium;

import java.util.*;

// https://leetcode.com/problems/task-scheduler/description/
// 621. Task Scheduler
class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> frequency = new HashMap<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (char task : tasks) {
            frequency.put(task, frequency.getOrDefault(task, 0) + 1);
        }

        for (int cnt : frequency.values()) {
            maxHeap.add(cnt);
        }

        int timeTaken = 0;
        while (!maxHeap.isEmpty()) {
            int cycle = n + 1;

            List<Integer> more = new ArrayList<>();
            while (cycle > 0 && !maxHeap.isEmpty()) {
                int maxFreq = maxHeap.poll();
                if (maxFreq > 1)
                    more.add(maxFreq - 1);
                timeTaken++;
                cycle--;
            }

            for (int process : more) {
                maxHeap.add(process);
            }

            if (maxHeap.isEmpty())
                break;
            timeTaken += cycle;
        }

        return timeTaken;
    }
}