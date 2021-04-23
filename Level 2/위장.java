import java.util.HashMap;
import java.util.Map;

public class Main {

    public static int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        // (종류, 개수) 저장
        for (String[] c : clothes) {
            String key = c[1];
            if (map.containsKey(key)) map.put(key, map.get(key) + 1);
            else map.put(key, 1);
        }

        int answer = 1;
        // value + 1: 의상의 개수(value) + 의상을 안입는 경우(1)
        for (Integer value : map.values()) {
            answer *= (value + 1);
        }

        // answer - 1: 모든 의상을 안입는 경우를 제거
        return answer - 1;
    }

    public static void main(String[] args) {
        String[][] clothes = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};
        System.out.println(solution(clothes));
    }
}
