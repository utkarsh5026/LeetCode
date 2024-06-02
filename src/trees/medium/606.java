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

// https://leetcode.com/problems/construct-string-from-binary-tree/description/
// 606. Construct String from Binary Tree
class Solution {
    public String tree2str(TreeNode root) {
        return toStr(root);
    }

    String toStr(TreeNode root) {

        if (root == null)
            return "";
        String rootVal = String.valueOf(root.val);

        String left = toStr(root.left);
        String right = toStr(root.right);

        if (!left.isEmpty() || (left.isEmpty() && !right.isEmpty()))
            rootVal += "(" + left + ")";

        if (!right.isEmpty())
            rootVal += "(" + right + ")";

        return rootVal;
    }

}
