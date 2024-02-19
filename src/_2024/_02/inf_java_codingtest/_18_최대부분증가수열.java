package _2024._02.inf_java_codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _18_최대부분증가수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = solution(N, arr);
        System.out.println(result);
    }

    private static int solution(int N, int[] arr) {

        int result = 0;
        int[] dy = new int[N];
        dy[0] = 1;

        for (int i = 1; i < N; i++) {
            int tmp = 1;

            for (int j = i-1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    tmp = Math.max(tmp, dy[j] + 1);
                }
            }
            dy[i] = tmp;
            result = Math.max(result, dy[i]);
        }

        return result;
    }
}
