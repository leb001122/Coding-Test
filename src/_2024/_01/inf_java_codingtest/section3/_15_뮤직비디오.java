package _2024._01.inf_java_codingtest.section3;

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

        int res = solution(N, M, arr);
    }

    private static int solution(int N, int M, int[] arr) {
        int[] sumArr = new int[M];
        int[] startIdxArr = new int[M];

        init(N, M, arr, sumArr, startIdxArr);
        if (M == 1) {
            return sumArr[0];
        }

        int result;
        int maxIdx;

        while (true) {
            maxIdx = 0;
            for (int i = 1; i < M; i++) {
                if (sumArr[maxIdx] < sumArr[i]) {
                    maxIdx = i;
                }
            }

            if (startIdxArr[maxIdx+1] - startIdxArr[maxIdx] == 1 || N - startIdxArr[maxIdx] == 1) {
                result = sumArr[maxIdx];
                break;
            }

            if (maxIdx == 0) {
                int temp = arr[startIdxArr[maxIdx + 1] - 1];
                sumArr[maxIdx] -= temp;
                sumArr[maxIdx + 1] += temp;
                startIdxArr[maxIdx + 1] -= 1;

            } else if (maxIdx == N - 1) {
                int temp = arr[startIdxArr[maxIdx]];
                sumArr[maxIdx] -= temp;
                sumArr[maxIdx - 1] += temp;
                startIdxArr[maxIdx] += 1;

            }else {

                int temp = Math.min(arr[startIdxArr[maxIdx]], arr[startIdxArr[maxIdx + 1] - 1]);

            }

        }

        return result;
    }

    private static void init(int N, int M, int[] arr, int[] sumArr, int[] startIdxArr) {

        int i = 0, j = 0;
        for (;i < M; i++) {
            startIdxArr[i] = j;
            for (int k = 0; k < N/M; k++) {
                sumArr[i] += arr[j++];
            }
        }
        while (j < N) {
            sumArr[i-1] += arr[j++];
        }
    }
}
