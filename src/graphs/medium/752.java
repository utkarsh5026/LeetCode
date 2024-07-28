package graphs.medium;

import java.util.*;

// https://leetcode.com/problems/open-the-lock/description/
// 752. Open the Lock
class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        String start = "0000";
        if (dead.contains(start))
            return -1;

        queue.offer(start);
        visited.add(start);
        int turns = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(target))
                    return turns;

                List<String> neighbors = getNeighbors(current);
                for (String neighbor : neighbors) {
                    if (!visited.contains(neighbor) && !dead.contains(neighbor)) {
                        queue.offer(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
            turns++;
        }

        return -1;
    }

    private List<String> getNeighbors(String code) {
        List<String> neighbors = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int digit = code.charAt(i) - '0';
            for (int change : new int[] { -1, 1 }) {
                int newDigit = (digit + change + 10) % 10;
                String neighbor = code.substring(0, i) + newDigit + code.substring(i + 1);
                neighbors.add(neighbor);
            }
        }
        return neighbors;
    }
}