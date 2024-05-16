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

// https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/description/
// 2415. Reverse Odd Levels of Binary Tree
class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {

        if (root == null)
            return null;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int nodes = queue.size();

            TreeNode[] levelNodes = new TreeNode[nodes];
            boolean isOdd = level % 2 == 1;
            for (int i = 0; i < nodes; i++) {
                TreeNode node = queue.pollFirst();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);

                if (isOdd)
                    levelNodes[i] = node;

            }

            if (isOdd)
                reverseNodeVals(levelNodes);
            level++;
        }

        return root;
    }

    void reverseNodeVals(TreeNode[] nodes) {
        int start = 0;
        int end = nodes.length - 1;

        while (start < end) {
            int startVal = nodes[start].val;
            int endVal = nodes[end].val;

            nodes[start].val = endVal;
            nodes[end].val = startVal;

            start++;
            end--;
        }
    }
}