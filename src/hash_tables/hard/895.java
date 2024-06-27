package hash_tables.hard;

import java.util.*;

// https://leetcode.com/problems/maximum-frequency-stack/description/
// 895. Maximum Frequency Stacks
class FreqStack {
    private Map<Integer, Integer> freqMap;
    private Map<Integer, Stack<Integer>> freqStackMap;
    private int maxFreq;

    public FreqStack() {
        freqMap = new HashMap<>();
        freqStackMap = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int val) {
        // Update the frequency map
        int freq = freqMap.getOrDefault(val, 0) + 1;
        freqMap.put(val, freq);

        // Update the max frequency
        if (freq > maxFreq) {
            maxFreq = freq;
        }

        // Add the value to the stack corresponding to its frequency
        freqStackMap.computeIfAbsent(freq, k -> new Stack<>()).push(val);
    }

    public int pop() {
        // Get the stack corresponding to the max frequency
        Stack<Integer> stack = freqStackMap.get(maxFreq);
        int val = stack.pop();

        // Update the frequency map
        freqMap.put(val, freqMap.get(val) - 1);

        if (stack.isEmpty()) {
            maxFreq--;
        }

        return val;
    }
}
