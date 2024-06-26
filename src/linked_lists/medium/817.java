package linked_lists.medium;

import java.util.*;

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

// https://leetcode.com/problems/linked-list-components/description/
// 817. Linked List Components
class Solution {
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            numsSet.add(nums[i]);
        }

        int connected = 0;

        ListNode curr = head;

        while (curr != null) {
            if (!numsSet.contains(curr.val)) {
                curr = curr.next;
                continue;
            }

            while (curr != null && numsSet.contains(curr.val)) {
                numsSet.remove(curr.val);
                curr = curr.next;
            }

            connected++;
        }
        return connected;
    }
}