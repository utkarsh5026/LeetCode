package strings.easy;

// https://leetcode.com/problems/determine-if-string-halves-are-alike/description/
// 1704. Determine if String Halves Are Alike
class Solution {
    public boolean halvesAreAlike(String s) {
        String vowels = "aeiouAEIOU";
        int n = s.length();

        String a = s.substring(0, n / 2);
        String b = s.substring(n / 2);

        int aVowels = countVowels(a, vowels);
        int bVowels = countVowels(b, vowels);
        return aVowels == bVowels;
    }

    // Helper function to count the vowels in a given string
    private int countVowels(String str, String vowels) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }
}