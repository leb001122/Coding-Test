package _2024._01.inf_java_codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15_뮤직비디오 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, M, arr));
    }

    private static int solution(int N, int M, int[] arr) {
        int answer = 0;
        int left = arr[0]; // max value
        int right = arr[0]; // sum

        for (int i = 1; i < N; i++) {
            if (left < arr[i]) left = arr[i];
            right += arr[i];
        }

        while (left <= right) {
            int mid = (left + right) / 2;

            if (count(N, M, mid, arr) > M) { // 불만족
                left = mid + 1;
            } else {                         // 만족
                right = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }

    private static int count(int N, int M, int mid, final int[] arr) {
        int count = 1;
        int sum = 0;

        for (int item : arr) {
            if (sum + item > mid) {
                count++;
                sum = item;
            } else {
                sum += item;
            }

            if (count > M) {
                break;
            }
        }
        return count;
    }
}
