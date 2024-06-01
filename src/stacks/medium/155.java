package stacks.medium;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/min-stack/description/
// 155. Min Stack
class MinStack {

    class Node {
        int val;
        int tillMin;

        public Node(int val, int tillMin) {
            this.tillMin = tillMin;
            this.val = val;
        }
    }

    Deque<Node> stack;

    public MinStack() {
        stack = new ArrayDeque<>();
    }

    public void push(int val) {

        if (stack.isEmpty())
            stack.add(new Node(val, val));

        else
            stack.add(new Node(val, Math.min(stack.peekLast().tillMin, val)));
    }

    public void pop() {
        if (!stack.isEmpty())
            stack.pollLast();
    }

    public int top() {
        return stack.peekLast().val;
    }

    public int getMin() {
        return stack.peekLast().tillMin;
    }
}