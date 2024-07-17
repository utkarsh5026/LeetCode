package backtracking.medium;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// https://leetcode.com/problems/smallest-string-starting-from-leaf/description/
// 988. Smallest String Starting From Leaf
class Solution {
    public String smallestFromLeaf(TreeNode root) {
        List<String> paths = new ArrayList<>();
        collectStrings(root, paths, "");
        return Collections.min(paths);
    }

    void collectStrings(TreeNode root, List<String> paths, String pathSoFar) {
        if (root == null)
            return;

        char curr = (char) ('a' + root.val);
        if (root.left == null && root.right == null) {
            paths.add(curr + pathSoFar);
        }

        collectStrings(root.left, paths, curr + pathSoFar);
        collectStrings(root.right, paths, curr + pathSoFar);
    }
}