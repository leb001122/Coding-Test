package _2024._02.inf_java_codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _04_크레인인형뽑기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        for (int i = 0; i < N; i++) {
            board[i] = new int[N];
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int M = Integer.parseInt(br.readLine());
        int[] moves = new int[M];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            moves[i] = Integer.parseInt(st.nextToken());
        }

//        int result = solution(N, board, moves);
        int result = solution2(N, board, moves);
        System.out.println(result);
    }

    private static int solution(int N, int[][] board, int[] moves) {

        Deque<Integer> basket = new ArrayDeque<>();
        ArrayList<Deque<Integer>> list = new ArrayList<>(N);
        int count = 0; // result / 2

        for (int i = 0; i < N; i++) {
            Deque stack = new ArrayDeque();

            for (int j = N - 1; j >= 0; j--) {
                int item = board[j][i];
                if (item != 0) stack.push(item);
            }
            list.add(stack);
        }


        for (int idx : moves) {
            Deque<Integer> stack = list.get(idx - 1);
            if (stack.isEmpty()) continue;
            int item = stack.pop();

            if (!basket.isEmpty() && item == basket.peek()) {
                basket.pop();
                count++;
            } else {
                basket.push(item);
            }
        }

        return count * 2;
    }

    // board int 이차원 배열에서 바로하기
    private static int solution2(int N, int[][] board, int[] moves) {
        int count = 0;
        Deque<Integer> basket = new ArrayDeque<>();

        for (int pos : moves) {
            int item = -1;

            for (int i = 0; i < N; i++) {
                if (board[i][pos - 1] != 0) {
                    item = board[i][pos - 1];
                    board[i][pos - 1] = 0;
                    break;
                }
            }

            if (item == -1) continue;

            if (!basket.isEmpty() && item == basket.peek()) {
                basket.pop();
                count++;
            } else {
                basket.push(item);
            }
        }

        return count * 2;
    }
}
