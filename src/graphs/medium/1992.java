package graphs.medium;

import java.util.*;

// https://leetcode.com/problems/find-all-groups-of-farmland/description/
// 1992. Find All Groups of Farmland
class Solution {
    public int[][] findFarmland(int[][] land) {

        int rows = land.length;
        int cols = land[0].length;

        List<int[]> farmLands = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (land[i][j] == 0)
                    continue;
                List<int[]> cords = new ArrayList<>();
                dfs(i, j, land, rows, cols, cords);
                farmLands.add(findMinAndMaxCords(cords));
            }
        }

        int[][] farmRepresentation = new int[farmLands.size()][];
        for (int i = 0; i < farmRepresentation.length; i++) {
            farmRepresentation[i] = farmLands.get(i);
        }

        return farmRepresentation;
    }

    void dfs(int x, int y, int[][] land, int rows, int cols, List<int[]> cords) {
        boolean outside = x < 0 || x >= rows || y < 0 || y >= cols;
        if (outside || land[x][y] == 0)
            return;

        land[x][y] = 0;
        cords.add(new int[] { x, y });

        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };
        for (int[] dir : directions) {
            dfs(x + dir[0], y + dir[1], land, rows, cols, cords);
        }
    }

    int[] findMinAndMaxCords(List<int[]> cords) {
        int[] minCord = cords.get(0);
        int[] maxCord = cords.get(0);

        for (int i = 1; i < cords.size(); i++) {
            int[] cord = cords.get(i);
            int x = cord[0];
            int y = cord[1];

            if (x < minCord[0] || (x == minCord[0] && y < minCord[1]))
                minCord = cord;

            if (x > maxCord[0] || (x == maxCord[0] && y > maxCord[1]))
                maxCord = cord;
        }
        return new int[] { minCord[0], minCord[1], maxCord[0], maxCord[1] };
    }
}