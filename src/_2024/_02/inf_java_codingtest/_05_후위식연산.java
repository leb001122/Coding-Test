package _2024._02.inf_java_codingtest;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _05_후위식연산 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int res = postfix(str);
        System.out.println(res);
    }

    private static int postfix(String str) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (char ch : str.toCharArray()) {
            if (Character.isDigit(ch)) {
                stack.push(Character.getNumericValue(ch));
            }
            else {
                int b = stack.pop();
                int a = stack.pop();
                int res = 0;

                if (ch == '+') res = a + b;
                else if (ch == '-') res = a - b;
                else if (ch == '*') res = a * b;
                else if (ch == '/') res = a / b;

                stack.push(res);
            }
        }

        return stack.pop();
    }
}
