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

// https:// leetcode.com/problems/serialize-and-deserialize-bst/description/
// 449. Serialize and Deserialize BST
class Codec {

    private int preorderIdx;

    public String serialize(TreeNode root) {
        if (root == null)
            return "";

        List<Integer> inorder = new ArrayList<>();
        List<Integer> preorder = new ArrayList<>();
        inorderTraversal(root, inorder);
        preorderTraversal(root, preorder);
        return removeBrackets(inorder.toString()) + ";" + removeBrackets(preorder.toString());
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if (data.length() == 0)
            return null;

        String[] traversals = data.split(";");
        int[] preorder = toIntArr(traversals[1].split(","));
        int[] inorder = toIntArr(traversals[0].split(","));

        Map<Integer, Integer> inorderIdx = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIdx.put(inorder[i], i);
        }

        this.preorderIdx = 0;
        return createTree(preorder, inorder, 0, preorder.length - 1, inorderIdx);
    }

    private TreeNode createTree(int[] preorder, int[] inorder, int start, int end, Map<Integer, Integer> inorderIdx) {
        if (start > end)
            return null;

        TreeNode root = new TreeNode(preorder[preorderIdx++]);
        int inIdx = inorderIdx.get(root.val);

        root.left = createTree(preorder, inorder, start, inIdx - 1, inorderIdx);
        root.right = createTree(preorder, inorder, inIdx + 1, end, inorderIdx);
        return root;
    }

    void inorderTraversal(TreeNode root, List<Integer> nodes) {
        if (root == null)
            return;

        inorderTraversal(root.left, nodes);
        nodes.add(root.val);
        inorderTraversal(root.right, nodes);
    }

    void preorderTraversal(TreeNode root, List<Integer> nodes) {
        if (root == null)
            return;
        nodes.add(root.val);

        preorderTraversal(root.left, nodes);
        preorderTraversal(root.right, nodes);
    }

    int[] toIntArr(String[] arr) {
        int[] ints = new int[arr.length];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(arr[i].trim());
        }

        return ints;
    }

    private String removeBrackets(String list) {
        return list.substring(1, list.length() - 1);
    }
}