package queues.easy;

import java.util.*;

// https://leetcode.com/problems/number-of-recent-calls/description/
// 933. Number of Recent Calls
class RecentCounter {

    private Deque<Integer> calls;

    public RecentCounter() {
        this.calls = new ArrayDeque<>();
    }

    public int ping(int t) {
        int rangeStart = t - 3000;
        calls.add(t);
        while (!calls.isEmpty()) {
            int first = calls.peekFirst();
            if (first >= rangeStart)
                break;
            calls.pollFirst();
        }
        return calls.size();
    }
}