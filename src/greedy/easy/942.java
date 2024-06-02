package greedy.easy;

// https://leetcode.com/problems/di-string-match/description/
// 942. DI String Match
class Solution {
    public int[] diStringMatch(String s) {
        int[] result = new int[s.length() + 1];

        int max = s.length();
        int min = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'I')
                result[i] = min++;
            else
                result[i] = max--;
        }

        result[s.length()] = min;
        return result;
    }
}
