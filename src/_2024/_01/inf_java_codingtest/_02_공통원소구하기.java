package _2024._01.inf_java_codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _02_공통원소구하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        ArrayList<Integer> res = solution(input(br), input(br));
        for (Integer item : res) {
            sb.append(item + " ");
        }
        System.out.print(sb);
    }

    public static int[] input(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        int[] arr = new int[len];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        return arr;
    }

    public static ArrayList<Integer> solution(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);

        ArrayList<Integer> res = new ArrayList<>(a.length + b.length);
        int p1 = 0, p2 = 0; // two pointers

        while (p1 < a.length && p2 < b.length) {
            if (a[p1] < b[p2]) {
                p1 += 1;
            }
            else if (a[p1] > b[p2]) {
                p2 += 1;
            }
            else {
                res.add(a[p1]);
                p1 += 1;
                p2 += 1;
            }
        }
        return res;
    }
}
