package _2024._02.leetcode;

public class MaximumAverageSubarray1 {
    public double findMaxAverage(int[] nums, int k) {
        int answer = 0;

        for (int i = 0; i < k; i++) {
            answer += nums[i];
        }

        int sum = answer;
        for (int i = 0, j = i+k; j < nums.length; i++, j++) {
            sum -= nums[i];
            sum += nums[j];

            if (answer < sum) answer = sum;
        }

        return (double)answer / k;
    }
}
