package queues.medium;

import java.util.*;

// https://leetcode.com/problems/minimum-operations-to-convert-number/description/
// 2059. Minimum Operations to Convert Number
class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(start);
        int operations = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                if (current == goal) {
                    return operations;
                }

                if (current < 0 || current > 1000 || visited.contains(current))
                    continue;

                visited.add(current);

                for (int num : nums) {
                    queue.offer(current + num);
                    queue.offer(current - num);
                    queue.offer(current ^ num);
                }
            }
            operations++;
        }

        return -1;
    }
}
