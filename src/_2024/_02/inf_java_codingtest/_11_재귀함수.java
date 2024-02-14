package _2024._02.inf_java_codingtest;

public class _11_재귀함수 {
    public static void main(String[] args) {
        // 이진수
        dfs(11);
    }

    private static void dfs(int n) {
        if (n == 0) return;

        dfs(n / 2);
        System.out.print(n % 2 + "");
    }
}
