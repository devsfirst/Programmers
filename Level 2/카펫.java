public class Main {

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int sqrt = (int) Math.sqrt(yellow);
        for (int r = yellow; r >= sqrt; r--) {
            // r * c = yellow가 되는 r, c 찾기
            if (yellow % r != 0) continue;
            int c = yellow / r;
            // 2r + 2c + 4 = brown (yellow에서 한줄씩 연장 + 테두리 4칸)
            if (2 * (r + c) + 4 == brown) {
                // r, c는 yellow의 r, c 이므로 전체는 +2씩
                answer[0] = r + 2;
                answer[1] = c + 2;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int brown = 24;
        int yellow = 24;
        int[] sol = solution(brown, yellow);
        System.out.println(sol[0] + " " + sol[1]);
    }
}
