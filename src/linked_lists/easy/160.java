package linked_lists.easy;

import java.util.*;

class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

// https://leetcode.com/problems/intersection-of-two-linked-lists/description/
// 160. Intersection of Two Linked Lists
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> aset = new HashSet<>();

        while (headA != null) {
            aset.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (aset.contains(headB))
                return headB;
            headB = headB.next;
        }

        return null;
    }
}