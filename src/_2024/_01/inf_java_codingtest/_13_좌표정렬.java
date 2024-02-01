package _2024._01.inf_java_codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _13_좌표정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] coordinates = new int[N][];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            coordinates[i] = new int[]{x, y};
        }
        sort2(N, coordinates);

//        sort(coordinates);
//        for (int i = 0; i < N; i++) {
//            System.out.print(coordinates[i][0] + " " +coordinates[i][1] + "\n");
//        }
    }

    public static void sort(int[][] coordinates) {

        Arrays.sort(coordinates, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
    }

    public static void sort2(int N, int[][] coordinates) {
        ArrayList<Point> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(new Point(coordinates[i][0], coordinates[i][1]));
        }
        Collections.sort(list);

        for (Point p : list) {
            System.out.println(p);
        }
    }

    static class Point implements Comparable<Point> {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point p) {
            if (this.x == p.x) {
                return this.y - p.y;
            }
            return this.x - p.x;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }
}

