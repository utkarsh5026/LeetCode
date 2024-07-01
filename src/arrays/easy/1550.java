package arrays.easy;

// https://leetcode.com/problems/three-consecutive-odds/
//  1550. Three Consecutive Odds
class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] % 2;
        }

        int currSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (currSum == 3)
                return true;

            int curr = arr[i];
            currSum = curr == 1 ? currSum + 1 : 0;
        }

        return currSum == 3;
    }
}