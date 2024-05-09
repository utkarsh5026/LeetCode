package trees.easy;

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

// https://leetcode.com/problems/increasing-order-search-tree/description/
// 897. Increasing Order Search Tree
class Solution {
    public TreeNode increasingBST(TreeNode root) {
        if (root == null)
            return null;
        List<TreeNode> nodes = new ArrayList<>();
        inorder(root, nodes);

        for (int i = 0; i < nodes.size() - 1; i++) {
            nodes.get(i).right = nodes.get(i + 1);
            nodes.get(i).left = null;
        }

        nodes.get(nodes.size() - 1).left = null;
        return nodes.get(0);
    }

    private void inorder(TreeNode root, List<TreeNode> nodes) {
        if (root == null)
            return;

        inorder(root.left, nodes);
        nodes.add(root);
        inorder(root.right, nodes);
    }

}
