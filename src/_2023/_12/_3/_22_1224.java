package _2023._12._3;

public class _22_1224 {
    public boolean solution(int n) {
        boolean answer = true;

        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                answer = false;
                break;
            }
        }
        return answer;
    }
}
