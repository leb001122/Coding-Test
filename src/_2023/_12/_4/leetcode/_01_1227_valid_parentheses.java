package _2023._12._4.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class _01_1227_valid_parentheses {

    public boolean isValid(String s) {

        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for (char ch : s.toCharArray()) {
            if (!map.containsKey(ch)) { // 여는 괄호인 경우
                stack.push(ch);

            } else if(stack.isEmpty() || map.get(ch) != stack.pop()) {   // 닫는 괄호인 경우
                return false;
            }
        }
        return stack.isEmpty();
    }
}
