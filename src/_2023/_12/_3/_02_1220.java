package _2023._12._3;

public class _02_1220 {
    public boolean solution(int num) {

        // 남은 모래가 index(0제외)일 때, 먼저 시작한 사람이 이길수 있는지 여부
        boolean[] arr = new boolean[num + 1];
        arr[1] = false;

        for (int i = 2; i <= num; i++) {

            for (int j = 1; j <= 3; j++) {

                if (arr[i - j] == false) {
                    arr[i] = true;
                    break;
                }

            }
        }

        return arr[num];
    }
}
