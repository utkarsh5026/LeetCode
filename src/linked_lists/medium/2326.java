package linked_lists.medium;

import java.util.Arrays;

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

// https://leetcode.com/problems/spiral-matrix-iv/description/
// 2326. Spiral Matrix IV
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];

        for (int i = 0; i < matrix.length; i++) {
            Arrays.fill(matrix[i], -1);
        }

        if (head == null)
            return matrix;

        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = m - 1;

        while (left <= right && top <= bottom) {
            for (int i = left; i <= right && head != null; i++) {
                matrix[top][i] = head.val;
                head = head.next;
            }
            top++;

            for (int i = top; i <= bottom && head != null; i++) {
                matrix[i][right] = head.val;
                head = head.next;
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left && head != null; i--) {
                    matrix[bottom][i] = head.val;
                    head = head.next;
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top && head != null; i--) {
                    matrix[i][left] = head.val;
                    head = head.next;
                }
                left++;
            }
        }

        return matrix;
    }
}