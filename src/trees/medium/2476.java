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

// https://leetcode.com/problems/closest-nodes-queries-in-a-binary-search-tree/description/
// 2476. Closest Nodes Queries in a Binary Search Tree
class Solution {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);
        List<List<Integer>> solutions = new ArrayList<>();

        for (int query : queries) {
            int min = justSmallerOrEqual(query, inorder);
            int max = justLargerOrEqual(query, inorder);
            solutions.add(new ArrayList<>(Arrays.asList(min, max)));
        }
        return solutions;
    }

    void inorderTraversal(TreeNode root, List<Integer> nodes) {
        if (root == null)
            return;

        inorderTraversal(root.left, nodes);
        nodes.add(root.val);
        inorderTraversal(root.right, nodes);
    }

    int justSmallerOrEqual(int target, List<Integer> inorder) {
        int start = 0;
        int end = inorder.size() - 1;
        int min = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int curr = inorder.get(mid);

            if (curr <= target) {
                min = curr;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return min;
    }

    int justLargerOrEqual(int target, List<Integer> inorder) {
        int start = 0;
        int end = inorder.size() - 1;
        int max = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int curr = inorder.get(mid);

            if (curr >= target) {
                max = curr;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return max;
    }
}
