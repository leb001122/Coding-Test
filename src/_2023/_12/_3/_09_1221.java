package _2023._12._3;

public class _09_1221 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{10}, 7));
    }
    public static int solution(int[] orders, int n) {

        int cnt = 0;
        int idx = 0;
        int num = 0;

        while (idx < orders.length) {
            num++;

            if (num == orders[idx]) {
                idx++;
            } else {
                cnt++;
                if (cnt == n) {
                    return num;
                }
            }
        }
        return orders[--idx] + (n - cnt);
    }
}
