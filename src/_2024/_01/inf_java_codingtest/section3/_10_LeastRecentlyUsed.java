package _2024._01.inf_java_codingtest.section3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;

public class _10_LeastRecentlyUsed {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] tasks = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tasks[i] = Integer.parseInt(st.nextToken());
        }
        int[] res = lru(S, tasks);
        for (int i = 0; i < S; i++) {
            System.out.print(res[i] + " ");
        }
    }

    private static int[] lru(final int S, int[] tasks) {
        int[] cache = new int[S];

        for (int task : tasks) {
            int idx = S-1;

            for (int i = 0; i < S; i++) {
                if (cache[i] == task) { // cache hit
                    idx = i;
                    break;
                }
            }
            for (int i = idx; i > 0; i--) {
                cache[i] = cache[i-1];
            }
            cache[0] = task;
        }
        return cache;
    }
}
