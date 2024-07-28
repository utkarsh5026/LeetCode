package queues.hard;

import java.util.*;

// https://leetcode.com/problems/sliding-puzzle/description/
// 773. Sliding Puzzle
class Solution {
    private static final int[][] DIRECTIONS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    private static final String TARGET = "123450";

    public int slidingPuzzle(int[][] board) {
        String start = boardToString(board);
        if (start.equals(TARGET))
            return 0;

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);

        int moves = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(TARGET))
                    return moves;

                int zeroIndex = current.indexOf('0');
                int row = zeroIndex / 3;
                int col = zeroIndex % 3;

                for (int[] dir : DIRECTIONS) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    if (newRow >= 0 && newRow < 2 && newCol >= 0 && newCol < 3) {
                        String next = swap(current, zeroIndex, newRow * 3 + newCol);
                        if (!visited.contains(next)) {
                            queue.offer(next);
                            visited.add(next);
                        }
                    }
                }
            }
            moves++;
        }
        return -1;
    }

    private String boardToString(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : board) {
            for (int num : row) {
                sb.append(num);
            }
        }
        return sb.toString();
    }

    private String swap(String s, int i, int j) {
        char[] chars = s.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }
}