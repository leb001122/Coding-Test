package _2024._02.inf_java_codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _19_가장높은탑쌓기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Brick[] bricks = new Brick[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            bricks[i] = new Brick(width, height, weight);
        }

        int answer = solution(N, bricks);
        System.out.println(answer);
    }

    private static int solution(int N, Brick[] bricks) {
        int answer = 0;
        int[] dy = new int[N];

        Arrays.sort(bricks);

        for (int i = 0; i < N; i++) {
            int tmp = 0;

            for (int j = 0; j < i; j++) {
                if (bricks[j].weight > bricks[i].weight) {

                    tmp = Math.max(dy[j], tmp);
                }

            }
            dy[i] = bricks[i].height + tmp;
            answer = Math.max(dy[i], answer);
        }

        return answer;
    }

    static class Brick implements Comparable<Brick> {
        int width;
        int height;
        int weight;

        public Brick(int width, int height, int weight) {
            this.width = width;
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Brick o) {
            return o.width - this.width;
        }
    }
}
