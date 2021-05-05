import java.util.LinkedList;

public class Main {

    public static int solution(int cacheSize, String[] cities) {
        LinkedList<String> list = new LinkedList<>();
        int answer = 0;

        for (String city : cities) {
            city = city.toLowerCase();
            boolean hit = false;
            // hit 여부 검사
            for (String str : list) {
                if (city.equals(str)) {
                    hit = true;
                    break;
                }
            }

            if (hit) {
                list.remove(city);
                list.add(city);
                answer++;
            } else {
                // 캐시 크기가 0이면 캐시를 채우지 않음
                if (cacheSize != 0) {
                    // 캐시가 가득 차면 remove 진행
                    if (list.size() == cacheSize) list.removeFirst();
                    list.add(city);
                }
                answer += 5;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int cacheSize = 0;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        System.out.println(solution(cacheSize, cities));
    }
}
