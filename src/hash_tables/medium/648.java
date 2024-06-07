package hash_tables.medium;

import java.util.*;

// https://leetcode.com/problems/replace-words/description/
// 648. Replace Words
class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> wordSet = new HashSet<>();
        for (String word : dictionary) {
            wordSet.add(word);
        }

        String[] words = sentence.split("//s+");

        String[] root = new String[words.length];
        for (int k = 0; k < words.length; k++) {
            String word = words[k];
            StringBuilder build = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                build.append(word.charAt(i));
                if (wordSet.contains(build.toString()))
                    break;
            }

            root[k] = build.toString();
        }
        return String.join(" ", root);
    }
}