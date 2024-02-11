package _2024._02.inf_java_codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class _12_아나그램 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        solution(str1, str2);
    }

    private static void solution(String str1, String str2) {
        if (str1.length() != str2.length()) {
            System.out.println("NO");
            return;
        }

        HashMap<Character, Integer> map = new HashMap();

        for (Character ch : str1.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (Character ch : str2.toCharArray()) {
            int val;
            if (!map.containsKey(ch) || (val = map.get(ch)) == 0) {
                System.out.println("NO");
                return;
            }
            map.put(ch, val - 1);
        }

        System.out.println("YES");
    }
}
