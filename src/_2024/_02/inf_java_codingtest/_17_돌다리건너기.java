package _2024._02.inf_java_codingtest;

import java.util.Scanner;

public class _17_돌다리건너기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int result = solution(N);
        System.out.println(result);
    }

    private static int solution(int N) {
        int[] arr = new int[N + 1];
        arr[1] = 2;
        arr[2] = 3;

        for (int i = 3; i <= N; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[N];
    }
}
