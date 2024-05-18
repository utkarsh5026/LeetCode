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

// https://leetcode.com/problems/binary-search-tree-iterator/description/
// 173. Binary Search Tree Iterator
class BSTIterator {

    List<Integer> inorder;
    int idx = 0;

    public BSTIterator(TreeNode root) {
        this.inorder = new ArrayList<>();
        inorderTraversal(root);
    }

    public int next() {
        return inorder.get(idx++);
    }

    public boolean hasNext() {
        return idx < inorder.size();
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null)
            return;
        inorderTraversal(root.left);
        inorder.add(root.val);
        inorderTraversal(root.right);
    }
}
