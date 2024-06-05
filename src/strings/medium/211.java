package strings.medium;

// https://leetcode.com/problems/design-add-and-search-words-data-structure/description/
// 211. Design Add and Search Words Data Structure
class WordDictionary {
    private static final int ALPHABETS = 26;

    class TrieNode {
        boolean endOfWord;
        TrieNode[] characters;

        public TrieNode() {
            this.endOfWord = false;
            this.characters = new TrieNode[ALPHABETS];
        }
    }

    TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode start = root;
        for (int i = 0; i < word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            if (start.characters[pos] == null) {
                start.characters[pos] = new TrieNode();
            }
            start = start.characters[pos];
        }
        start.endOfWord = true;
    }

    public boolean search(String word) {
        return searchInNode(word, 0, root);
    }

    private boolean searchInNode(String word, int index, TrieNode node) {
        if (node == null) {
            return false;
        }
        if (index == word.length()) {
            return node.endOfWord;
        }

        char ch = word.charAt(index);
        if (ch == '.') {
            for (int i = 0; i < 26; i++) {
                if (searchInNode(word, index + 1, node.characters[i])) {
                    return true;
                }
            }
            return false;
        } else {
            return searchInNode(word, index + 1, node.characters[ch - 'a']);
        }
    }
}
