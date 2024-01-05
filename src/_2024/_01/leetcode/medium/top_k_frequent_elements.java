package _2024._01.leetcode.medium;

import java.util.*;

public class top_k_frequent_elements {

    public static void main(String[] args) {
        int[] result = solution2(new int[]{1,1,1,2,2,3}, 3);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    // 빈도수를 저장하고 빈도순으로 엘리먼트 추출
    public static int[] solution1(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(k);

        for (int item : nums) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }


        return Arrays.stream(map.entrySet()
                        .stream()
                        .sorted(((o1, o2) -> o2.getValue() - o1.getValue()))
                        .limit(k)
                        .map(Map.Entry::getKey)
                        .mapToInt(Integer::intValue).toArray())
                .toArray();
    }

    public static int[] solution2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(k);

        for (int item : nums) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue(((o1, o2) -> o2 - o1)));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(entry);
        }

        int[] result = new int[k];
        // k번 반복하여 우선순위 큐에서 결과 추출
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll().getKey();
        }
        return result;
    }
}
