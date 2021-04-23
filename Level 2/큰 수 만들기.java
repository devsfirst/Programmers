public class Main {

    public static String solution(String number, int k) {
        StringBuilder sb = new StringBuilder().append(number);
        for (int i = 1; i < sb.length() && k > 0; i++) {
            // i번째 수가 i - 1번째 수보다 크면 i - 1번째 수를 제거
            // 제거하고 난 후 다시 제거해야 할 경우가 있음
            // ex) 4177, k = 2 -> 1 제거 후 4 제거
            while (k > 0 && i >= 1 && sb.charAt(i - 1) < sb.charAt(i)) {
                sb.deleteCharAt(i - 1);
                k--;
                // i - 1번째 수를 제거하면 i번째 수의 index가 i - 1이 됨
                i--;
            }
        }

        // k개만큼 제거가 안됐으면 제일 끝자리에서부터 제거
        while (k > 0) {
            sb.deleteCharAt(sb.length() - 1);
            k--;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String number = "4177252841";
        int k = 4;
        System.out.println(solution(number, k));
    }
}
