package stacks.medium;

import java.util.Arrays;

// https://leetcode.com/problems/design-a-stack-with-increment-operation/description/
// 1381. Design a Stack With Increment Operations
class CustomStack {

    int[] stack;
    int back;

    public CustomStack(int maxSize) {
        this.stack = new int[maxSize];
        Arrays.fill(stack, -1);
        this.back = 0;
    }

    public void push(int x) {
        if (this.back < this.stack.length)
            this.stack[back++] = x;
    }

    public int pop() {
        if (back == 0)
            return -1;

        int idx = back - 1;
        int last = this.stack[idx];
        this.stack[idx] = -1;
        back--;
        return last;
    }

    public void increment(int k, int val) {
        for (int i = 0; i < Math.min(k, back); i++) {
            this.stack[i] += val;
        }
    }
}