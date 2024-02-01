package _2024._01.inf_java_codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _07_선택정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] res = selectionSort(arr, N);
        for (int i = 0; i < N; i++) {
            System.out.print(res[i] + " ");
        }
    }

    public static int[] selectionSort(int[] arr, final int N) {
        int maxIdx;
        for (int last = N-1; last >= 1; last--) {

            maxIdx = 0;
            for (int i = 1; i <= last; i++) {
                if (arr[i] > arr[maxIdx]) {
                    maxIdx = i;
                }
            }
            swap(arr, last, maxIdx);
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
