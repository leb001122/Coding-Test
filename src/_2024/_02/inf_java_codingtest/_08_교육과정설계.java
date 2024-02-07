package _2024._02.inf_java_codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _08_교육과정설계 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String required = br.readLine();
        String all = br.readLine();

        String result = solution(required, all);
        System.out.println(result);
    }

    private static String solution(String required, String all) {

        Queue<Character> queue = new LinkedList<>();

        for (char ch : required.toCharArray()) {
            queue.offer(ch);
        }

        for (char ch : all.toCharArray()) {
            if (queue.contains(ch)) {
                if (queue.poll() != ch) {
                    return "NO";
                }
            }
        }

        if (!queue.isEmpty()) {
            return "NO";
        } else {
            return "YES";
        }
    }
}
