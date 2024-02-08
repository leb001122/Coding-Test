package _2024._02.inf_java_codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _09_응급실 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = solution(M, arr);
        System.out.println(answer);
    }

    private static int solution(int M, int[] arr) {
        Queue<Person> queue = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            queue.add(new Person(i, arr[i]));
        }

        int answer = 0;

        while (!queue.isEmpty()) {
            Person tmp = queue.poll();

            for (Person p : queue) {
                if (p.priority > tmp.priority) {
                    queue.add(tmp);
                    tmp = null;
                    break;
                }
            }

            if (tmp != null) {
                answer++;
                if (tmp.idx == M) {
                    break;
                }
            }
        }
        return answer;
    }

    static class Person {
        int idx;
        int priority;

        public Person(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }
    }
}
