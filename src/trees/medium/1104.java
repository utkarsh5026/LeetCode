package trees.medium;

import java.util.*;

// https://leetcode.com/problems/path-in-zigzag-labelled-binary-tree/description/
// 1104. Path In Zigzag Labelled Binary Tree
class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        int level = getLevel(label);
        List<Integer> result = new ArrayList<>();

        while (label > 0) {
            result.add(label);
            int offset = (int) Math.pow(2, level - 1) - 1;
            int parent = offset - (label - offset) / 2;
            label = parent;
            level--;
        }

        Collections.reverse(result);
        return result;
    }

    int getLevel(int label) {
        int level = 0;
        while (label > 0) {
            label /= 2;
            level++;
        }
        return level;
    }
}