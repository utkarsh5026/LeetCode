package arrays.medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/my-calendar-i/description/
// 729. My Calendar I
class MyCalendar {

    List<int[]> bookings;

    public MyCalendar() {
        bookings = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        int[] arr = { start, end };
        if (bookings.isEmpty())
            bookings.add(arr);

        for (int i = 0; i < bookings.size(); i++) {
            int[] booking = bookings.get(i);
            if (start < booking[1] || end < booking[0])
                return false;

        }
        return true;
    }
}