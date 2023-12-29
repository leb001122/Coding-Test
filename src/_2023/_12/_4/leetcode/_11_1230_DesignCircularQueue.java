package _2023._12._4.leetcode;

public class _11_1230_DesignCircularQueue {

    private int[] queue;
    private int front = 0;
    private int rear = -1;
    private int size = 0;

    public _11_1230_DesignCircularQueue(int k) {
        queue = new int[k];
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = value;
        size += 1;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % queue.length;
        size -= 1;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return queue[front];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return queue[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == queue.length;
    }
}
