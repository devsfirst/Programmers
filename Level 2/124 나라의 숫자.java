public class Main {
    public static void main(String[] args) {
        int n = 120;
        System.out.println(solution(n));
    }

    public static String solution(int n) {
        StringBuilder sb = new StringBuilder();
        // 3진법으로 표현
        while (n > 0) {
            sb.append(n % 3);
            n /= 3;
        }
        sb.reverse();

        // 큰 수부터 0인 값 확인
        for (int i = 1; i < sb.length(); i++) {
            // 0인 값이 있으면 큰 자리수에서 하나 빌려와서 4로 치환
            for (int j = i; j > 0; j--) {
                char current = sb.charAt(j);
                char prev = sb.charAt(j - 1);
                if (current != '0') break;

                sb.setCharAt(j, '4');
                if (prev == '1') sb.setCharAt(j - 1, '0');
                else if (prev == '2') sb.setCharAt(j - 1, '1');
                else sb.setCharAt(j - 1, '2');
            }
        }
        if (sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.toString();
    }
}
