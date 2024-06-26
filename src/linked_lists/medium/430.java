package linked_lists.medium;

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
}

// https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/description/
// 430. Flatten a Multilevel Doubly Linked List
class Solution {
    public Node flatten(Node head) {
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            if (curr.child != null) {
                Node child = flatten(curr.child);

                Node lastChild = getLastNode(child);
                child.prev = curr;
                curr.next = child;
                lastChild.next = next;
                if (next != null)
                    next.prev = lastChild;
            }
            curr.child = null;
            curr = next;
        }
        return head;
    }

    Node getLastNode(Node node) {
        Node curr = node;
        while (curr.next != null) {
            curr = curr.next;
        }
        return curr;
    }
}
