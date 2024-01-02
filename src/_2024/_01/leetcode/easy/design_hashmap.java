package _2024._01.leetcode.easy;

// Separate Chaining 방식
public class design_hashmap {
    Node[] hashTable;

    public design_hashmap() {
        hashTable = new Node[1_000_000];
    }

    public void put(int key, int value) {
        int idx = getHash(key);
        Node cur = hashTable[idx];

        if (cur == null) {
            hashTable[idx] = new Node(key, value, null);
            return;
        }

        while (cur != null) {
            if (cur.key == key) {
                cur.value = value;
                return;
            }
            cur = cur.next;
        }
        hashTable[idx] = new Node(key, value, hashTable[idx]);
    }

    public int get(int key) {
        int idx = getHash(key);
        Node cur = hashTable[idx];

        while (cur != null) {
            if (cur.key == key) {
                return cur.value;
            }
            cur = cur.next;
        }
        return -1;
    }

    public void remove(int key) {
        int idx = getHash(key);
        Node cur = hashTable[idx];
        Node prev = cur;

        if (cur == null) {
            return;
        }

        if (cur.key == key) {
            hashTable[idx] = cur.next;
            return;
        }

        cur = cur.next;
        while (cur != null) {
            if (cur.key == key) {
                prev.next = cur.next;
                break;
            }
            prev = cur;
            cur = cur.next;
        }
    }

    private int getHash(int key) {
        return key % hashTable.length;
    }

    static class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

}
