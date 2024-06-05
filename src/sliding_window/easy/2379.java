package sliding_window.easy;

// https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/description/
// 2379. Minimum Recolors to Get K Consecutive Black Blocks
class Solution {
    public int minimumRecolors(String blocks, int k) {
        int flips = 0;
        int windowStart = 0;
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                flips++;
            }
        }
        int minFlips = flips;
        for (int windowEnd = k; windowEnd < blocks.length(); windowEnd++) {
            if (blocks.charAt(windowEnd) == 'W') {
                flips++;
            }
            if (blocks.charAt(windowStart) == 'W') {
                flips--;
            }
            windowStart++;
            minFlips = Math.min(minFlips, flips);
        }
        return minFlips;
    }
}
