public class Main {

    public static int solution(int[][] land) {
        int N = land.length;
        for (int i = 1; i < N; i++) {
            land[i][0] += Math.max(land[i - 1][1], Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][1] += Math.max(land[i - 1][0], Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][2] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][3]));
            land[i][3] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][2]));
        }

        return Math.max(land[N - 1][0], Math.max(land[N - 1][1], Math.max(land[N - 1][2], land[N - 1][3])));
    }

    public static void main(String[] args) {
        int[][] land = {{1, 2, 3, 5}, {5, 6, 7, 8},{4, 3, 2, 1}};
        System.out.println(solution(land));
    }
}
