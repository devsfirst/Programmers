public class Main {
    public static void main(String[] args) {
        int w = 8;
        int h = 12;
        System.out.println(solution(w, h));
    }

    public static long solution(int w, int h) {
        long answer = 0;

        // 기울기
        double d = - (double) h / w;

        // xy 좌표에서 y값 구하기
        for (int i = 1; i < w; i++) {
            answer += (long) (d * i + h);
        }

        return answer * 2;
    }
}
