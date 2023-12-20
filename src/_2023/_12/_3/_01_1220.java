package _2023._12._3;

public class _01_1220 {
    public int solution(int n) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            answer += i;
        }

        return answer;
    }
}
