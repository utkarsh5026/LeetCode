package heaps.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/sequentially-ordinal-rank-tracker/description/
// 2102. Sequentially Ordinal Rank Tracker
class SORTracker {
    private static class Location {
        String name;
        int score;

        public Location(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    private static class LocationComparator implements Comparator<Location> {
        @Override
        public int compare(Location a, Location b) {
            if (a.score != b.score) {
                return b.score - a.score; // Higher score is better
            }
            return a.name.compareTo(b.name); // Lexicographically smaller name is better
        }
    }

    private PriorityQueue<Location> maxHeap; // Stores locations not yet returned
    private PriorityQueue<Location> minHeap; // Stores top i locations in reverse order
    private int queryCount;

    public SORTracker() {
        maxHeap = new PriorityQueue<>(new LocationComparator());
        minHeap = new PriorityQueue<>((a, b) -> {
            if (a.score != b.score) {
                return a.score - b.score;
            }
            return b.name.compareTo(a.name);
        });
        queryCount = 0;
    }

    public void add(String name, int score) {
        Location newLoc = new Location(name, score);
        if (!minHeap.isEmpty() && compare(newLoc, minHeap.peek()) < 0) {
            maxHeap.offer(minHeap.poll());
            minHeap.offer(newLoc);
        } else {
            maxHeap.offer(newLoc);
        }
    }

    public String get() {
        queryCount++;
        if (minHeap.size() < queryCount) {
            minHeap.offer(maxHeap.poll());
        }
        return minHeap.peek().name;
    }

    private int compare(Location a, Location b) {
        if (a.score != b.score) {
            return b.score - a.score;
        }
        return a.name.compareTo(b.name);
    }
}