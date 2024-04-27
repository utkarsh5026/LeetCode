package graphs.easy;

// https://leetcode.com/problems/flood-fill/description/
// 733. Flood Fill
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int currColor = image[sr][sc];
        if (currColor != color)
            dfs(sr, sc, color, currColor, image);
        return image;
    }

    private void dfs(int x, int y, int newColor, int currColor, int[][] image) {
        boolean outside = x < 0 || y < 0 || x >= image.length || y >= image[0].length;
        if (outside || image[x][y] != currColor)
            return;

        int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        image[x][y] = newColor;
        for (int[] direction : directions) {
            int dx = direction[0];
            int dy = direction[1];
            dfs(x + dx, y + dy, newColor, currColor, image);
        }
    }
}