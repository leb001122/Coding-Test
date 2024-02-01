package _2024._01.inf_java_codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _06_최대길이연속부분수열 {
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

    public static int solution(final int K, int[] arr) {
        int maxLen = 0; // result
        int left = 0, right;
        int cnt = 0; // 0을 1로 바꾼 횟수

        for (right = 0; right < arr.length; right++) {
            if (arr[right] == 0) cnt++;

            while (cnt > K) {
                if (arr[left] == 0) cnt--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
