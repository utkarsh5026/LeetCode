package greedy.medium;

// https://leetcode.com/problems/gas-station/description/
// 134. Gas Station
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank = 0;
        int currTank = 0;
        int start = 0;
        int stations = gas.length;

        for (int i = 0; i < stations; i++) {
            totalTank += gas[i] - cost[i];
            currTank += gas[i] - cost[i];

            if (currTank < 0) {
                start = i + 1;
                currTank = 0;
            }
        }
        return totalTank >= 0 ? start : -1;
    }
}
