package trees.medium;

import java.util.*;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/
// 116. Populating Next Right Pointers in Each Node
class Solution {
    public Node connect(Node root) {
        if (root == null)
            return null;

        Deque<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node node = queue.pollFirst();

                if (i < levelSize - 1) {
                    node.next = queue.peekFirst();
                }

                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }
        return root;
    }
}
