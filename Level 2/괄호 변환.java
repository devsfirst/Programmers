import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        String p = "(())";
        System.out.println(solution(p));
    }

    public static String solution(String p) {
        //1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
        if (p.length() == 0) return "";

        //2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다.
        //   단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며,
        //   v는 빈 문자열이 될 수 있습니다.
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();
        int open = 0;
        int close = 0;
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (c == '(') open++;
            else close++;
            if (open == close) {
                u.append(p, 0, i + 1);
                v.append(p, i + 1, p.length());
                break;
            }
        }
        //3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
        //  3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
        if (rightString(u)) return u.append(solution(v.toString())).toString();
        else {
            //4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
            //  4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
            StringBuilder tmp = new StringBuilder();
            tmp.append('(');
            //  4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
            tmp.append(solution(v.toString()));
            //  4-3. ')'를 다시 붙입니다.
            tmp.append(')');
            //  4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
            u.deleteCharAt(0);
            u.deleteCharAt(u.length() - 1);
            for (int i = 0; i < u.length(); i++) {
                char c = u.charAt(i);
                if (c == '(') tmp.append(')');
                else tmp.append('(');
            }
            //  4-5. 생성된 문자열을 반환합니다.
            return tmp.toString();
        }
    }

    private static boolean rightString(StringBuilder u) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < u.length(); i++) {
            char c = u.charAt(i);
            if (c == '(') stack.add('(');
            else {
                if (stack.size() == 0) return false;
                stack.pop();
            }
        }
        return true;
    }
}
