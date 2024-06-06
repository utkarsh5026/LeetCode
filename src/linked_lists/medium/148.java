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

// https:// leetcode.com/problems/sort-list/description/
// 148. Sort List
class Solution {
    public ListNode sortList(ListNode head) {
        List<Integer> nums = createArrayRepresentation(head);
        Collections.sort(nums);
        ListNode curr = head;
        for (int num : nums) {
            curr.val = num;
            curr = curr.next;
        }
        return head;
    }

    private List<Integer> createArrayRepresentation(ListNode head) {
        ListNode curr = head;
        List<Integer> nums = new ArrayList<>();
        while (curr != null) {
            nums.add(curr.val);
            curr = curr.next;
        }

        return nums;
    }
}