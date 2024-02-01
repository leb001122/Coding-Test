package _2024._01.inf_java_codingtest;

import java.util.Scanner;

public class _05_연속된자연수의합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        System.out.println(solution(N));
        System.out.println("=========================");
        System.out.println(solution2(N));
        System.out.println("=========================");
        System.out.println(solution3(N));
    }

    // O(nlogn)
    private static int solution(int N) {
        int count = 0; // result

        int n = (N % 2 == 0) ? (N / 2 - 1) : (N / 2 + 1);
        for (int i = 1; i < n; i++) {
            int sum = 0;

            for (int j = i; j <= n && sum < N; j++) {
                sum += j;
            }
            if (sum == N) {
                count++;
            }
        }
        return count;
    }

    // two pointers O(n)
    private static int solution2(int N) {
        int[] arr = new int[(N % 2 == 0) ? (N / 2 - 1) : (N / 2 + 1)];
        int count = 0;
        int sum = 0; // left부터 right까지의 합
        int left = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];
            if (sum == N) {
                count++;
            }
            while (sum >= N) {
                sum -= arr[left++]; // sum에서 left를 빼고 left를 오른쪽으로 이동
                if (sum == N) {
                    count++;
                }
            }
        }
        return count;
    }

    // 수학 풀이
    private static int solution3(final int N) {
        int count = 0; // result
        int i = 1;
        int n = N - 1;

        while (n > 0) {
            i++;
            n -= i;
            if (n % i == 0) count++;
        }
        return count;
    }
}
