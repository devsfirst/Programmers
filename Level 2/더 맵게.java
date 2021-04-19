import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        System.out.println(solution(scoville, K));
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int s : scoville) {
            queue.add(s);
        }

        // 두 수 꺼내서 계산
        while (queue.size() > 1 && queue.peek() < K) {
            int first = queue.remove();
            int second = queue.remove();
            queue.add(first + 2 * second);
            answer++;
        }

        // 입력 받는 scoville의 길이가 2이상이므로 위의 while 연산 결과
        // queue의 size는 항상 1이상임이 보장됨 -> peek() 해도 NullPointerException 발생x
        if (queue.peek() < K) return -1;

        return answer;
    }
}
