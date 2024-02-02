package _2024._02.inf_java_codingtest;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _02_올바른괄호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        solution(str);
    }

    private static void solution(String str) {
        Deque stack = new ArrayDeque();

        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);

            } else { // 닫는 괄호
                if (stack.isEmpty()) {
                    System.out.println("NO");
                    return;
                }
                stack.pop();
            }
        }
        if (!stack.isEmpty()) {
            System.out.println("NO");
            return;
        }
        System.out.println("YES");
    }
}
