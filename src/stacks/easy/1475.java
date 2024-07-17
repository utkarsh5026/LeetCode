package stacks.easy;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/description/
// 1475. Final Prices With a Special Discount in a Shop
class Solution {
    public int[] finalPrices(int[] prices) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i])
                prices[stack.pop()] -= prices[i];
            stack.push(i);
        }
        return prices;
    }
}