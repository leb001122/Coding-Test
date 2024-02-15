package _2024._02.inf_java_codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class _14_모든아나그램찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();

        int result = solution(S, T);
        System.out.println(result);
    }

    private static int solution(String S, String T) {
        int result = 0;
        int TLen = T.length();
        HashMap<Character, Integer> tMap = new HashMap<>();
        HashMap<Character, Integer> sMap = new HashMap<>();

        // T
        for (char ch : T.toCharArray()) {
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }

        // S
        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            sMap.put(entry.getKey(), entry.getValue());
        }

        // S 문자열에서 첫 T 길이의 문자열
        for (int i = 0; i < TLen; i++) {
            char ch = S.charAt(i);

            if (sMap.containsKey(ch)) {
                sMap.put(ch, sMap.get(ch) - 1);
            }
        }
        if (isAnagram(sMap)) result++;

        // S 나머지 문자열
        for (int i = 1; i <= S.length() - TLen; i++) {
            char lt = S.charAt(i - 1);
            char rt = S.charAt(i + TLen - 1);

            if (sMap.containsKey(lt)) {
                sMap.put(lt, sMap.get(lt) + 1);
            }

            if (sMap.containsKey(rt)) {
                sMap.put(rt, sMap.get(rt) - 1);
            }
            if (isAnagram(sMap)) result++;
        }
        return result;
    }

    private static boolean isAnagram(HashMap<Character, Integer> map) {

        for (Integer val : map.values()) {
            if (val != 0) {
                return false;
            }
        }
        return true;
    }
}
