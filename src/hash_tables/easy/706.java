package hash_tables.easy;

import java.util.*;

//https://leetcode.com/problems/design-hashmap/description/
// 706. Design HashMap
class MyHashMap {

    private class Pair {
        int key;
        int value;

        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private class Bucket {
        private List<Pair> bucket;

        public Bucket() {
            this.bucket = new LinkedList<>();
        }

        public Integer get(int key) {
            for (Pair pair : this.bucket) {
                if (pair.key == key)
                    return pair.value;
            }
            return -1; // Not found
        }

        public void update(int key, int value) {
            boolean found = false;
            for (Pair pair : this.bucket) {
                if (pair.key == key) {
                    pair.value = value;
                    found = true;
                    break;
                }
            }
            if (!found) {
                this.bucket.add(new Pair(key, value));
            }
        }

        public void remove(int key) {
            this.bucket.removeIf(pair -> pair.key == key);
        }
    }

    private int keySpace = 2069; // A prime number as the base of modulo
    private List<Bucket> hashTable;

    public MyHashMap() {
        this.hashTable = new ArrayList<>();
        for (int i = 0; i < keySpace; ++i) {
            this.hashTable.add(new Bucket());
        }
    }

    public void put(int key, int value) {
        int hashKey = key % keySpace;
        this.hashTable.get(hashKey).update(key, value);
    }

    public int get(int key) {
        int hashKey = key % keySpace;
        return this.hashTable.get(hashKey).get(key);
    }

    public void remove(int key) {
        int hashKey = key % keySpace;
        this.hashTable.get(hashKey).remove(key);
    }

}
