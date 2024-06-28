package arrays.medium;

import java.util.*;

// https://leetcode.com/problems/find-the-minimum-area-to-cover-all-ones-i/description/
// 3195. Find the Minimum Area to Cover All Ones I

class Solution {

    class Cord {
        int x;
        int y;

        public Cord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int minimumArea(int[][] grid) {
        List<Cord> ones = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    ones.add(new Cord(i, j));
            }
        }

        Collections.sort(ones, (a, b) -> a.y - b.y);
        int top = ones.get(0).y;
        int bottom = ones.get(ones.size() - 1).y;

        Collections.sort(ones, (a, b) -> a.x - b.x);
        int left = ones.get(0).x;
        int right = ones.get(ones.size() - 1).x;
        return (right - left + 1) * (bottom - top + 1);
    }
}