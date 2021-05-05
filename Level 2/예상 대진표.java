public class Main {

    public static int solution(int n, int a, int b) {
        // a < b 가 되도록
        if (a > b) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        int answer = 1;
        while (true) {
            // b - a == 1 조건만 있으면 [1-2(a)] [3(b)-4] 일 때 처리 불가
            // a < b 이므로 a가 홀수여야 하는 조건 추가
            if (a % 2 == 1 && b - a == 1) break;

            if (a % 2 == 0) a /= 2;
            else a = (a + 1) / 2;
            if (b % 2 == 0) b /= 2;
            else b = (b + 1) / 2;
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 8;
        int a = 2;
        int b = 3;
        System.out.println(solution(n, a, b));
    }
}
