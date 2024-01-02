package _2024._01.programmers;

import java.util.PriorityQueue;

public class 더맵게 {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(scoville.length);
        for (int item : scoville) {
            pq.add(item);
        }

        while (pq.size() >= 2) {
            answer += 1;
            pq.add(pq.poll() + pq.poll() * 2);

            if (pq.peek() >= K) {
                return answer;
            }
        }

        return -1;
    }
}
