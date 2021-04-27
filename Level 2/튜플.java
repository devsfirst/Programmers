import java.util.HashMap;
import java.util.Map;

public class Main {

    public static int[] solution(String s) {
        Map<Integer, Integer> map = new HashMap<>();

        // {와 }를 모두 없앤 후 ,에 대해 split
        // split의 각 배열 요소에는 ,로 나눠진 수만 들어있음
        String[] split = s.replaceAll("[{}]", "").split(",");

        // 튜플의 각 수에 대해 빈도수 저장
        for (int i = 0; i < split.length; i++) {
            int key = Integer.parseInt(split[i]);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        // (map의 크기 - 수의 빈도수)가 그 수의 answer 배열에서 index
        int[] answer = new int[map.size()];
        for (Integer key : map.keySet()) {
            answer[map.size() - map.get(key)] = key;
        }

        return answer;
    }

    public static void main(String[] args) {
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        int[] sol = solution(s);
        for (int i = 0; i < sol.length; i++) {
            System.out.println(sol[i]);
        }
    }
}
