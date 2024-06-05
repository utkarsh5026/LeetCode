package sliding_window.medium;

// https://leetcode.com/problems/maximize-the-confusion-of-an-exam/description/
// 2024. Maximize the Confusion of an Exam
class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(maxConsecutiveChar(answerKey, k, 'T'), maxConsecutiveChar(answerKey, k, 'F'));
    }

    private int maxConsecutiveChar(String s, int k, char target) {
        int maxLen = 0;
        int left = 0;
        int count = 0; // Count of non-target characters in the current window

        for (int right = 0; right < s.length(); right++) {
            if (s.charAt(right) != target) {
                count++;
            }

            while (count > k) {
                if (s.charAt(left) != target) {
                    count--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
