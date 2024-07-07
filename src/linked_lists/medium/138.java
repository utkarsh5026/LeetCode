package linked_lists.medium;

import java.util.*;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

// https://leetcode.com/problems/copy-list-with-random-pointer/description/
// 138. Copy List with Random Pointer
class Solution {
    public Node copyRandomList(Node head) {

        if (head == null)
            return null;

        Map<Node, Node> originalToCopy = new HashMap<>();
        Node curr = head;

        while (curr != null) {
            originalToCopy.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            originalToCopy.get(curr).next = originalToCopy.get(curr.next);
            originalToCopy.get(curr).random = originalToCopy.get(curr.random);
            curr = curr.next;
        }

        return originalToCopy.get(head);
    }
}