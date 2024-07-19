package arrays.medium;

// https://leetcode.com/problems/queries-on-number-of-points-inside-a-circle/description/
// 1828. Queries on Number of Points Inside a Circle
class Solution {
    public static int[] countPoints(int[][] points, int[][] queries) {
        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int xj = queries[i][0];
            int yj = queries[i][1];
            int rj = queries[i][2];
            int count = 0;
            int rSquared = rj * rj;

            for (int[] point : points) {
                int xi = point[0];
                int yi = point[1];

                // Calculate squared distance from point to circle center
                int distSquared = (xi - xj) * (xi - xj) + (yi - yj) * (yi - yj);

                if (distSquared <= rSquared) {
                    count++;
                }
            }

            answer[i] = count;
        }

        return answer;
    }
}