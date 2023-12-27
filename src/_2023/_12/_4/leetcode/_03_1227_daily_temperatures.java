package _2023._12._4.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _03_1227_daily_temperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] results = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < temperatures.length; i++) {

            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int j = stack.pop();
                results[j] = i - j;
            }
            stack.push(i);
        }

        return results;
    }

}
