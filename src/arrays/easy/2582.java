package arrays.easy;

// https://leetcode.com/problems/pass-the-pillow/description/
// 2582. Pass the Pillow
class Solution {
    public int passThePillow(int n, int time) {
        int passPerRound = n - 1;
        int rounds = time / passPerRound;

        int person = time % passPerRound;

        return rounds % 2 == 0 ? person + 1 : n - person;
    }
}