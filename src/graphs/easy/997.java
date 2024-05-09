package graphs.easy;

// https://leetcode.com/problems/find-the-town-judge/description/
// 997. Find the Town Judge
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] inward = new int[n];
        int[] outward = new int[n];

        for (int[] edge : trust) {
            int from = edge[0];
            int to = edge[1];
            inward[to]++;
            outward[from]++;
        }

        return searchForJudge(inward, outward, n);
    }

    private int searchForJudge(int[] inward, int[] outward, int n) {
        for (int i = 0; i < n; i++) {
            if (inward[i] == n - 1 && outward[i] == 0)
                return i;
        }
        return -1;
    }

}
