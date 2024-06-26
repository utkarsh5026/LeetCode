package strings.medium;

import java.util.*;

// https://leetcode.com/problems/implement-magic-dictionary/description/
// 676. Implement Magic Dictionary
class MagicDictionary {

    class TrieNode {
        Map<Character, TrieNode> children;
        boolean endOfWord;

        public TrieNode() {
            this.children = new HashMap<>();
            this.endOfWord = false;
        }
    }

    private TrieNode root;

    public MagicDictionary() {
        root = new TrieNode();
    }

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            TrieNode curr = root;
            for (char ch : word.toCharArray()) {
                curr.children.putIfAbsent(ch, new TrieNode());
                curr = curr.children.get(ch);
            }
            curr.endOfWord = true;
        }
    }

    public boolean search(String searchWord) {
        return searchHelper(searchWord, root, 0, false);
    }

    private boolean searchHelper(String word, TrieNode root, int index, boolean modified) {

        if (word.length() == index && modified && root.endOfWord)
            return true;

        char curr = word.charAt(index);
        if (root.children.containsKey(curr) && searchHelper(word, root.children.get(curr), index + 1, modified))
            return true;

        if (!modified) {
            for (Map.Entry<Character, TrieNode> node : root.children.entrySet()) {
                if (node.getKey() != curr && searchHelper(word, node.getValue(), index + 1, true)) {
                    return true;
                }
            }
        }

        return false;
    }
}
