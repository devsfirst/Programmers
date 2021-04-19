public class Main {

    static int area;
    static int[] answer = new int[2];
    static int[] moveR = {-1, 1, 0, 0};
    static int[] moveC = {0, 0, -1, 1};
    static boolean[][] visit;

    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        int[] sol = solution(m, n, picture);
        System.out.println(sol[0] + " " + sol[1]);
    }

    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        visit = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 색을 칠하지 않거나 방문했으면 건너뜀
                if (picture[i][j] == 0 || visit[i][j]) continue;
                numberOfArea++;
                area = 1;
                visit[i][j] = true;
                dfs(picture, i, j, m, n, picture[i][j]);
                maxSizeOfOneArea = Math.max(maxSizeOfOneArea, area);
            }
        }

        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    private static void dfs(int[][] picture, int r, int c, int m, int n, int color) {
        // 상하좌우 4방향 확인
        for (int d = 0; d < 4; d++) {
            int nr = r + moveR[d];
            int nc = c + moveC[d];
            // 범위를 벗어나거나 이미 방문했으면 건너뜀
            if (nr < 0 || nr >= m || nc < 0 || nc >= n || visit[nr][nc]) continue;
            // 같은 색이면 진행
            if (picture[nr][nc] == color) {
                area++;
                visit[nr][nc] = true;
                dfs(picture, nr, nc, m, n, color);
            }
        }
    }
}
