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

// https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list/description/
// 2807. Insert Greatest Common Divisors in Linked List
class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode start = head;
        while (start.next != null) {
            ListNode currNext = start.next;
            int gcd = gcd(start.val, start.next.val);
            ListNode node = new ListNode(gcd);
            start.next = node;
            node.next = currNext;
            start = currNext;
        }
        return head;
    }

    int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}