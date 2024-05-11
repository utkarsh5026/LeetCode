package trees.easy;

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

// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
// 108. Convert Sorted Array to Binary Search Tree
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;

        return makeTree(0, nums.length, nums);
    }

    TreeNode makeTree(int left, int right, int[] nums) {
        if (left > right)
            return null;

        if (left == right)
            return new TreeNode(nums[left]);

        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        TreeNode leftNode = makeTree(0, mid - 1, nums);
        TreeNode rightNode = makeTree(mid + 1, right, nums);

        if (leftNode.val == rightNode.val)
            root.left = leftNode;

        root.left = leftNode;
        root.right = rightNode;

        return root;
    }

}
