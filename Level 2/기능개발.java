import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        Solution sol = new Solution();
        int[] answer = sol.solution(progresses, speeds);
        for (int num : answer) {
            System.out.println(num);
        }
    }
}

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answerList = new ArrayList<>();
        List<Job> jobList = new LinkedList<>();
        int length = progresses.length;

        for (int i = 0; i < length; i++) {
            jobList.add(new Job(progresses[i], speeds[i]));
        }

        while (jobList.size() != 0) {
            // 매일 작업 진행
            for (Job job : jobList) {
                job.progress += job.speed;
            }

            // 끝난 작업 제거
            int num = 0;
            while (jobList.size() > 0 && jobList.get(0).progress >= 100) {
                jobList.remove(0);
                num++;
            }

            // 끝난 작업 개수만큼 추가
            if (num > 0) answerList.add(num);
        }

        int answerLength = answerList.size();
        int[] answer = new int[answerLength];
        for (int i = 0; i < answerLength; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    static class Job {
        int progress, speed;

        public Job(int progress, int speed) {
            this.progress = progress;
            this.speed = speed;
        }
    }
}