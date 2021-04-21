import java.util.HashSet;
import java.util.Set;

public class Main {

    static int answer;
    static boolean[] used;
    static boolean[] visit = new boolean[10000000];
    static Set<Integer> primeSet = new HashSet<>();

    public static void main(String[] args) {
        String numbers = "011";
        System.out.println(solution(numbers));
    }

    public static int solution(String numbers) {
        // 에라토스테네스의 체
        for (int i = 2; i < 10000000; i++) {
            if (visit[i]) continue;
            primeSet.add(i);
            for (int j = 2 * i; j < 10000000; j += i) {
                visit[j] = true;
            }
        }

        // used[i] : numbers의 i번째 값 사용 여부
        used = new boolean[numbers.length()];

        // 한 자리수 값을 만들고 dfs
        for (int i = 0; i < numbers.length(); i++) {
            char c = numbers.charAt(i);
            used[i] = true;
            dfs(numbers, String.valueOf(c));
            used[i] = false;
        }

        return answer;
    }

    private static void dfs(String numbers, String s) {
        // s가 소수인지 확인
        int num = Integer.parseInt(s);
        if (!visit[num] && primeSet.contains(Integer.parseInt(s))) {
            // visit은 에라토스테네스의 체에서 사용한 것을 재활용
            // 소수는 이전에 visit[num]값이 false였음. 중복된 소수 개수 계산 방지
            visit[num] = true;
            answer++;
        }

        // 길이가 같으면 numbers의 모든 값을 추가해본 것
        if (s.length() == numbers.length()) return;

        // numbers의 값들을 s의 왼쪽, 오른쪽에 추가하여 dfs
        for (int i = 0; i < numbers.length(); i++) {
            char c = numbers.charAt(i);
            if (used[i]) continue;
            used[i] = true;
            dfs(numbers, s + c);
            dfs(numbers, c + s);
            used[i] = false;
        }
    }
}
