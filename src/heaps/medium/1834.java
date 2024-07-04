package heaps.medium;

import java.util.*;

// https://leetcode.com/problems/single-threaded-cpu/description/
// 1834. Single-Threaded CPU
class Solution {
    class Task {
        int entryTime;
        int processTime;
        int index;

        public Task(int entryTime, int processTime, int index) {
            this.entryTime = entryTime;
            this.processTime = processTime;
            this.index = index;
        }
    }

    public int[] getOrder(int[][] tasks) {
        PriorityQueue<Task> entryQueue = new PriorityQueue<>((a, b) -> a.entryTime - b.entryTime);

        for (int i = 0; i < tasks.length; i++) {
            entryQueue.add(new Task(tasks[i][0], tasks[i][1], i));
        }

        PriorityQueue<Task> scheduler = new PriorityQueue<>((a, b) -> {
            if (a.processTime == b.processTime)
                return a.index - b.index;
            return a.processTime - b.processTime;
        });

        int time = 0;
        int[] order = new int[tasks.length];
        int idx = 0;

        while (!entryQueue.isEmpty() || !scheduler.isEmpty()) {
            if (scheduler.isEmpty() && time < entryQueue.peek().entryTime) {
                time = entryQueue.peek().entryTime;
            }

            while (!entryQueue.isEmpty() && entryQueue.peek().entryTime <= time) {
                scheduler.offer(entryQueue.poll());
            }

            if (!scheduler.isEmpty()) {
                Task todo = scheduler.poll();
                order[idx++] = todo.index;
                time += todo.processTime;
            }
        }

        return order;
    }
}