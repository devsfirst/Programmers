import java.util.HashMap;
import java.util.Map;

public class Main {

    public static int solution(String str1, String str2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        // str1을 두 글자씩 끊은 후 끊은 문자열의 개수 구하기
        for (int i = 0; i < str1.length() - 1; i++) {
            String substring = str1.substring(i, i + 2);
            char c1 = substring.charAt(0);
            char c2 = substring.charAt(1);
            if (c1 < 'a' || c1 > 'z' || c2 < 'a' || c2 > 'z') continue;
            map1.put(substring, map1.getOrDefault(substring, 0) + 1);
        }

        // str2를 두 글자씩 끊은 후 끊은 문자열의 개수 구하기
        for (int i = 0; i < str2.length() - 1; i++) {
            String substring = str2.substring(i, i + 2);
            char c1 = substring.charAt(0);
            char c2 = substring.charAt(1);
            if (c1 < 'a' || c1 > 'z' || c2 < 'a' || c2 > 'z') continue;
            map2.put(substring, map2.getOrDefault(substring, 0) + 1);
        }

        int intersect = 0;
        int val1 = 0;
        int val2 = 0;
        for (String key : map1.keySet()) {
            val1 += map1.get(key);
            if (!map2.containsKey(key)) continue;
            intersect += Math.min(map1.get(key), map2.get(key));
        }
        for (Integer value : map2.values()) {
            val2 += value;
        }
        int union = val1 + val2 - intersect;

        // 두 집합 모두 공집합인 경우
        if (union == 0) return 65536;
        double answer = (double) intersect / union * 65536;

        return (int) answer;
    }

    public static void main(String[] args) {
        String string1 = "handshake";
        String string2 = "shake hands";
        System.out.println(solution(string1, string2));
    }
}
