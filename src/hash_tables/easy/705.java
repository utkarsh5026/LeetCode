package hash_tables.easy;

// https:// leetcode.com/problems/design-hashset/description/
// 705. Design HashSet
class MyHashSet {

    private class Node {
        int key;
        Node next;

        Node(int key) {
            this.key = key;
            this.next = null;
        }
    }

    private Node[] buckets;
    private int keySpace;

    public MyHashSet() {
        keySpace = 2069;
        buckets = new Node[keySpace];
    }

    private int hash(int key) {
        return key % keySpace;
    }

    public void add(int key) {
        int bucketIndex = hash(key);
        Node head = buckets[bucketIndex];
        Node curr = head;
        while (curr != null) {
            if (curr.key == key)
                return;
            curr = curr.next;
        }
        Node newNode = new Node(key);
        newNode.next = head;
        buckets[bucketIndex] = newNode;
    }

    public void remove(int key) {
        int bucketIndex = hash(key);
        Node head = buckets[bucketIndex];
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            if (curr.key == key) {
                if (prev == null) {
                    buckets[bucketIndex] = curr.next;
                } else {
                    prev.next = curr.next;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public boolean contains(int key) {
        int bucketIndex = hash(key);
        Node curr = buckets[bucketIndex];
        while (curr != null) {
            if (curr.key == key) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }
}
