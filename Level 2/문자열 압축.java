public class Main {
    public static void main(String[] args) {
        String s = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxz";
        System.out.println(solution(s));
    }

    public static int solution(String s) {
        int answer = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            StringBuilder sb = new StringBuilder();
            String cmpString = s.substring(0, i);
            int cnt = 1;
            // for문이 끝나고 남은 문자열 붙이기 위해
            int j;
            // substring 가능하도록 범위를 j + i <= s.length(); 로
            for (j = i; j + i <= s.length(); j += i) {
                String substring = s.substring(j, j + i);
                // 같은 문자열
                if (cmpString.equals(substring)) cnt++;
                // 다른 문자열
                else {
                    // 압축할 수 있으면 개수 + 압축문자열 저장
                    if (cnt > 1) sb.append(cnt).append(cmpString);
                    // 압축 불가능하면 문자열만 저장
                    else sb.append(cmpString);
                    cnt = 1;
                    cmpString = substring;
                }
            }

            // 압축할 수 있으면 개수 + 압축 문자열 + 남은 문자열 저장
            if (cnt > 1) sb.append(cnt).append(cmpString).append(s.substring(j));
            // 압축 불가능하면 문자열 + 남은 문자열 저장
            else sb.append(cmpString).append(s.substring(j));
            answer = Math.min(answer, sb.length());
        }

        return answer;
    }
}
