package heaps.medium;

import java.util.*;

import java.util.*;

// https://leetcode.com/problems/exam-room/description
// 855. Exam Rooms
class ExamRoom {

    private TreeSet<Integer> occupied;
    private int size;

    public ExamRoom(int n) {
        occupied = new TreeSet<>();
        size = n;
    }

    public int seat() {
        if (occupied.isEmpty()) {
            occupied.add(0);
            return 0;
        }

        // Initialize the position to seat at and the maximum distance
        int seatToSit = 0;
        int maxDist = occupied.first(); // distance from the start to the first student

        Integer prev = null;
        for (int pos : occupied) {
            if (prev != null) {
                int dist = (pos - prev) / 2;
                if (dist > maxDist) {
                    maxDist = dist;
                    seatToSit = prev + dist;
                }
            }
            prev = pos;
        }

        // Check the distance from the last occupied seat to the end of the room
        if (size - 1 - occupied.last() > maxDist) {
            seatToSit = size - 1;
        }

        // Add the chosen seat to occupied seats
        occupied.add(seatToSit);
        return seatToSit;
    }

    public void leave(int p) {
        occupied.remove(p);
    }

}
