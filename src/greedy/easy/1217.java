package greedy.easy;

// https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/description/
// 1217. Minimum Cost to Move Chips to The Same Position
class Solution {
    public int minCostToMoveChips(int[] position) {
        int evenCount = 0;
        int oddCount = 0;

        for (int pos : position) {
            if (pos % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        return Math.min(evenCount, oddCount);
    }
}
