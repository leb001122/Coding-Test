package _2023._12._3;

import java.util.ArrayDeque;
import java.util.Deque;

public class _11_1222 {
    public static void main(String[] args) {
        System.out.println(solution("cdeaaaf1233"));
    }
    public static String solution(String s) {

        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            if (stack.isEmpty() || stack.peek() != ch) {
                stack.push(ch);
            } else {
                stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }
}
