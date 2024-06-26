package strings.easy;

// https://leetcode.com/problems/detect-capital/description/
// 520. Detect Capital
class Solution {
    public boolean detectCapitalUse(String word) {
        return isAllUpperCase(word) || isAllLowerCase(word) || isTitleCase(word);
    }

    private boolean isAllUpperCase(String word) {
        for (char c : word.toCharArray()) {
            if (!Character.isUpperCase(c)) {
                return false;
            }
        }
        return true;
    }

    private boolean isAllLowerCase(String word) {
        for (char c : word.toCharArray()) {
            if (!Character.isLowerCase(c)) {
                return false;
            }
        }
        return true;
    }

    private boolean isTitleCase(String word) {
        if (word.isEmpty() || !Character.isUpperCase(word.charAt(0))) {
            return false;
        }
        for (int i = 1; i < word.length(); i++) {
            if (!Character.isLowerCase(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}
