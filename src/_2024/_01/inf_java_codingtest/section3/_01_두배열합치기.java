package _2024._01.inf_java_codingtest.section3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _01_두배열합치기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int[] res = solution(input(br), input(br));
        int[] res = solution2(input(br), input(br));

        StringBuilder sb = new StringBuilder();
        for (int item : res) {
            sb.append(item + " ");
        }
        System.out.print(sb);
    }

    public static int[] input(BufferedReader br) throws IOException {
        int size = Integer.parseInt(br.readLine());
        int[] arr = new int[size];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        return arr;
    }

    public static int[] solution(int[] a, int[] b) {
        int a_len = a.length;
        int b_len = b.length;
        int[] res = new int[a_len + b_len];

        for (int i = 0; i < a_len; i++) {
            res[i] = a[i];
        }
        for (int i = a_len, j = 0; i < a_len + b_len; i++, j++) {
            res[i] = b[j];
        }
        Arrays.sort(res);
        return res;
    }

    public static int[] solution2(int[] a, int[] b) {
        int a_len = a.length;
        int b_len = b.length;
        int[] res = new int[a_len + b_len];
        int p1 = 0, p2 = 0; // two pointers
        int idx = 0;

        while (p1 < a_len && p2 < b_len) {
            if (a[p1] <= b[p2]) {
                res[idx] = a[p1];
                p1++;
            } else {
                res[idx] = b[p2];
                p2++;
            }
            idx++;
        }
        // 남은 원소 결과 배열에 복사
        for (int i = p1; i < a_len; i++, idx++) {
            res[idx] = a[i];
        }
        for (int i = p2; i < b_len; i++, idx++) {
            res[idx] = b[i];
        }
        return res;
    }
}

