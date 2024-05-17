package sliding_window.medium;

import java.util.*;

// https://leetcode.com/problems/fruit-into-baskets/description/
// 904. Fruit Into Baskets
class Solution {
    public int totalFruit(int[] fruits) {
        int maxSum = 0;
        int left = 0;
        Map<Integer, Integer> fruitCount = new HashMap<>();

        for (int right = 0; right < fruits.length; right++) {
            fruitCount.put(fruits[right], fruitCount.getOrDefault(fruits[right], 0) + 1);

            while (fruitCount.size() > 2) {
                fruitCount.put(fruits[left], fruitCount.get(fruits[left]) - 1);
                if (fruitCount.get(fruits[left]) == 0) {
                    fruitCount.remove(fruits[left]);
                }
                left++;
            }

            maxSum = Math.max(maxSum, right - left + 1);
        }

        return maxSum;
    }
}
