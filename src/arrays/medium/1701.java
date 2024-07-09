package arrays.medium;

// https://leetcode.com/problems/average-waiting-time/description/
// 1701. Average Waiting Time
class Solution {
    public double averageWaitingTime(int[][] customers) {
        if (customers == null || customers.length == 0)
            return 0d;

        long currTime = 0;
        long totalWaitingTime = 0;

        for (int i = 0; i < customers.length; i++) {
            int[] customer = customers[i];
            int arrival = customer[0];
            int prepTime = customer[1];

            currTime = Math.max(currTime, arrival);
            currTime += prepTime;
            totalWaitingTime += currTime - arrival;
        }

        return (double) totalWaitingTime / customers.length;
    }
}