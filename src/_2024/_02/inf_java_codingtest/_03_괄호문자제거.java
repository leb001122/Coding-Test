package _2024._02.inf_java_codingtest;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _03_괄호문자제거 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        solution(str);
    }

    public static void solution(String str) {
        Deque<Character> stack = new ArrayDeque();

        for (char ch : str.toCharArray()) {
            if (Character.isAlphabetic(ch) || ch == '(') {
                stack.push(ch);
            }
            else { // 닫는 괄호가 나오면 여는괄호가 나올 때까지 stack에서 문자를 뺀다.
                while (!stack.isEmpty() && stack.peek() != '(') {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character ch : stack) {
            sb.append(ch);
        }
        String res = sb.reverse().toString();
        System.out.println(res);
    }
}
