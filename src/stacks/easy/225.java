package stacks.easy;

import java.util.ArrayDeque;
import java.util.Queue;

// https://leetcode.com/problems/implement-stack-using-queues/description/
// 225. Implement Stack using Queues
class MyStack {

    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }

    public void push(int x) {
        q1.add(x);
        while (!q2.isEmpty()) {
            q1.add(q2.poll());
        }

        while (!q1.isEmpty()) {
            q2.add(q1.poll());
        }
    }

    public int pop() {
        return q2.poll();
    }

    public int top() {
        return q2.peek();
    }

    public boolean empty() {
        return q2.isEmpty();
    }
}
