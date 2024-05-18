package trees.medium;

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

// https://leetcode.com/problems/insert-into-a-binary-search-tree/description/
// 701. Insert into a Binary Search Tree
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null)
            return new TreeNode(val);

        insert(root, val);
        return root;
    }

    void insert(TreeNode root, int insertNode) {

        if (root == null)
            return;

        if (insertNode < root.val) {
            if (root.left != null)
                insert(root.left, insertNode);
            else {
                TreeNode newNode = new TreeNode(insertNode);
                root.left = newNode;
            }
        }

        if (insertNode > root.val) {
            if (root.right != null)
                insert(root.right, insertNode);
            else {
                TreeNode newNode = new TreeNode(insertNode);
                root.right = newNode;
            }
        }
    }
}