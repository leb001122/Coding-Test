package _2023._12._4.leetcode;


// 배열로 구현
public class _12_1230_DesignCircularDequeue {

    int[] dequeue;
    int size;
    int front;
    int rear;

    public _12_1230_DesignCircularDequeue(int k) {
        dequeue = new int[k];
        size = 0;
        front = 0;
        rear = -1;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        if (front == 0) {
            front = dequeue.length - 1;
        } else {
            front -= 1;
        }
        dequeue[front] = value;
        size += 1;
        if (size == 1) {
            rear = front;
        }
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        rear = (rear + 1) % dequeue.length;
        dequeue[rear] = value;
        size += 1;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % dequeue.length;
        size -= 1;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        if (rear == 0) {
            rear = dequeue.length - 1;
        } else {
            rear -= 1;
        }
        size -= 1;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return dequeue[front];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return dequeue[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == dequeue.length;
    }

}
