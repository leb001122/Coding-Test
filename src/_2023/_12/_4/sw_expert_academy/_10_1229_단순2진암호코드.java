package _2023._12._4.sw_expert_academy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _10_1229_단순2진암호코드 {

    static Map<String, Integer> codeMap = new HashMap<>(10);

    static {
        codeMap.put("0001101", 0);
        codeMap.put("0011001", 1);
        codeMap.put("0010011", 2);
        codeMap.put("0111101", 3);
        codeMap.put("0100011", 4);
        codeMap.put("0110001", 5);
        codeMap.put("0101111", 6);
        codeMap.put("0111011", 7);
        codeMap.put("0110111", 8);
        codeMap.put("0001011", 9);
    }


    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/_2023/_12/_4/sw_expert_academy/input_file/_10_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {

            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            String line = null;
            int idx = -1;
            int i = 0;

            for (i = 0; i < N; i++) {
                line = br.readLine();
                if ((idx = line.lastIndexOf("1")) != -1) break;
            }
            sb.append(String.format("#%d %d%n", test_case, getResult(line, idx)));
            for (; i < N - 1; i++) {
                br.readLine();
            }
        }
        System.out.println(sb);
    }

    private static int getResult(String s, int idx) {
        final int N = 8;
        int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            String subStr = s.substring(idx - 6, idx + 1);
            nums[N - 1 - i] = codeToInt(subStr);
            idx -= 7;
        }

        int result = 0;
        if (isValidCode(nums)) {
            for (int i = 0; i < N; i++) {
                result += nums[i];
            }
        }
        return result;
    }

    public static boolean isValidCode(int[] arr) {
        // 홀수번째 자리는 더해서 *3
        int result = 0;
        for (int i = 0; i < arr.length; i += 2) {
            result += arr[i];
        }
        result *= 3;
        // 짝수번째 자리는 더해서 *2
        for (int i = 1; i < arr.length; i += 2) {
            result += arr[i];
        }
        if (result % 10 == 0) {
            return true;
        }
        return false;
    }

    private static int codeToInt(String code) {
        return codeMap.get(code);
    }
}
