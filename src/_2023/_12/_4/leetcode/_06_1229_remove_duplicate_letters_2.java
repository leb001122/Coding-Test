package _2023._12._4.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

// 스택 풀이
public class _06_1229_remove_duplicate_letters_2 {

    public String removeDuplicateLetters(String s) {

        Map<Character, Integer> counter = new HashMap<>();
        Map<Character, Boolean> seen = new HashMap<>();
        Deque<Character> deque = new ArrayDeque<>();
        char[] charArr = s.toCharArray();

        for (char ch : charArr) {
            counter.put(ch, counter.getOrDefault(ch, 0) + 1);
        }

        for (char ch : charArr) {
            // 현재 처리하는 문자는 카운터에서 -1 처리
            counter.put(ch, counter.get(ch) - 1);

            // 이미 처리한 문자는 건너뛴다.
            if (seen.get(ch) != null && seen.get(ch) == true) {
                continue;
            }

            // 스택에 있는 문자가 현재 문자보다 더 뒤에 붙여야할 문자라면 스택에서 제거하고 처리하지 않은 것으로 표시
            while (!deque.isEmpty() && deque.peek() > ch && counter.get(deque.peek()) > 0) {
                seen.put(deque.pop(), false);
            }

            // 현재 문자를 스택에 삽입
            deque.push(ch);
            // 현재 문자를 처리한 것으로 표시
            seen.put(ch, true);
        }

        // 스택의 문자를 큐 순서대로 추출하여 리던
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.pollLast());
        }
        return sb.toString();
    }
}
