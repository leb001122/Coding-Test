package _2023._12._3;

public class _19_1223 {
    public static void main(String[] args) {
        System.out.println(solution("f4"));
    }
    public static String solution(String s) {
        int digit = Integer.parseInt(s, 16);
        StringBuilder sb = new StringBuilder();

        int remain = 1;
        while (digit != 0) {
            sb.append(digit % 2);
            digit /= 2;
        }

        return sb.reverse().toString();
    }
}
