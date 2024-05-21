package graphs.hard;

import java.util.*;

// https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/description/
// 1028. Recover a Tree From Preorder Traversal
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    private int index;

    public TreeNode recoverFromPreorder(String S) {
        List<int[]> nodes = parse(S);
        index = 0;
        return buildTree(nodes, 0);
    }

    private List<int[]> parse(String S) {
        List<int[]> nodes = new ArrayList<>();
        int i = 0;
        while (i < S.length()) {
            // Determine the depth by counting dashes
            int depth = 0;
            while (i < S.length() && S.charAt(i) == '-') {
                depth++;
                i++;
            }

            int value = 0;
            while (i < S.length() && Character.isDigit(S.charAt(i))) {
                value = value * 10 + (S.charAt(i) - '0');
                i++;
            }

            nodes.add(new int[] { depth, value });
        }
        return nodes;
    }

    private TreeNode buildTree(List<int[]> nodes, int depth) {
        if (index >= nodes.size() || nodes.get(index)[0] != depth) {
            return null;
        }

        int[] nodeInfo = nodes.get(index++);
        TreeNode node = new TreeNode(nodeInfo[1]);

        node.left = buildTree(nodes, depth + 1);
        node.right = buildTree(nodes, depth + 1);

        return node;
    }

}
