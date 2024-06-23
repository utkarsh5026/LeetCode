package hash_tables.medium;

// https://leetcode.com/problems/sum-of-beauty-of-all-substrings/description/
// 1781. Sum of Beauty of All Substrings
class Solution {
    public int beautySum(String s) {
        int totalBeauty = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];
            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++;
                totalBeauty += calculateBeauty(freq);
            }
        }

        return totalBeauty;
    }

    private int calculateBeauty(int[] freq) {
        int maxFreq = 0;
        int minFreq = Integer.MAX_VALUE;

        for (int f : freq) {
            if (f > 0) {
                maxFreq = Math.max(maxFreq, f);
                minFreq = Math.min(minFreq, f);
            }
        }

        return maxFreq - minFreq;
    }
}