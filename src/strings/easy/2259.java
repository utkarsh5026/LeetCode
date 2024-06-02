package strings.easy;

// https://leetcode.com/problems/remove-digit-from-number-to-maximize-result/description/
// 2259. Remove Digit From Number to Maximize Result
class Solution {
    public String removeDigit(String number, char digit) {
        String maxResult = "";

        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == digit) {
                String candidate = number.substring(0, i) + number.substring(i + 1);
                if (maxResult.equals("") || candidate.compareTo(maxResult) > 0) {
                    maxResult = candidate;
                }
            }
        }

        return maxResult;
    }
}
