package _2023._12._4.sw_expert_academy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _08_1229_View {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/_2023/_12/_4/sw_expert_academy/_08_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int test_case = 1; test_case <= 10; test_case++) {
            int[] heightArr = new int[Integer.parseInt(br.readLine())];
            st = new StringTokenizer(br.readLine(), " ");

            for (int i = 0; i < heightArr.length; i++) {
                heightArr[i] = Integer.parseInt(st.nextToken());
            }

            sb.append(String.format("#%d %d%n", test_case, getResult(heightArr)));
        }
        System.out.println(sb);

        br.close();
    }

    public static int getResult(int[] heightArr) {

        int result = 0;

        for (int i = 2; i < heightArr.length - 2; i++) {
            int left = 0, right = 0;

            // 왼쪽 조망권 확인
            int val = Math.max(heightArr[i - 1], heightArr[i - 2]);
            if (val < heightArr[i]) {
                left = heightArr[i] - val;
            }
            // 오른쪽 조망권 확인
            val = Math.max(heightArr[i + 1], heightArr[i + 2]);
            if (val < heightArr[i]) {
                right = heightArr[i] - val;
            }
            result += Math.min(left, right);
        }

        return result;
    }
}
