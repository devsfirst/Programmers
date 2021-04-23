public class Main {

    static int answer = 0;

    public static int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);

        return answer;
    }

    private static void dfs(int[] numbers, int target, int index, int sum) {
        if (index == numbers.length) {
            if (sum == target) answer++;
            return;
        }

        dfs(numbers, target, index + 1, sum + numbers[index]);
        dfs(numbers, target, index + 1, sum - numbers[index]);
    }

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(solution(numbers, target));
    }
}
