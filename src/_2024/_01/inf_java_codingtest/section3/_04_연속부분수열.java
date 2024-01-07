package _2024._01.inf_java_codingtest.section3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _04_연속부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(M, arr));
    }

    public static int solution(int M, int[] arr) {

        int left = 0, sum = 0, count = 0;

        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];
            if (sum == M) {
                count++;
            }
            while (sum >= M) {
                sum -= arr[left++];
                if (sum == M) {
                    count++;
                }
            }
        }
        return count;
    }
}
