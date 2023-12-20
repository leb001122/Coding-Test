package _2023._12._3;

public class _08_1221 {
    public int solution(int[] A) {

        if (A.length == 1) {
            return 1;
        }

        int gcd = gcd(A[0], A[1]);
        for (int i = 2; i < A.length; i++) {
            gcd = gcd(gcd, A[i]);
        }

        return gcd;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
