package stacks.easy;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/description/
// 1700. Number of Students Unable to Eat Lunch
class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Deque<Integer> sand = new ArrayDeque<>();
        Deque<Integer> studentQueue = new ArrayDeque<>();

        for (int i = 0; i < students.length; i++) {
            studentQueue.addLast(students[i]);
            sand.addFirst(sandwiches[i]);
        }

        int cnt = 0;
        int repeat = 0;
        while (!sand.isEmpty() && repeat != studentQueue.size()) {
            int top = sand.peekLast();
            int student = studentQueue.pollFirst();

            if (student == top) {
                sand.pollLast();
                cnt++;
                repeat = 0;
            } else {
                studentQueue.addLast(student);
                repeat++;
            }
        }

        return students.length - cnt;
    }
}