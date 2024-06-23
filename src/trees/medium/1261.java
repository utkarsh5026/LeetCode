package trees.medium;

import java.util.HashSet;
import java.util.Set;

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

// https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/description/
// 1261. Find Elements in a Contaminated Binary Tree
class FindElements {

    Set<Integer> elements;

    public FindElements(TreeNode root) {
        elements = new HashSet<>();
        if (root != null)
            root.val = 0;
        sanitize(root);
    }

    public boolean find(int target) {
        return elements.contains(target);
    }

    void sanitize(TreeNode root) {
        if (root == null)
            return;

        int rootVal = root.val;
        elements.add(rootVal);
        if (root.left != null)
            root.left.val = (2 * rootVal) + 1;

        if (root.right != null)
            root.right.val = (2 * rootVal) + 2;

        sanitize(root.left);
        sanitize(root.right);
    }
}