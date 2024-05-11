package trees.easy;

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

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

// https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/
// 109. Convert Sorted List to Binary Search Tree
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;

        List<Integer> nodes = new ArrayList<>();

        while (head != null) {
            nodes.add(head.val);
            head = head.next;
        }

        return makeTree(0, nodes.size() - 1, nodes);
    }

    TreeNode makeTree(int left, int right, List<Integer> nums) {
        if (left > right)
            return null;

        if (left == right)
            return new TreeNode(nums.get(left));

        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums.get(mid));
        TreeNode leftNode = makeTree(0, mid - 1, nums);
        TreeNode rightNode = makeTree(mid + 1, right, nums);

        if (leftNode.val == rightNode.val)
            root.left = leftNode;

        root.left = leftNode;
        root.right = rightNode;

        return root;
    }
}