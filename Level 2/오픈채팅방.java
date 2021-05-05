import java.util.HashMap;
import java.util.Map;

public class Main {

    public static String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        // answer에 담길 문구 수 계산 + (id, name) map 만들기(가장 최신 name으로 저장됨)
        int message = 0;
        for (String s : record) {
            String[] split = s.split(" ");
            String action = split[0];
            if (!action.equals("Change")) message++;
            if (action.equals("Leave")) continue;
            String id = split[1];
            String name = split[2];
            map.put(id, name);
        }
        // Enter, Leave일 때만 문구 생성
        String[] answer = new String[message];
        int index = 0;
        for (String s : record) {
            String[] split = s.split(" ");
            String action = split[0];
            if (action.equals("Change")) continue;
            String id = split[1];
            if (action.equals("Enter")) answer[index++] = map.get(id) + "님이 들어왔습니다.";
            else answer[index++] = map.get(id) + "님이 나갔습니다.";
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        System.out.println(solution(record));
    }
}
