package arrays.medium;

import java.util.*;

// https:// leetcode.com/problems/diagonal-traverse/description/
// 498. Diagonal Traverse
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[] result = new int[rows * cols];
        Map<Integer, List<Integer>> diagonal = new HashMap<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int hash = i + j;
                diagonal.putIfAbsent(hash, new ArrayList<>());
                diagonal.get(hash).add(mat[i][j]);
            }
        }

        int idx = 0;
        boolean reverse = true;
        for (int i = 0; i <= diagonal.size(); i++) {
            List<Integer> items = diagonal.getOrDefault(i, new ArrayList<>());
            if (reverse)
                Collections.reverse(items);
            for (int num : items) {
                result[idx++] = num;
            }
            reverse = !reverse;
        }

        return result;
    }
}