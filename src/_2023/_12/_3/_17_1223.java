package _2023._12._3;

public class _17_1223 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"10110", "1010", "11110"}));
    }
    public static int solution(String[] arr) {
        int answer = 0;
        int temp;

        for (String str : arr) {
            temp = 0;

            int len = str.length();
            for (int i = 0; i < len; i++) {
                temp += (str.charAt(i) - '0') * Math.pow(2, len - 1 - i);
            }
            System.out.println(temp);

            answer ^= temp;
        }

        return answer;
    }
}
