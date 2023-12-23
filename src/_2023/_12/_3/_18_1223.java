package _2023._12._3;

public class _18_1223 {
    public static void main(String[] args) {
        System.out.println(solution(1));
    }

    public static int solution(int n) {
        int answer = 0;
        double sqrt = Math.sqrt(n);

        for (int i = 1; i < sqrt; i++) { // (int) sqrt로 하면 어떤 케이스에서 틀림. < (int) sqrt와 < sqrt는 다름!!
            if (n % i == 0) {
                answer++;
            }
        }

        if (sqrt - (int) sqrt == 0) {
            return answer * 2 + 1;
        } else {
            return answer * 2;
        }
    }
}
