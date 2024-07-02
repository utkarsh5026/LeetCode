package queues.medium;

import java.util.*;

// https://leetcode.com/problems/diagonal-traverse-ii/description/
// 1424. Diagonal Traverse II
class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] { 0, 0 });

        int[] result = new int[countItems(nums)];
        int idx = 0;
        while (!queue.isEmpty()) {
            int[] cord = queue.pollFirst();
            int x = cord[0];
            int y = cord[1];
            result[idx++] = nums.get(x).get(y);

            if (y == 0 && x < nums.size() - 1)
                queue.add(new int[] { x + 1, y });

            if (y < nums.get(x).size() - 1)
                queue.add(new int[] { x, y + 1 });
        }

        return result;
    }

    int countItems(List<List<Integer>> nums) {
        int size = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                size++;
            }
        }
        return size;
    }
}
