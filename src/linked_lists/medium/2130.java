package linked_lists.medium;

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

// https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/description/
// 2130. Maximum Twin Sum of a Linked List
class Solution {
    public int pairSum(ListNode head) {
        int length = getLength(head);
        int[] vals = new int[length];
        fillVals(vals, head);
        return findMaxTwinSum(vals);
    }

    private int getLength(ListNode head) {
        int length = 0;
        ListNode curr = head;

        while (curr != null) {
            length++;
            curr = curr.next;
        }
        return length;
    }

    private void fillVals(int[] vals, ListNode head) {
        for (int i = 0; i < vals.length; i++) {
            vals[i] = head.val;
            head = head.next;
        }
    }

    private int findMaxTwinSum(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        int maxTwinSum = Integer.MIN_VALUE;

        while (start < end) {
            int fromStart = nums[start];
            int fromEnd = nums[end];

            maxTwinSum = Math.max(maxTwinSum, fromStart + fromEnd);
            start++;
            end--;
        }

        return maxTwinSum;
    }
}
