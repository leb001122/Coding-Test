package _2024._02.inf_java_codingtest;

import java.util.*;

public class _07_공주구하기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int result = solution(N, K);
        System.out.println(result);

    }

    private static int solution(int N, int K) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        while (!queue.isEmpty()) {
            for (int i = 1; i < K; i++) {
                queue.offer(queue.poll());
            }
            queue.poll();
            if (queue.size() == 1) answer = queue.poll();
        }
        return answer;
    }
}
