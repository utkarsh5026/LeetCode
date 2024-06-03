package strings.medium;

// https://leetcode.com/problems/string-compression-iii/description/
// 3163. String Compression III
class Solution {
    public String compressedString(String word) {
        StringBuilder builder = new StringBuilder();
        int idx = 0;

        while (idx < word.length()) {
            int count = 1;
            while (idx < word.length() - 1 && word.charAt(idx) == word.charAt(idx + 1) && count < 9) {
                count++;
                idx++;
            }

            char ch = word.charAt(idx);
            builder.append(count);
            builder.append(ch);
            idx++;
        }

        return builder.toString();
    }
}
