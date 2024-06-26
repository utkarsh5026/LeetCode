package hash_tables.medium;

import java.util.*;

// https://leetcode.com/problems/map-sum-pairs/description/
// 677. Map Sum Pairs
class MapSum {

    class TrieNode {
        int val;
        Map<Character, TrieNode> children;

        public TrieNode() {
            this.val = 0;
            this.children = new HashMap<>();
        }
    }

    private TrieNode root;
    private Map<String, Integer> map;

    public MapSum() {
        this.root = new TrieNode();
        this.map = new HashMap<>();
    }

    public void insert(String key, int val) {
        int delta = val - map.getOrDefault(key, 0);
        map.put(key, val);

        TrieNode curr = root;
        for (char ch : key.toCharArray()) {
            curr.children.putIfAbsent(ch, new TrieNode());
            curr = curr.children.get(ch);
            curr.val += delta;
        }
    }

    public int sum(String prefix) {
        TrieNode curr = root;

        for (char ch : prefix.toCharArray()) {
            curr = curr.children.getOrDefault(ch, null);
            if (curr == null)
                return 0;
        }
        return curr.val;
    }
}