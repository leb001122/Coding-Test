package _2023._12._4.sw_expert_academy;

import java.io.*;
import java.util.*;

/**
 * 문자열로 이루어진 계산식이 주어질 때, 이 계산식을 후위표기법으로 변환 후 계산 결과를 출력하는 문제
 * - 연산자는 +, * 두 종류이며 괄호가 들어갈 수 있다.
 * - 괄호의 유효성 여부는 항상 옳은 경우만 주어진다.
 * - 피연산자인 숫자는 0~9의 정수만 주어진다.
 */

public class _07_1229_계산기3 {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/_2023/_12/_4/sw_expert_academy/_07_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 우선순위가 높을수록 숫자가 작음
        Map<Character, Integer> isp = new HashMap<>();
        isp.put('(', 3);
        isp.put('*', 1);
        isp.put('+', 2);
        Map<Character, Integer> icp = new HashMap<>();
        icp.put('(', 0);
        icp.put('*', 1);
        icp.put('+', 2);

        for (int test_case = 1; test_case <= 10; test_case++) {
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            sb.append(String.format("#%d %d%n", test_case, getResult(getPostfix(n, str, isp, icp))));
        }
        System.out.println(sb.toString());
        br.close();
    }

    public static ArrayList getPostfix(int n, String s, Map<Character, Integer> isp, Map<Character, Integer> icp) {
        ArrayList<Character> result = new ArrayList<>(n);
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) { // 피연산자이면 출력
                result.add(ch);
            } else if (ch == '(') { // 여는 괄호이면 stack에 push
                stack.push(ch);
            } else if (ch == ')') {// 닫는 괄호이면 왼쪽 괄호가 나올떄까지 pop하여 출력
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.add(stack.pop());
                }
                stack.pop(); // pop '('
            } else { // 연산자이면 자신의 우선순위보다 낮은 연산자가 스택 top에 올때까지 pop하여 출력하고 현재 연산자를 push
                while (!stack.isEmpty() && isp.get(stack.peek()) <= icp.get(ch)) {
                    result.add(stack.pop());
                }
                stack.push(ch);
            }
        }
        // 입력을 모두 읽었으면 스택에 empty될 떄까지 pop하여 출력
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }

    public static int getResult(ArrayList<Character> postfix) {
        Deque<Integer> stack = new ArrayDeque<>();

        int a, b;
        for (char ch : postfix) {
            if (Character.isDigit(ch)) { // 피연산자이면 stack에 push
                stack.push(Character.getNumericValue(ch));
            } else { // 연산자이면 pop을 2회 수행. 연산한 결과를 push
                b = stack.pop();
                a = stack.pop();
                if (ch == '+') {
                    stack.push(a + b);
                } else if (ch == '*') {
                    stack.push(a * b);
                }
            }
        }
        return stack.pop();
    }
}
