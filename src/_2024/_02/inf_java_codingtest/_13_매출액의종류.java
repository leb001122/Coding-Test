package _2024._02.inf_java_codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _13_매출액의종류 {
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

        int[] result = solution(N, K, arr);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    private static int[] solution(int N, int K, int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[N - K + 1];

        for (int i = 0; i < K; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        result[0] = map.size();

        for (int i = 1; i <= (N - 1) - (K - 1); i++) {
            int lt = i - 1;
            int rt = i + K - 1;

            // 전에 있던건 빼고
            map.put(arr[lt], map.get(arr[lt]) - 1);
            if (map.get(arr[lt]) == 0) {
                map.remove(arr[lt]);
            }

            // 새로 나온거 추가
            if (map.containsKey(arr[rt])) {
                map.put(arr[rt], map.get(arr[rt]) + 1);
            } else {
                map.put(arr[rt], 1);
            }
            result[i] = map.size();
        }

        return result;
    }
}
