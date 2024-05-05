import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/reverse-vowels-of-a-string/description/
// 345. Reverse Vowels of a String
class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            char startVowel = s.charAt(start);
            if (!isVowel(vowels, startVowel)) {
                chars[start++] = startVowel;
                continue;
            }

            while (end > 0) {
                char endVowel = s.charAt(end);
                if (isVowel(vowels, endVowel)) {
                    chars[end--] = startVowel;
                    chars[start++] = endVowel;
                    break;
                }
                chars[end] = s.charAt(end);
                end--;
            }
        }

        return String.valueOf(chars);
    }

    private boolean isVowel(Set<Character> vowels, char c) {
        char lower = Character.toLowerCase(c);
        return vowels.contains(lower);
    }
}