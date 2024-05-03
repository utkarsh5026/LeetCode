package arrays.easy;

// https://leetcode.com/problems/can-place-flowers/description/
// 605. Can Place Flowers
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0)
            return true;

        for (int i = 0; i < flowerbed.length; i++) {
            int status = flowerbed[i];
            int prevStatus = i > 0 ? flowerbed[i - 1] : 0;
            int nextStatus = i < flowerbed.length - 1 ? flowerbed[i + 1] : 0;
            if (status == 1 || prevStatus == 1 || nextStatus == 1)
                continue;

            n--;
            flowerbed[i] = 1;
            if (n == 0)
                return true;
        }

        return false;
    }
}