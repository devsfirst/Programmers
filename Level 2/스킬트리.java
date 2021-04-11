import java.util.HashMap;
import java.util.Map;

class Main {

    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        System.out.println(solution(skill, skill_trees));
    }

    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        // (스킬, 스킬의 인덱스(순서)) 를 map에 등록
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < skill.length(); i++) {
            char c = skill.charAt(i);
            map.put(c, i);
        }

        // 각 스킬트리가 가능한지 검사
        for (String st : skill_trees) {
            if (possible(map, st)) answer++;
        }

        return answer;
    }

    private static boolean possible(Map<Character, Integer> map, String st) {
        // map에 등록된 스킬 중 선행되어 나와야 하는 스킬 순서
        int cnt = 0;
        for (int i = 0; i < st.length(); i++) {
            char c = st.charAt(i);
            // map에 들어있지 않으면 상관 없음
            if (!map.containsKey(c)) continue;
            // 스킬 순서가 맞지 않으면 false 반환
            if (map.get(c) != cnt) return false;
            // 스킬 순서가 맞음
            cnt++;
        }
        return true;
    }
}