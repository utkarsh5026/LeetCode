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

// https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/description/
// 865. Smallest Subtree with all the Deepest Nodes
class Solution {

    private TreeNode answer;
    private int maxDepth;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        maxDepth = -1;
        dfs(root, 0);
        return answer;
    }

    private int dfs(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }

        int leftDepth = dfs(node.left, depth + 1);
        int rightDepth = dfs(node.right, depth + 1);

        if (leftDepth == rightDepth && leftDepth >= maxDepth) {
            maxDepth = leftDepth;
            answer = node;
        }
        return Math.max(leftDepth, rightDepth);
    }
}
