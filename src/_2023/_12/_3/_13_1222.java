package _2023._12._3;

import java.util.ArrayDeque;
import java.util.Deque;

public class _13_1222 {
    public static void main(String[] args) {
        System.out.println(solution("AABBA"));
    }
    public static int solution(String S) {

        Deque<Character> stack = new ArrayDeque();
        char[] arr = S.toCharArray();
        stack.push(arr[0]);

        for (int i = 1; i < arr.length; i++) {

            if (stack.isEmpty() || stack.peek() != arr[i]) {
                stack.push(arr[i]);
            }
            else {
                stack.pop();
            }
        }

        return (stack.size() == 0) ? 1 : 0;
    }
}
