package _2024._01.inf_java_codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _09_삽입정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] res = insertionSort(arr, N);
        for (int i = 0; i < N; i++) {
            System.out.print(res[i] + " ");
        }

    }

    private static int[] insertionSort(int[] arr, final int N) {
        for (int i = 1; i < N; i++) {
            int newItem = arr[i];
            int j = i - 1;

            while (j >= 0 && newItem < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = newItem;
        }

        return arr;
    }

}
