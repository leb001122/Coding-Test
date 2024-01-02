package _2024._01.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 해시 테이블 문제
 */
public class jewels_and_stones {

    // HashMap
    public int solution1(String jewels, String stones) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < jewels.length(); i++) {
            map.put(jewels.charAt(i), 0);
        }

        int answer = 0;

        for (int i = 0; i < stones.length(); i++) {
            if (map.containsKey(stones.charAt(i))) {
                answer += 1;
            }
        }
        return answer;
    }

    // HashSet
    public int solution2(String jewels, String stones) {
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < jewels.length(); i++) {
            set.add(jewels.charAt(i));
        }

        int answer = 0;

        for (int i = 0; i < stones.length(); i++) {
            if (set.contains(stones.charAt(i))) {
                answer += 1;
            }
        }
        return answer;
    }

}
