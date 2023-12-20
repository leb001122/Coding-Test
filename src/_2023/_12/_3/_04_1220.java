package _2023._12._3;

public class _04_1220 {
    public int solution(String s) {

        int[] nums = new int[10];

        for (char ch : s.toCharArray()) {
            nums[Character.getNumericValue(ch)] += 1;
        }

        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[max] < nums[i]) {
                max = i;
            }
        }

        return max;
    }
}
