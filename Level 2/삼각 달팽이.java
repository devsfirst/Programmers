public class Main {

    public static int[] solution(int n) {
        int max = n * (n + 1) / 2;
        int[] answer = new int[max];
        int[][] arr = new int[n][n];

        // 세로 -> 가로 -> 대각선 순으로 삼각 달팽이 만들기
        int num = 1;
        int len = n;
        int row = -1;
        int col = 0;
        while (num <= max) {
            // 세로 채우기
            for (int i = 0; i < len; i++) {
                arr[++row][col] = num++;
            }
            len--;
            // 가로 채우기
            for (int i = 0; i < len; i++) {
                arr[row][++col] = num++;
            }
            len--;
            // 대각선 채우기
            for (int i = 0; i < len; i++) {
                arr[--row][--col] = num++;
            }
            len--;
        }

        // answer[index] 에 (i, j) 값 추가
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[index++] = arr[i][j];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 6;
        System.out.println(solution(n));
    }
}
