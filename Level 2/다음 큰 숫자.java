public class Main {

    public static int solution(int n) {
        int one = getOne(n);

        while (true) {
            n++;
            int tmp = n;
            int tmpOne = getOne(tmp);
            if (tmpOne == one) return n;
        }
    }

    private static int getOne(int num) {
        int one = 0;
        while (num > 0) {
            if (num % 2 == 1) one++;
            num /= 2;
        }
        return one;
    }

    public static void main(String[] args) {
        int n = 78;
        System.out.println(solution(n));
    }
}
