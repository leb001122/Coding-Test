package _2023._12._3;

import java.util.*;

public class _14_1222 {
    public static void main(String[] args) {
        System.out.println(solution("3+26-7"));
    }
    public static int solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        stack.add('+');
        int answer = 0;
        int temp = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                temp = temp * 10 + (ch - '0');

            } else {
                answer = calculate(stack.pop(), answer, temp);
                temp = 0;
                stack.push(ch);
            }
        }
        answer = calculate(stack.pop(), answer, temp);
        return answer;
    }

    private static int calculate(char ch, int result, int num) {
        if (ch == '+') {
            return result += num;
        } else {
            return result -= num;
        }
    }
}
