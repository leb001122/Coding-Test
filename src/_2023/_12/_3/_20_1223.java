package _2023._12._3;

import java.util.Arrays;
import java.util.stream.Collectors;

public class _20_1223 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"naver", "kakao"}));
    }

    public static String solution(String[] arr) {
        return Arrays.stream(arr).collect(Collectors.joining(",")).toString();
    }
}
