package strings.easy;

// https://leetcode.com/problems/minimum-number-of-chairs-in-a-waiting-room/description/
// 3168. Minimum Number of Chairs in a Waiting Room
class Solution {
    public int minimumChairs(String s) {
        int chairs = 0;
        int maxChairs = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'E') {
                chairs += 1;
            } else {
                chairs -= 1;
            }
            maxChairs = Math.max(chairs, maxChairs);
        }

        return maxChairs;
    }
}
