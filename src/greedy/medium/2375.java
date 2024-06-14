package greedy.medium;

// https://leetcode.com/problems/construct-smallest-number-from-di-string/description/
// 2375. Construct Smallest Number From DI String
class Solution {
    public String smallestNumber(String pattern) {
        StringBuilder result = new StringBuilder();
        boolean[] used = new boolean[10];

        if (backtrack(result, pattern, used, 0)) {
            return result.toString();
        }

        return "";
    }

    private boolean backtrack(StringBuilder result, String pattern, boolean[] used, int index) {
        if (index == pattern.length() + 1) {
            return true;
        }

        for (int num = 1; num <= 9; num++) {
            if (!used[num]) {
                if (index > 0) {
                    char lastPattern = pattern.charAt(index - 1);
                    int lastNum = result.charAt(index - 1) - '0';
                    if ((lastPattern == 'I' && lastNum >= num) || (lastPattern == 'D' && lastNum <= num)) {
                        continue;
                    }
                }

                result.append(num);
                used[num] = true;

                if (backtrack(result, pattern, used, index + 1)) {
                    return true;
                }

                // Undo the choice
                result.deleteCharAt(result.length() - 1);
                used[num] = false;
            }
        }

        return false;
    }
}
