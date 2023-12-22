package _2023._12._3;

import java.util.*;

public class _15_1222 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{""}, new String[]{""}, new String[]{""}));
    }

    public static String solution(String[] bj, String[] one, String[] two) {

        int prize_money = 1_500_000;
        int count;
        String winner = null;

        Map<String, Integer> map = new HashMap<>();

        for (String str : one) {
            map.put(str, 1);
        }
        for (String str : two) {
            map.put(str, 2);
        }

        for (String str : bj) {
            if (!map.containsKey(str)) {
                winner = str;
                break;
            }
        }

        count = one.length * 1 + two.length * 2 + 3;
        prize_money *= count;

        return String.format("%d만원(%s)", prize_money / 10_000, winner);
    }
}
