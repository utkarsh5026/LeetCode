package dynamic_programming.medium;

import java.util.*;

// https://leetcode.com/problems/house-robber/description/
// 198. House Robber
class Solution {
    public int rob(int[] nums) {
        int[] moneyLooted = new int[nums.length];
        Arrays.fill(moneyLooted, -1);
        return robHouses(nums.length - 1, nums, moneyLooted);
    }

    private int robHouses(int house, int[] houses, int[] moneyLooted) {
        if (house < 0)
            return 0;

        if (moneyLooted[house] != -1)
            return moneyLooted[house];

        int rob = robHouses(house - 2, houses, moneyLooted);
        int robNext = robHouses(house - 1, houses, moneyLooted);

        moneyLooted[house] = Math.max(rob + houses[house], robNext);
        return moneyLooted[house];
    }
}
