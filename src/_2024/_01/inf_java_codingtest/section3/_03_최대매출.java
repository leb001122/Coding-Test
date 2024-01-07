package _2024._01.inf_java_codingtest.section3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _03_최대매출 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int res = solution(K, arr);
        System.out.println(res);
    }

    public static int solution(int k, int[] arr) {
        int sum = 0;
        for (int i = 0; i <= k-1; i++) {
            sum += arr[i];
        }
        int max = sum;

        for (int i = k; i < arr.length; i++) {
            sum -= arr[i - k];
            sum += arr[i];
            max = Math.max(max, sum);
        }
        return max;
    }
}
