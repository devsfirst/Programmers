public class Main {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        int[] sol = solution(prices);
        for (int i : sol) {
            System.out.println(i);
        }
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        // i번째 수 이후 i번째 수보다 작은 값 찾기
        for (int i = 0; i < prices.length - 1; i++) {
            int price = prices[i];
            int j;
            for (j = i + 1; j < prices.length - 1; j++) {
                if (price > prices[j]) break;
            }
            answer[i] = j - i;
        }

        return answer;
    }
}
