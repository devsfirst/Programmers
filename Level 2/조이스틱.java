public class Main {

    public static int solution(String name) {
        int answer = 0;
        int index = 0;

        // 맨 처음에는 A로만 이루어져 있음
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < name.length(); i++) {
            sb.append('A');
        }

        while (true) {
            boolean diff = true;
            int leftMove = 0, rightMove = 0;
            int leftIndex = index, rightIndex = index;

            // 왼쪽으로 움직이고 다른 알파벳이 나올 때 거리
            while (name.charAt(leftIndex) == sb.charAt(leftIndex)) {
                leftMove++;
                leftIndex--;
                if (leftIndex < 0) leftIndex = name.length() - 1;
                if (leftIndex == index) {
                    diff = false;
                    break;
                }
            }

            // 오른쪽으로 움직이고 다른 알파벳이 나올 때 거리
            while (name.charAt(rightIndex) == sb.charAt(rightIndex)) {
                rightMove++;
                rightIndex++;
                if (rightIndex == name.length()) rightIndex = 0;
                if (rightIndex == index) {
                    diff = false;
                    break;
                }
            }

            // 수정해야 할 알파벳이 없으면 종료
            if (!diff) break;

            // 좌, 우 방향 중 움직이는 방향 선택
            if (leftMove < rightMove) {
                index = leftIndex;
                answer += leftMove;
            } else {
                index = rightIndex;
                answer += rightMove;
            }

            // 위, 아래 방향 중 더 적게 움직이는 방향 선택
            char c = name.charAt(index);
            sb.setCharAt(index, c);
            answer += Math.min(c - 65, 91 - c);
        }

        return answer;
    }

    public static void main(String[] args) {
        String name = "JAN";
        System.out.println(solution(name));
    }
}
