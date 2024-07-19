package arrays.medium;

import java.util.Arrays;

// https://leetcode.com/problems/sort-the-students-by-their-kth-score/description/
// 2545. Sort the Students by Their Kth Score
class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, (a, b) -> b[k] - a[k]);
        return score;
    }
}