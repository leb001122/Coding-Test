package _2023._12._3;

public class _03_1220 {
    public int solution(int[] A) {
        int minPrice = A[0];
        int maxProfit = 0;

        for (int i = 1; i < A.length; i++) {
            minPrice = Math.min(minPrice, A[i]);
            maxProfit = Math.max(maxProfit, A[i] - minPrice);
        }

        return maxProfit;
    }
}
