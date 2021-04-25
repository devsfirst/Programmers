public class Main {

    static int answer = 0;
    static char[] name = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static int[] location = new int[26];
    static boolean[] visit = new boolean[8];

    public static int solution(int n, String[] data) {
        dfs(data, 0);

        return answer;
    }

    private static void dfs(String[] data, int loc) {
        // 8마리 모두 줄 세우면 검사
        if (loc == 8) {
            if (check(data)) answer++;
            return;
        }

        // backtracking으로 순열 줄세우기
        for (int i = 0; i < 8; i++) {
            if (!visit[i]) {
                visit[i] = true;
                location[name[i] - 'A'] = loc;
                dfs(data, loc + 1);
                visit[i] = false;
            }
        }
    }

    private static boolean check(String[] data) {
        for (String s : data) {
            int loc1 = location[s.charAt(0) - 'A'];
            int loc2 = location[s.charAt(2) - 'A'];
            char cmp = s.charAt(3);
            int num = s.charAt(4) - '0' + 1;

            // 간격(num)은 두 프렌즈 사이에 있는 다른 프렌즈의 수
            if (cmp == '=') {
                if (Math.abs(loc1 - loc2) != num) return false;
            } else if (cmp == '<') {
                if (Math.abs(loc1 - loc2) >= num) return false;
            } else {
                if (Math.abs(loc1 - loc2) <= num) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 2;
        String[] data = {"N~F=0", "R~T>2"};
        System.out.println(solution(n, data));
    }
}
