package heaps.medium;

import java.util.*;

// https://leetcode.com/problems/seat-reservation-manager/description/
// 1845. Seat Reservation Manager
class SeatManager {

    PriorityQueue<Integer> pq;

    public SeatManager(int n) {
        this.pq = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            pq.add(i);
        }
    }

    public int reserve() {
        if (!pq.isEmpty())
            return pq.poll();
        return -1;
    }

    public void unreserve(int seatNumber) {
        pq.add(seatNumber);
    }
}
