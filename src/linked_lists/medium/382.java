package linked_lists.medium;

import java.util.Random;

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

// https://leetcode.com/problems/linked-list-random-node/description/
// 382. Linked List Random Node
class Solution {
    private ListNode head;
    private Random random;

    public Solution(ListNode head) {
        this.head = head;
        this.random = new Random();
    }

    public int getRandom() {
        int result = head.val;
        ListNode current = head.next;
        int i = 2;

        while (current != null) {
            if (random.nextInt(i) == 0) {
                result = current.val;
            }
            current = current.next;
            i++;
        }

        return result;
    }
}