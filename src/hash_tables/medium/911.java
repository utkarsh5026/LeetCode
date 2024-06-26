package hash_tables.medium;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/online-election/description/
// 911. Online Election
class TopVotedCandidate {

    Map<Integer, Integer> timestamp;
    Map<Integer, Integer> voteCnt;
    int[] times;
    int[] leaders;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.timestamp = new HashMap<>();
        this.voteCnt = new HashMap<>();
        this.times = times;
        this.leaders = new int[times.length];

        int currentLeader = -1;
        for (int i = 0; i < persons.length; i++) {
            int vote = persons[i];
            voteCnt.put(vote, voteCnt.getOrDefault(vote, 0) + 1);
            if (currentLeader == -1 || voteCnt.get(vote) >= voteCnt.get(currentLeader)) {
                currentLeader = vote;
            }
            timestamp.put(times[i], currentLeader);
            leaders[i] = currentLeader;
        }
    }

    public int q(int t) {
        int recent = findRecentTime(t);
        return timestamp.get(recent);
    }

    int findRecentTime(int time) {
        int start = 0;
        int end = times.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (time < times[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }

        return times[Math.max(0, end)];
    }
}
