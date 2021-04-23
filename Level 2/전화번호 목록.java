import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static boolean solution(String[] phone_book) {
        // set에 phone_book의 모든 번호 저장
        Set<String> set = new HashSet<>(Arrays.asList(phone_book));
        for (String number : phone_book) {
            // phone_book의 모든 번호마다 마지막 번호를 제외한 substring(접두사)이 set에 있는지 검사
            for (int i = 1; i < number.length(); i++) {
                if (set.contains(number.substring(0, i))) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] phone_book = {"2", "184", "123", "12"};
        System.out.println(solution(phone_book));
    }
}
