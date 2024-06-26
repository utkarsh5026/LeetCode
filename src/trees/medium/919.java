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


// https://leetcode.com/problems/complete-binary-tree-inserter/description/
// 919. Complete Binary Tree Inserter
class CBTInserter {
    TreeNode root;
    Queue<TreeNode> queue;

    public CBTInserter(TreeNode root) {
        this.root = root;
        this.queue = new LinkedList<>();
        queue.add(root);

        // Initialize the queue to contain all nodes that are not fully occupied
        while (!queue.isEmpty()) {
            TreeNode node = queue.peek();
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
                queue.poll(); // Remove the node if it has both children
            } else {
                break; // The first node with an incomplete set of children
            }
        }
    }

    public int insert(int val) {
        TreeNode newNode = new TreeNode(val);
        TreeNode parent = queue.peek();

        if (parent.left == null) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
            queue.poll();
        }

        queue.add(newNode);
        return parent.val;
    }

    public TreeNode get_root() {
        return this.root;
    }
}
