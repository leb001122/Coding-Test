package _2024._01.inf_java_codingtest.section3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _12_장난꾸러기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] res = solution(arr, N);
        System.out.println(res[0] + " " + res[1]);

        br.close();
    }

    private static int[] solution(int[] arr, int N) {
        int[] res = new int[2];

        int i = 0;
        while (arr[i] <= arr[i+1]) {
            i++;
        }
        while (arr[i-1] == arr[i]) {
            i--;
        }
        res[0] = i + 1;

        i = N-1;
        while (arr[i-1] <= arr[i]) {
            i--;
        }
        res[1] = i + 1;

        return res;
    }
}
