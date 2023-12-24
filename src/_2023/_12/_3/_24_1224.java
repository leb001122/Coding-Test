package _2023._12._3;

public class _24_1224 {
    public int solution(int n) {
        int answer = 0;
        double sqrt = Math.sqrt(n);

        if (sqrt - (int)sqrt == 0) {
            answer = (int) sqrt;
        } else {
            answer = 0;
        }

        return answer;
    }
}
