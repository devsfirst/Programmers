public class Main {

    public static int solution(int[] people, int limit) {
        int answer = 0;
        // 몸무게에 해당하는 인원 수
        int[] arr = new int[limit + 1];
        for (int p : people) {
            arr[p]++;
        }

        for (int i = limit; i >= 0; i--) {
            // 몸무게가 가장 많이 나가는 사람 먼저 태우고
            while (arr[i] > 0) {
                answer++;
                int weight = limit - i;
                arr[i]--;
                // 더 태울 수 있는 무게에 가장 가까운 사람 더 태우기
                for (int j = weight; j >= 40; j--) {
                    if (arr[j] > 0) {
                        arr[j]--;
                        break;
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50};
        int limit = 100;
        System.out.println(solution(people, limit));
    }
}
