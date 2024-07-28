package graphs.medium;

import java.util.*;

// https://leetcode.com/problems/jump-game-iii/description/
// 1306. Jump Game III
class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (arr[current] == 0) {
                return true;
            }

            int forward = current + arr[current];
            int backward = current - arr[current];

            // Check forward jump
            if (forward < n && !visited.contains(forward)) {
                queue.offer(forward);
                visited.add(forward);
            }

            // Check backward jump
            if (backward >= 0 && !visited.contains(backward)) {
                queue.offer(backward);
                visited.add(backward);
            }
        }

        return false;
    }
}