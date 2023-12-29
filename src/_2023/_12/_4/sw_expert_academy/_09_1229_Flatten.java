package _2023._12._4.sw_expert_academy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 평탄화 문제
public class _09_1229_Flatten {

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/_2023/_12/_4/sw_expert_academy/_09_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int dumpNum;
        StringTokenizer st;
        int[] arr;

        for (int test_case = 1; test_case <= 10; test_case++) {
            dumpNum = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            arr = new int[100];

            for (int i = 0; i < 100; i++) {
                arr[i] = Integer.parseInt(st.nextToken(" "));
            }

            sb.append(String.format("#%d %d%n", test_case, getResult(arr, dumpNum)));
        }
        System.out.println(sb);
    }

    public static int getResult(int[] arr, int n) {
        int result = 0;
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            arr[0] += 1;
            arr[arr.length - 1] -= 1;
            Arrays.sort(arr);

            if ((result = arr[arr.length - 1] - arr[0]) < 2) {
                return result;
            }
        }
        return result;
    }
}
