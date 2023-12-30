package _2023._12._4.leetcode;

// DoublyLinkedList로 구현
public class _13_1230_DesignCircularDequeue_2 {

    Node head;
    Node tail;
    int size;
    int capacity;

    public _13_1230_DesignCircularDequeue_2(int k) {
        size = 0;
        capacity = k;
    }

    public boolean insertFront(int value) {
        if (isFull())
            return false;

        Node newNode = new Node(value);

        newNode.next = head.next;
        head.next = newNode;
        newNode.next.prev = newNode;
        newNode.prev = head;
        size += 1;

        return true;
    }

    public boolean insertLast(int value) {
        if (isFull())
            return false;

        Node newNode = new Node(value);

        newNode.prev = tail.prev;
        tail.prev = newNode;
        newNode.prev.next = newNode;
        newNode.next = tail;
        size += 1;

        return true;
    }

    public boolean deleteFront() {
        if (isEmpty())
            return false;

        head.next = head.next.next;
        head.next.prev = head;
        size -= 1;

        return true;
    }

    public boolean deleteLast() {
        if (isEmpty())
            return false;

        tail.prev = tail.prev.prev;
        tail.prev.next = tail;
        size -= 1;

        return true;
    }

    public int getFront() {
        if (isEmpty())
            return -1;

        return head.next.val;
    }

    public int getRear() {
        if (isEmpty())
            return -1;

        return tail.prev.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    static class Node {
        Node prev;
        Node next;
        int val;

        public Node(int val) {
            this.val = val;
        }
    }
}
