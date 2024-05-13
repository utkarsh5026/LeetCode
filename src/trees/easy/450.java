package trees.easy;

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

// https://leetcode.com/problems/delete-node-in-a-bst/description/
// 450. Delete Node in a BST
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null)
            return null;

        if (key < root.val)
            root.left = deleteNode(root.left, key);
        else if (key > root.val)
            root.right = deleteNode(root.right, key);

        else {
            if (root.left == null)
                return root.right;
            if (root.right == null)
                return root.left;
            root.val = inorderSuccessor(root.right);
            root.right = deleteNode(root.right, root.val);
        }

        return root;
    }

    int inorderSuccessor(TreeNode root) {
        int minimum = root.val;

        while (root.left != null) {
            minimum = root.left.val;
            root = root.left;
        }
        return minimum;
    }
}
