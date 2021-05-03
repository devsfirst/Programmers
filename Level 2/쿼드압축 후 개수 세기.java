public class Main {

    public static int[] solution(int[][] arr) {
        int[] answer = new int[2];
        recursive(arr, answer, 0, 0, arr.length);
        return answer;
    }

    private static void recursive(int[][] arr, int[] answer, int row, int col, int length) {
        int num = arr[row][col];
        for (int r = 0; r < length; r++) {
            for (int c = 0; c < length; c++) {
                // 숫자가 다르면 4분할
                if (arr[row + r][col + c] != num) {
                    int half = length / 2;
                    recursive(arr, answer, row, col, half);
                    recursive(arr, answer, row, col + half, half);
                    recursive(arr, answer, row + half, col, half);
                    recursive(arr, answer, row + half, col + half, half);
                    return;
                }
            }
        }
        // (row, col) ~ (row + length, col + length) 까지 모두 같으면 그 값 추가
        // 압축이 되는 경우, 숫자가 하나만 남은 경우에도 성립
        answer[num]++;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
        System.out.println(solution(arr));
    }
}
