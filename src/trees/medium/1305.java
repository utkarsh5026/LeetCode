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

// https://leetcode.com/problems/all-elements-in-two-binary-search-trees/description/
// 1305. All Elements in Two Binary Search Trees
class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> sorted1 = new ArrayList<>();
        List<Integer> sorted2 = new ArrayList<>();
        inorderTraversal(root1, sorted1);
        inorderTraversal(root2, sorted2);
        return mergeTwoSortedLists(sorted1, sorted2);
    }

    void inorderTraversal(TreeNode root, List<Integer> nodes) {
        if (root == null)
            return;

        inorderTraversal(root.left, nodes);
        nodes.add(root.val);
        inorderTraversal(root.right, nodes);
    }

    List<Integer> mergeTwoSortedLists(List<Integer> a, List<Integer> b) {

        List<Integer> merged = new ArrayList<>();
        int ai = 0;
        int bj = 0;
        while (ai < a.size() && bj < b.size()) {
            int aa = a.get(ai);
            int bb = b.get(bj);

            if (aa < bb) {
                merged.add(aa);
                ai++;
            }

            else if (aa > bb) {
                merged.add(bb);
                bj++;
            }

            else {
                merged.add(aa);
                merged.add(bb);
                ai++;
                bj++;
            }
        }

        if (ai < a.size())
            merged.addAll(a.subList(ai, a.size()));
        if (bj < b.size())
            merged.addAll(b.subList(bj, b.size()));
        return merged;
    }
}