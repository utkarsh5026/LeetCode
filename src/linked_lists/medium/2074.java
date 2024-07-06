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

// https://leetcode.com/problems/reverse-nodes-in-even-length-groups/description/
// 2074. Reverse Nodes in Even Length Groups
class Solution {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;

        int groupLen = 1;

        while (prev.next != null) {
            ListNode start = prev.next;
            ListNode end = prev;

            int count = 0;
            for (int i = 0; i < groupLen; i++) {
                if (end.next == null)
                    break;
                end = end.next;
                count++;
            }

            ListNode nextStart = end.next;

            if (count % 2 == 0) {
                prev.next = reverse(start, count);
                start.next = nextStart;
                prev = start;
            } else {
                prev = end;
            }
            groupLen++;
        }

        return dummy.next;
    }

    ListNode reverse(ListNode head, int steps) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode tail = curr;

        for (int i = 0; i < steps; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        tail.next = curr;
        return prev;
    }
}