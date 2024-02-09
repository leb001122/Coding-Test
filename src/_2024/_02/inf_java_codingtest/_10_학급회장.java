package _2024._02.inf_java_codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _10_학급회장 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        solution(N, str);
    }

    private static void solution(int N, String str) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        Character key = Collections.max(map.entrySet(), (o1, o2) -> o1.getValue() - o2.getValue()).getKey();
        System.out.println(key);

//        char answer = MIN_VALUE;
//        int max = 0;
//        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
//            if (entry.getValue() > max) {
//                answer = entry.getKey();
//                max = entry.getValue();
//            }
//        }
//        System.out.println(answer);
    }
}

