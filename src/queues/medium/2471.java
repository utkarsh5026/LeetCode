package queues.medium;

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

// https://leetcode.com/problems/minimum-number-of-operations-to-sort-a-binary-tree-by-level/description/
// 2471. Minimum Number of Operations to Sort a Binary Tree by Level
class Solution {
    public int minimumOperations(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int operations = 0;
        while (!queue.isEmpty()) {
            int levelNodes = queue.size();

            List<Integer> nodes = new ArrayList<>();
            for (int i = 0; i < levelNodes; i++) {
                TreeNode node = queue.pollFirst();
                nodes.add(node.val);

                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }

            operations += countChanges(nodes);
        }
        return operations;
    }

    int countChanges(List<Integer> arr) {
        int n = arr.size();
        List<Integer> sorted = new ArrayList<>(arr);
        Collections.sort(sorted);
        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            indexMap.put(arr.get(i), i);
        }

        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || indexMap.get(sorted.get(i)) == i) {
                continue;
            }

            int cycleSize = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = indexMap.get(sorted.get(j));
                cycleSize++;
            }

            if (cycleSize > 0) {
                swaps += (cycleSize - 1);
            }
        }

        return swaps;
    }
}