package linked_lists.medium;

import java.util.ArrayList;
import java.util.List;

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

// https://leetcode.com/problems/partition-list/description/
// 86. Partition List
class Solution {
    public ListNode partition(ListNode head, int x) {
        List<Integer> smaller = new ArrayList<>();
        List<Integer> larger = new ArrayList<>();

        ListNode curr = head;

        while (curr != null) {
            int val = curr.val;
            if (val < x)
                smaller.add(val);
            else
                larger.add(val);
            curr = curr.next;
        }
        return getPartitionedList(smaller, larger, head);
    }

    private ListNode getPartitionedList(List<Integer> smaller, List<Integer> larger, ListNode head) {

        ListNode curr = head;
        for (int num : smaller) {
            curr.val = num;
            curr = curr.next;
        }

        for (int num : larger) {
            curr.val = num;
            curr = curr.next;
        }
        return head;
    }
}
