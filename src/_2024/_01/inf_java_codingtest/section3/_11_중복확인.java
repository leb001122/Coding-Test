package _2024._01.inf_java_codingtest.section3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class _11_중복확인 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(arr));
        System.out.println(solution2(arr));
    }

    private static char solution(int[] arr) {
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i+1]) {
                return 'D';
            }
        }
        return 'U';
    }

    private static char solution2(int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        for (int item : arr) {
            if (set.contains(item)) {
                return 'D';
            }
            set.add(item);
        }
        return 'U';
    }
}
