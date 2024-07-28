package queues.hard;

import java.util.*;

// https://leetcode.com/problems/word-ladder/description/
// 127. Word Ladder
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);

        // If endWord is not in the wordList, no transformation sequence exists
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(new Pair<>(beginWord, 1));
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            Pair<String, Integer> pair = queue.poll();
            String word = pair.getKey();
            int level = pair.getValue();

            if (word.equals(endWord)) {
                return level;
            }

            for (int i = 0; i < word.length(); i++) {
                char[] wordArray = word.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    wordArray[i] = c;
                    String newWord = new String(wordArray);
                    if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                        queue.offer(new Pair<>(newWord, level + 1));
                        visited.add(newWord);
                    }
                }
            }
        }

        return 0;
    }

    // Simple Pair class to hold a word and its level in the transformation sequence
    private class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}