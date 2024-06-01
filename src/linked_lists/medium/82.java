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

// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
// 82. Remove Duplicates from Sorted List II
class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        Map<Integer, Integer> hMap = new HashMap<>();
        ListNode curr = head;

        while (curr != null) {
            int val = curr.val;
            hMap.computeIfAbsent(val, cnt -> 0);
            hMap.computeIfPresent(val, (c, cnt) -> cnt + 1);
            curr = curr.next;
        }

        curr = head;

        ListNode start = new ListNode(0);

        while (curr != null) {
            if (hMap.get(curr.val) == 1) {
                start.next = new ListNode(curr.val);
                start = start.next;
            } else {
                while (curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }
            }

            curr = curr.next;
        }
        return start.next;
    }
}