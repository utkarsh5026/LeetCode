package hash_tables.medium;

import java.util.Arrays;

// https://leetcode.com/problems/implement-trie-prefix-tree/description/
// 208. Implement Trie (Prefix Tree)
class Trie {

    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        char[] wordChars = word.toCharArray();
        TrieNode node = root;

        for (char c : wordChars) {
            if (!node.containsChar(c))
                node.put(c, new TrieNode());

            node = node.get(c);
        }
        node.setEndWord(true);
    }

    public boolean search(String word) {
        TrieNode node = root;

        for (char c : word.toCharArray()) {
            if (!node.containsChar(c))
                return false;

            node = node.get(c);
        }
        return node.isEndOfWord();
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (!node.containsChar(c)) {
                return false;
            }
            node = node.get(c);
        }
        return true;
    }

    class TrieNode {
        private TrieNode[] children;
        private boolean isEndOfWord;

        public TrieNode() {
            this.children = new TrieNode[26];
            Arrays.fill(children, null);
            this.isEndOfWord = false;
        }

        public TrieNode get(char c) {
            return this.children[c - 'a'];
        }

        public boolean isEndOfWord() {
            return isEndOfWord;
        }

        public void setEndWord(boolean endWord) {
            this.isEndOfWord = endWord;
        }

        public void put(char c, TrieNode node) {
            children[c - 'a'] = node;
        }

        public boolean containsChar(char c) {
            return children[c - 'a'] != null;
        }
    }
}
