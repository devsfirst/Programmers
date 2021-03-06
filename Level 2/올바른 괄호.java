public class Main {

    public static boolean solution(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') cnt++;
            else {
                if (cnt == 0) return false;
                cnt--;
            }
        }
        return cnt == 0;
    }

    public static void main(String[] args) {
        String s = "(()(";
        System.out.println(solution(s));
    }
}
