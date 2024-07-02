package heaps.medium;

import java.util.*;
// https:// leetcode.com/problems/reorganize-string/description/
// 767. Reorganize String

class Solution {

    class CharCount {
        char ch;
        int cnt;

        public CharCount(char ch, int cnt) {
            this.ch = ch;
            this.cnt = cnt;
        }
    }

    public String reorganizeString(String s) {
        Map<Character, Integer> frequency = new HashMap<>();
        for (char ch : s.toCharArray()) {
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<CharCount> maxHeap = new PriorityQueue<>((a, b) -> (b.cnt - a.cnt));

        for (Map.Entry<Character, Integer> cnt : frequency.entrySet()) {
            maxHeap.add(new CharCount(cnt.getKey(), cnt.getValue()));
        }

        StringBuilder reorganized = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            CharCount curr = maxHeap.poll();
            if (reorganized.length() == 0 || reorganized.charAt(reorganized.length() - 1) != curr.ch) {
                reorganized.append(curr.ch);
                if (curr.cnt > 1) {
                    curr.cnt--;
                    maxHeap.add(curr);
                }
                continue;
            }

            if (maxHeap.isEmpty())
                return "";

            CharCount next = maxHeap.poll();
            reorganized.append(next.ch);

            if (next.cnt > 1) {
                next.cnt--;
                maxHeap.add(next);
            }

            maxHeap.add(curr);
        }

        return reorganized.toString();
    }
}