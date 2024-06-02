package greedy.easy;

import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/assign-cookies/description/
// 455. Assign Cookies
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        PriorityQueue<Integer> greed = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> size = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < g.length; i++) {
            greed.add(g[i]);
        }

        for (int i = 0; i < s.length; i++) {
            size.add(s[i]);
        }

        int children = 0;

        while (!size.isEmpty() && !greed.isEmpty()) {
            int maxGreed = greed.poll();
            int maxSize = size.poll();

            if (maxSize >= maxGreed) {
                children++;
                size.add(maxSize - maxGreed);
            } else
                size.add(maxSize);
        }

        return children;
    }
}
