package _2023._12._4.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _04_1227_implement_stack_using_queues {

}

//  push() 할 때 큐를 이용하여 재정렬
class MyStack {
    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
        for (int i = 1; i < queue.size(); i++) {
            queue.add(queue.remove());
        }
    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.size() == 0;
    }
}