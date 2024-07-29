package queues.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/reveal-cards-in-increasing-order/description/
// 950. Reveal Cards In Increasing Order
class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) q.add(i);
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[q.poll()] = deck[i];
            q.add(q.poll());
        }
        return res;
    }
}