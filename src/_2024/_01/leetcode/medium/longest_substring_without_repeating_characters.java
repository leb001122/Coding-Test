package _2024._01.leetcode.medium;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class longest_substring_without_repeating_characters {
    public int lengthOfLongestSubstring(String s) {
        // 문자가 등장한 최종 위치를 저장
        HashMap<Character, Integer> used = new HashMap<>();
        int result = 0; // 부분문자열 최대 길이
        int left = 0;
        int right = 0;

        for (char ch : s.toCharArray()) {
            if (used.containsKey(ch) && left <= used.get(ch)) {
                left = used.get(ch) + 1; // 현재 문자가 기존에 저장되어 있던 위치의 다음 위치로 이동
            }
            else {
                result = Math.max(result, right - left + 1);
            }
            used.put(ch, right);
            right += 1;
        }

        return result;
    }
}
