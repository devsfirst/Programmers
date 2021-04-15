import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        System.out.println(solution(priorities, location));
    }

    public static int solution(int[] priorities, int location) {
        int[] priorityCount = new int[10];
        LinkedList<Document> list = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            int priority = priorities[i];
            priorityCount[priority]++;
            list.add(new Document(priority, i));
        }

        int answer = 0;
        while (list.size() != 0) {
            answer++;

            // list에서 가장 높은 우선순위 찾기
            int maxPriority = 0;
            for (int priority = 9; priority >= 1; priority--) {
                if (priorityCount[priority] > 0) {
                    maxPriority = priority;
                    break;
                }
            }

            // 가장 높은 우선순위를 list의 앞으로 가져오기
            while (list.getFirst().priority != maxPriority) {
                list.addLast(list.removeFirst());
            }

            // 가장 높은 우선순위의 문서 출력
            if (list.remove().location == location) break;
            priorityCount[maxPriority]--;
        }
        return answer;
    }

    static class Document {
        int priority, location;

        public Document(int priority, int location) {
            this.priority = priority;
            this.location = location;
        }
    }
}
