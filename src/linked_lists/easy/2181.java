package linked_lists.easy;

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

// https://leetcode.com/problems/merge-nodes-in-between-zeros/description/
// 2181. Merge Nodes in Between Zeros
class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode mergedTail = dummyHead;
        ListNode currentNode = head;

        while (currentNode != null) {
            if (currentNode.val == 0) {
                currentNode = currentNode.next;
                int mergedSum = 0;
                while (currentNode != null && currentNode.val != 0) {
                    mergedSum += currentNode.val;
                    currentNode = currentNode.next;
                }
                if (mergedSum > 0) {
                    mergedTail.next.val = mergedSum;
                    mergedTail = mergedTail.next;
                }
            }
        }

        mergedTail.next = null;
        return dummyHead.next;
    }
}