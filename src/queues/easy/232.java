package queues.easy;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/implement-queue-using-stacks/description/
// 232. Implement Queue using Stacks
class MyQueue {

    Deque<Integer> s1;
    Deque<Integer> s2;

    public MyQueue() {
        s1 = new ArrayDeque<>();
        s2 = new ArrayDeque<>();
    }

    public void push(int x) {
        s1.addLast(x);
    }

    public int pop() {
        moveS1ToS2IfNeeded();
        return s2.pollLast();
    }

    public int peek() {
        moveS1ToS2IfNeeded();
        return s2.peekLast();
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    private void moveS1ToS2IfNeeded() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.addLast(s1.pollLast());
            }
        }
    }

}
