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

// https://leetcode.com/problems/reorder-list/description/
// 143. Reorder List
class Solution {
    public void reorderList(ListNode head) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode curr = head;

        while (curr != null) {
            nodes.add(curr);
            curr = curr.next;
        }

        int left = 0;
        int right = nodes.size() - 1;

        while (left < right) {
            ListNode begin = nodes.get(left);
            ListNode end = nodes.get(right);

            begin.next = end;
            end.next = null;
            if (left + 1 < right)
                end.next = nodes.get(left + 1);

            left++;
            right--;
        }

        if (left == right)
            nodes.get(left).next = null;
    }

}