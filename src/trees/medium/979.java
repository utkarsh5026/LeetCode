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

class Solution {

    private int moves = 0;

    public int distributeCoins(TreeNode root) {
        postOrder(root);
        return moves;
    }

    int postOrder(TreeNode root) {
        if (root == null)
            return 0;

        int leftExcess = postOrder(root.left);
        int rightExcess = postOrder(root.right);

        this.moves += Math.abs(leftExcess) + Math.abs(rightExcess);

        return root.val + leftExcess + rightExcess - 1;
    }
}