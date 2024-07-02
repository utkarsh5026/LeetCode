package heaps.medium;

import java.util.*;

// https://leetcode.com/problems/longest-happy-string/description/
// 1405. Longest Happy String
class Solution {
    class Char {
        char ch;
        int cnt;

        public Char(char ch, int cnt) {
            this.ch = ch;
            this.cnt = cnt;
        }
    }

    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Char> maxHeap = new PriorityQueue<>((x, y) -> y.cnt - x.cnt);
        if (a > 0)
            maxHeap.add(new Char('a', a));
        if (b > 0)
            maxHeap.add(new Char('b', b));
        if (c > 0)
            maxHeap.add(new Char('c', c));

        StringBuilder longest = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Char curr = maxHeap.poll();
            int len = longest.length();

            if (len >= 2 &&
                    longest.charAt(len - 1) == curr.ch &&
                    longest.charAt(len - 2) == curr.ch) {
                if (maxHeap.isEmpty()) {
                    break;
                }
                Char next = maxHeap.poll();
                longest.append(next.ch);
                if (--next.cnt > 0) {
                    maxHeap.add(next);
                }
                maxHeap.add(curr);
            } else {
                longest.append(curr.ch);
                if (--curr.cnt > 0) {
                    maxHeap.add(curr);
                }
            }
        }

        return longest.toString();
    }
}