package _2024._02.inf_java_codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _06_쇠막대기 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int result = solution(str);
        System.out.println(result);
    }

    private static int solution(String str) {
        int count = 0;
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(') {
                if (str.charAt(i + 1) == ')') { // 레이저
                    if (!stack.isEmpty()) {
                        stack.push('R');
                    }
                    i++;
                }
                else {
                    stack.push(ch);
                }

            } else if (ch == ')') {
                int laserCount = 0;
                while (!stack.isEmpty() && stack.peek() == 'R') {
                    stack.pop();
                    laserCount++;
                }
                stack.pop(); // 여는 괄호를 뽑는다.
                count += (laserCount + 1); // 잘린 막대기 개수는 레이저의 개수 + 1개

                // 레이저는 스택이 비어있지 않다면 다시 넣는다.
                if (!stack. isEmpty()) {
                    while (laserCount != 0) {
                        stack.push('R');
                        laserCount--;
                    }
                }
            }
        }
        return count;
    }
}
