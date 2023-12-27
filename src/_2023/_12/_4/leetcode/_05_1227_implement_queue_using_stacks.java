package _2023._12._4.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

// 두 개의 스택을 이용하여 큐 구현
public class _05_1227_implement_queue_using_stacks {
}


class MyQueue {

    // 삽입할 때 사용하는 스택 선언
    Deque<Integer> input = new ArrayDeque<>();
    // 추출할 때 사용하는 스택 선언
    Deque<Integer> output = new ArrayDeque<>();

    public MyQueue() {}

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        peek();
        return output.pop();
    }

    public int peek() {
        // 추출 스택에 저장된 요소가 없다면 진행
        if (output.isEmpty()) {
            // 삽입 스택이 비워질 때까지 진행
            while (!input.isEmpty()) {
                // 삽입 스택에서 추출한 결과를 추출 스택에 삽입 (역순으로 저장된다.)
                output.push(input.pop());
            }
        }
        return output.peek();
    }

    public boolean empty() {
        // 두 스택이 모두 비어야 비어있는 것으로 처리
        return input.isEmpty() && output.isEmpty();
    }
}