package _2023._12._3;

public class _21_1224 {
    public static void main(String[] args) {
        solution("google");
    }

    public static String solution(String s) {
        char[] arr = new char[26];

        for (char ch : s.toCharArray()) {
            arr[ch - 'a']++;
        }

        int maxIdx = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[maxIdx] < arr[i]) {
                maxIdx = i;
            }
        }
        System.out.println((char) ('a' + maxIdx));

        return null;
    }
}
