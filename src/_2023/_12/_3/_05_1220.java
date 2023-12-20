package _2023._12._3;

public class _05_1220 {
    public int solution(String S) {
        int answer = 0;

        int num = 0;
        char[] charArray = S.toCharArray();
        int len = charArray.length - 1;

        for (int i = 0; i <= len; i++) {
            num += Character.getNumericValue(charArray[i]) * (Math.pow(2, len - i));
        }

        while (num > 0) {
            if (num % 2 == 0) {
                num = num >> 1;
            } else {
                num = num - 1;
            }
            answer++;
        }

        return answer;
    }
}
