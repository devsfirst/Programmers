import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static class Number implements Comparable<Number> {
        int originNumber, newNumber;

        public Number(int originNumber, int newNumber) {
            this.originNumber = originNumber;
            this.newNumber = newNumber;
        }

        @Override
        public int compareTo(Number o) {
            return o.newNumber - newNumber;
        }
    }

    public static String solution(int[] numbers) {
        List<Number> list = new ArrayList<>();
        StringBuilder sb;
        // 모든 입력을 그 수를 반복하여 4자리로 만듦
        // ex) 10 -> 1010, 8 -> 8888, 234 -> 2342
        for (int number : numbers) {
            sb = new StringBuilder();
            sb.append(number);
            for (int i = 0; sb.length() < 4; i++) {
                sb.append(sb.charAt(i));
            }
            list.add(new Number(number, Integer.parseInt(sb.toString())));
        }

        // list를 위에서 만든 수에 대해 내림차순으로 정렬 후 차례로 이어붙이기
        Collections.sort(list);
        sb = new StringBuilder();
        for (Number number : list) {
            sb.append(number.originNumber);
        }

        if (sb.charAt(0) == '0') return "0";
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] numbers = {0, 0, 0};
        System.out.println(solution(numbers));
    }
}
