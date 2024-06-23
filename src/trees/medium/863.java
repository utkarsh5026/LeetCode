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

// https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
// 863. All Nodes Distance K in Binary Tree
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        // Map to store parent pointers
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        buildParentMap(root, null, parentMap);

        // Set to keep track of visited nodes
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        visited.add(target);

        int currentDistance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (currentDistance == k) {
                for (int i = 0; i < size; i++) {
                    result.add(queue.poll().val);
                }
                return result;
            }

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null && visited.add(node.left)) {
                    queue.offer(node.left);
                }
                if (node.right != null && visited.add(node.right)) {
                    queue.offer(node.right);
                }
                TreeNode parent = parentMap.get(node);
                if (parent != null && visited.add(parent)) {
                    queue.offer(parent);
                }
            }
            currentDistance++;
        }
        return result;
    }

    private void buildParentMap(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> parentMap) {
        if (node != null) {
            parentMap.put(node, parent);
            buildParentMap(node.left, node, parentMap);
            buildParentMap(node.right, node, parentMap);
        }
    }
}