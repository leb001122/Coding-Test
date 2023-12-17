package _2023._12._2.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _00_팀명정하기 {

    private static void solution1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";

        int[] Y_list = new int[3];
        String[][] PS_list = new String[3][2];

        int i = 0;
        while ((str = br.readLine()) != null && !str.isEmpty()) {
            String[] splitStr = str.split(" ");
            Y_list[i] = Integer.parseInt(splitStr[1]) % 100;
            PS_list[i][0] = splitStr[0];
            PS_list[i][1] = splitStr[2];
            i++;
        }

        Arrays.sort(Y_list);
        for (int item : Y_list) {
            System.out.print(item);
        }
        System.out.println();

        Arrays.sort(PS_list, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
//                return o1[0].toString().compareTo(o2[0].toString());
                return Integer.parseInt(o2[0]) - Integer.parseInt(o1[0]);
            }
        });

        for (String[] item : PS_list) {
            System.out.print(item[1].charAt(0));
        }
    }

    private static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());


        }
    }
}
