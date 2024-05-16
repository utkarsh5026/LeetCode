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

// https://leetcode.com/problems/add-one-row-to-tree/description/
// 623. Add One Row to Tree
class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }

        attachRow(root, 1, depth, val);
        return root;
    }

    void attachRow(TreeNode root, int currDepth, int depth, int val) {
        if (root == null)
            return;

        if (currDepth == depth - 1) {
            TreeNode prevLeft = root.left;
            TreeNode prevRight = root.right;

            root.left = new TreeNode(val);
            root.right = new TreeNode(val);

            root.left.left = prevLeft;
            root.right.right = prevRight;
            return;
        }

        attachRow(root.left, currDepth + 1, depth, val);
        attachRow(root.right, currDepth + 1, depth, val);
    }
}