package sliding_window.medium;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/maximum-number-of-occurrences-of-a-substring/description/
// 1297. Maximum Number of Occurrences of a Substring
class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<Character, Integer> countMap = new HashMap<>();
        Map<String, Integer> freqMap = new HashMap<>();
        int left = 0;
        int maxFrequency = 0;

        // Loop through each character in the string
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);

            if (right - left + 1 > minSize) {
                char leftChar = s.charAt(left);
                countMap.put(leftChar, countMap.get(leftChar) - 1);
                if (countMap.get(leftChar) == 0) {
                    countMap.remove(leftChar);
                }
                left++;
            }

            if (right - left + 1 == minSize && countMap.size() <= maxLetters) {
                String substr = s.substring(left, right + 1);
                freqMap.put(substr, freqMap.getOrDefault(substr, 0) + 1);
                maxFrequency = Math.max(maxFrequency, freqMap.get(substr));
            }
        }

        return maxFrequency;
    }

}
