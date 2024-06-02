package greedy.easy;

import java.util.Arrays;

// https://leetcode.com/problems/maximum-units-on-a-truck/description/
// 1710. Maximum Units on a Truck
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

        int idx = 0;
        int maximumUnits = 0;
        while (truckSize > 0 && idx < boxTypes.length) {
            int[] boxesWithUnit = boxTypes[idx];
            int boxes = boxesWithUnit[0];
            int units = boxesWithUnit[1];

            if (boxes > truckSize)
                boxes = truckSize;

            maximumUnits += units * boxes;
            truckSize -= boxes;
            idx++;
        }

        return maximumUnits;
    }
}