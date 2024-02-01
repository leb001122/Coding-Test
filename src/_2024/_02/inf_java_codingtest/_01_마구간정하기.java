package _2024._02.inf_java_codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _01_마구간정하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int res = solution(N, C, arr);
        System.out.println(res);
    }

    private static int solution(int N, int C, int[] arr) {
        Arrays.sort(arr);
        int lt = 1;
        int rt = arr[N - 1];
        int result = 1;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            int count = count(N, arr, mid);

            if (count >= C) { // 유효함
                result = Math.max(result, mid);
                // 더 큰 경우를 살펴본다.
                lt = mid + 1;

            } else { // 유효하지 않음
                // 더 작은 경우를 살펴본다.
                rt = mid - 1;
            }
        }
        return result;
    }

    private static int count(int N, int[] arr, int distance) {
        int ep = 0; // end position
        int count = 1; // 말 배치 count

        for (int i = 1; i < N; i++) {
            if (arr[i] - arr[ep] >= distance) {
                ep = i;
                count++;
            }
        }
        return count;
    }
}
