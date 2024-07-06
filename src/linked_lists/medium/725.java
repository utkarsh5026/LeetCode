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

// https://leetcode.com/problems/split-linked-list-in-parts/description/
// 725. Split Linked List in Parts
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int length = length(head);
        ListNode[] splits = new ListNode[k];

        int splitSize = length / k;
        int plusOne = length % k;
        int notPlusOne = k - plusOne;

        int idx = 0;
        head = fillArr(splits, idx, head, plusOne, splitSize + 1);
        fillArr(splits, idx + plusOne, head, notPlusOne, splitSize);
        return splits;
    }

    int length(ListNode head) {
        int n = 0;
        while (head != null) {
            head = head.next;
            n++;
        }
        return n;
    }

    ListNode fillArr(ListNode[] arr, int idx, ListNode head, int loop, int size) {
        for (int i = 0; i < loop; i++) {
            ListNode last = head;
            arr[idx++] = last;
            for (int j = 0; j < size - 1; j++) {
                if (last == null)
                    break;
                last = last.next;
            }

            if (last != null) {
                head = last.next;
                last.next = null;
            }
        }

        return head;
    }
}