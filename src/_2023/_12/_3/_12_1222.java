package _2023._12._3;

import java.util.*;
public class _12_1222 {
    public int solution(String S) {

        Map<Character, Character> map = new HashMap();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        map.put('>', '<');

        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : S.toCharArray()) {
            if (!map.containsKey(ch)) {
                stack.push(ch);
            } else if (stack.isEmpty() || stack.pop() != map.get(ch)) {
                return 0;
            }
        }

        return (stack.isEmpty()) ? 1 : 0;
    }
}
