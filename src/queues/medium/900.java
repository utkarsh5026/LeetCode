package queues.medium;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/rle-iterator/description/
// 900. RLE Iterator
class RLEIterator {
    private Queue<int[]> queue;

    public RLEIterator(int[] encoding) {
        queue = new LinkedList<>();
        for (int i = 0; i < encoding.length; i += 2) {
            int count = encoding[i];
            int value = encoding[i + 1];
            if (count > 0) {
                queue.offer(new int[] { count, value });
            }
        }
    }

    public int next(int n) {
        while (!queue.isEmpty() && n > 0) {
            int[] front = queue.peek();
            if (n >= front[0]) {
                n -= front[0];
                queue.poll();
            } else {
                front[0] -= n;
                n = 0;
            }
            if (n == 0) {
                return front[1];
            }
        }
        return -1;
    }
}
