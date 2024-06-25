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

// https://leetcode.com/problems/number-of-good-leaf-nodes-pairs/description/
// 1530. Number of Good Leaf Nodes Pairs
class Solution {
    public int countPairs(TreeNode root, int distance) {
        int[] result = new int[1];
        dfs(root, distance, result);
        return result[0];
    }

    private int[] dfs(TreeNode node, int distance, int[] result) {
        if (node == null)
            return new int[distance + 1];

        if (node.left == null && node.right == null) {
            int[] leafDist = new int[distance + 1];
            leafDist[1] = 1;
            return leafDist;
        }

        int[] leftDist = dfs(node.left, distance, result);
        int[] rightDist = dfs(node.right, distance, result);

        for (int i = 1; i <= distance; i++) {
            for (int j = 1; j <= distance; j++) {
                if (i + j <= distance) {
                    result[0] += leftDist[i] * rightDist[j];
                }
            }
        }

        int[] currentDist = new int[distance + 1];
        for (int i = 1; i < distance; i++) {
            currentDist[i + 1] = leftDist[i] + rightDist[i];
        }

        return currentDist;
    }
}
