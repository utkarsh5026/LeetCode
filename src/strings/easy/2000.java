package strings.easy;

// https://leetcode.com/problems/reverse-prefix-of-word/description/
// 2000. Reverse Prefix of Word
class Solution {
    public String reversePrefix(String word, char ch) {
        int firstChIdx = 0;

        while (firstChIdx < word.length()) {
            if (word.charAt(firstChIdx) == ch)
                break;
            firstChIdx++;
        }

        if (firstChIdx == word.length())
            return word;
        String prefix = word.substring(0, firstChIdx + 1);
        String rest = word.substring(firstChIdx + 1);

        return new StringBuilder(prefix).reverse().toString() + rest;
    }
}