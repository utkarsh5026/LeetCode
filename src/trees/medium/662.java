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

// https://leetcode.com/problems/maximum-width-of-binary-tree/description/
// 662. Maximum Width of Binary Tree
class Solution {
    private class NodeInfo {
        TreeNode node;
        int position;

        NodeInfo(TreeNode node, int position) {
            this.node = node;
            this.position = position;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        int maxWidth = 0;
        Queue<NodeInfo> queue = new LinkedList<>();
        queue.offer(new NodeInfo(root, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();
            int minPosition = queue.peek().position; // Min position at the current level
            int firstPosition = 0;
            int lastPosition = 0;

            for (int i = 0; i < size; i++) {
                NodeInfo currentNodeInfo = queue.poll();
                TreeNode currentNode = currentNodeInfo.node;
                int currentPosition = currentNodeInfo.position - minPosition; // Normalize to prevent overflow

                if (i == 0)
                    firstPosition = currentPosition;
                if (i == size - 1)
                    lastPosition = currentPosition;

                if (currentNode.left != null) {
                    queue.offer(new NodeInfo(currentNode.left, 2 * currentPosition));
                }
                if (currentNode.right != null) {
                    queue.offer(new NodeInfo(currentNode.right, 2 * currentPosition + 1));
                }
            }

            maxWidth = Math.max(maxWidth, lastPosition - firstPosition + 1);
        }

        return maxWidth;
    }
}
