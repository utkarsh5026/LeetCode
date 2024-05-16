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

// https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree/description/
// 2583. Kth Largest Sum in a Binary Tree
class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null)
            return 0;

        PriorityQueue<Long> results = new PriorityQueue<>(Collections.reverseOrder());
        Set<Long> sums = new HashSet<>();
        Deque<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            int nodes = queue.size();
            long sum = 0;
            for (int i = 0; i < nodes; i++) {
                TreeNode node = queue.pollFirst();
                sum += node.val;

                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }

            if (sums.contains(sum))
                continue;
            results.add(sum);
            sums.add(sum);
        }

        if (results.size() < k)
            return -1;

        return getKthLargest(results, k);
    }

    long getKthLargest(PriorityQueue<Long> results, int k) {
        while (k > 1) {
            results.poll();
            k--;
        }
        return results.poll();
    }

}
