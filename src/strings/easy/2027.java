package strings.easy;

// https://leetcode.com/problems/minimum-moves-to-convert-string/description/
// 2027. Minimum Moves to Convert String
class Solution {

    static final char X = 'X';
    static final char O = 'O';

    public int minimumMoves(String s) {
        int currLength = 0;
        int moves = 0;
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (curr == O && currLength == 0)
                continue;
            else
                currLength++;

            if (currLength == 3 || (i == s.length() - 1 && currLength > 0)) {
                moves++;
                currLength = 0;
            }
        }

        return moves;
    }
}