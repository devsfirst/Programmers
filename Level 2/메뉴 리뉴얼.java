import java.util.*;

public class Main {

    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2, 3, 4};
        String[] sol = solution(orders, course);
        for (String s : sol) {
            System.out.println(s);
        }
    }

    public static String[] solution(String[] orders, int[] course) {
        // order마다 가능한 조합 추출
        for (String order : orders) {
            // order 내의 문자를 미리 정렬
            char[] chars = order.toCharArray();
            Arrays.sort(chars);
            dfs("", new String(chars), order.length(), 0);
        }

        // tmp[i] : i 번째 course에서 최대 길이
        int[] tmp = new int[course.length];
        for (String key : map.keySet()) {
            for (int i = 0; i < course.length; i++) {
                if (key.length() == course[i] && map.get(key) >= 2) {
                    tmp[i] = Math.max(tmp[i], map.get(key));
                    break;
                }
            }
        }

        // 길이가 course[i]인것 중 빈도 수가 가장 많은 것을 list에 등록
        List<String> list = new ArrayList<>();
        for (String key : map.keySet()) {
            for (int i = 0; i < course.length; i++) {
                if (key.length() == course[i] && map.get(key) == tmp[i]) list.add(key);
            }
        }

        // String 배열로 변환 후 사전순 정렬
        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }

    private static void dfs(String s, String order, int length, int index) {
        if (s.length() >= 2) {
            if (map.containsKey(s)) map.put(s, map.get(s) + 1);
            else map.put(s, 1);
        }

        for (int i = index; i < length; i++) {
            dfs(s + order.charAt(i), order, length, i + 1);
        }
    }
}
