package trees.medium;

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

// https://leetcode.com/problems/find-bottom-left-tree-value/description/
// 513. Find Bottom Left Tree Value
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Map<Integer, Integer> firstLeft = new HashMap<>();
        search(root, 0, firstLeft);

        if (firstLeft.keySet().isEmpty())
            return 0;
        int maxHeight = Collections.max(firstLeft.keySet());
        return firstLeft.get(maxHeight);
    }

    void search(TreeNode root, int height, Map<Integer, Integer> firstLeft) {
        if (root == null)
            return;

        boolean isLeaf = root.left == null && root.right == null;

        if (isLeaf && !firstLeft.containsKey(height)) {
            firstLeft.put(height, root.val);
        }

        search(root.left, height + 1, firstLeft);
        search(root.right, height + 1, firstLeft);

    }
}