package _2023._12._3;

public class _16_1223 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{71, 111, 111, 103, 108, 101}));
    }
    public static String solution(int[] arr) {
        StringBuilder sb = new StringBuilder();

        for (int ascii : arr) {
            sb.append((char) ascii);
        }

        return sb.toString();
    }
}
