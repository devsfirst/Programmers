import java.util.Arrays;

public class Main {

    public static int solution(int[] citations) {
        Arrays.sort(citations);
        int answer = 0;
        // 정렬 후 마지막 index부터 역순으로 비교하면 citation 수는 점점 감소
        // answer는 answer만큼 인용된 논문이 answer만큼 존재한다는 뜻
        for (int i = citations.length - 1; i >= 0; i--, answer++) {
            if (citations[i] <= answer) break;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] citations = {0, 1, 2, 2, 3, 4, 4, 5, 5, 5, 6};
        System.out.println(solution(citations));
    }
}
