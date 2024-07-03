package heaps.medium;

import java.util.*;

// https://leetcode.com/problems/construct-string-with-repeat-limit/description/
// 2182. Construct String With Repeat Limit
class Solution {

    class CharCount {
        char ch;
        int cnt;

        public CharCount(char ch, int cnt) {
            this.ch = ch;
            this.cnt = cnt;
        }
    }

    public String repeatLimitedString(String s, int repeatLimit) {
        Map<Character, Integer> frequency = new HashMap<>();
        for (char ch : s.toCharArray()) {
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<CharCount> maxHeap = new PriorityQueue<>((a, b) -> Character.compare(b.ch, a.ch));

        for (Map.Entry<Character, Integer> cnt : frequency.entrySet()) {
            maxHeap.add(new CharCount(cnt.getKey(), cnt.getValue()));
        }

        StringBuilder limited = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            CharCount last = maxHeap.poll();

            if (limited.length() == 0 || limited.charAt(limited.length() - 1) != last.ch) {
                appendWithLimit(maxHeap, limited, last, repeatLimit, last.cnt);
                continue;
            }

            if (maxHeap.isEmpty())
                break;

            CharCount next = maxHeap.poll();
            appendWithLimit(maxHeap, limited, next, repeatLimit, 1);
            maxHeap.add(last);
        }

        return limited.toString();
    }

    private void appendWithLimit(PriorityQueue<CharCount> maxHeap, StringBuilder limited, CharCount curr, int limit,
            int canRemove) {
        int remove = Math.min(canRemove, limit);
        for (int i = 0; i < remove; i++) {
            limited.append(curr.ch);
        }

        curr.cnt -= remove;
        if (curr.cnt > 0)
            maxHeap.add(curr);
    }
}