package _2024._02.inf_java_codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _20_멘토링 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] test = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                test[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = solution(N, M, test);
        System.out.println(answer);
    }

    private static int solution(int N, int M, int[][] test) {
        int answer = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int count = 0;

                for (int k = 0; k < M; k++) {
                    int pi = 0, pj = 0;
                    for (int l = 0; l < N; l++) {
                        if (test[k][l] == i) pi = l;
                        if (test[k][l] == j) pj = l;
                    }
                    if (pi < pj) count++;
                }
                if (count == M) answer++;
            }
        }
        return answer;
    }
}
