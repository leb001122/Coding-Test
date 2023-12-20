package _2023._12._3;

public class _06_1221 {
    public String solution(int n, String s, int t) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(".");
        }
        sb.append(s);
        String str = sb.toString();

        sb = new StringBuilder();
        int len = str.length();
        for (int i = t; i < t + n; i++) {
            sb.append(str.charAt(i % len));
        }

        return sb.toString();
    }
}
