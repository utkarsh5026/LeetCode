package arrays.easy;

import java.util.*;

// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/description
// 1431. Kids With the Greatest Number of Candies
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandy = getMaxCandy(candies);
        List<Boolean> greatest = new ArrayList<>();

        for (int i = 0; i < candies.length; i++) {
            boolean isGreatest = candies[i] + extraCandies >= maxCandy;
            greatest.add(isGreatest);
        }

        return greatest;
    }

    private int getMaxCandy(int[] candies) {
        int maxCandy = Integer.MIN_VALUE;
        for (int candy : candies) {
            maxCandy = Math.max(candy, maxCandy);
        }
        return maxCandy;
    }

}