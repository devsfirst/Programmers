public class Main {

    public static int solution(int[][] board) {
        int answer = 0;
        int row = board.length;
        int col = board[0].length;

        // (i, j)를 정사각형의 오른쪽 아래라고 생각
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // (i, j)가 1이어야 정사각형을 만들 수 있음
                if (board[i][j] == 1) {
                    // i == 0 or j == 0인 경우 아래 식 적용 불가
                    // (i, j)는 왼쪽, 위, 왼쪽 위 대각선 방향 중 최솟값 + 1 의 크기 정사각형을 만들 수 있음
                    if (i > 0 && j > 0) board[i][j] = Math.min(board[i - 1][j - 1], Math.min(board[i - 1][j], board[i][j - 1])) + 1;
                    answer = Math.max(answer, board[i][j]);
                }
            }
        }

        return answer * answer;
    }

    public static void main(String[] args) {
        int[][] board = {{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}};
        System.out.println(solution(board));
    }
}
