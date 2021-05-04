import java.util.Stack;

public class Main {

    public static int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.size() == 0) stack.add(c);
            else {
                if (stack.peek() == c) stack.pop();
                else stack.add(c);
            }
        }

        if (stack.isEmpty()) return 1;
        return 0;
    }

    public static void main(String[] args) {
        String s = "baabaa";
        System.out.println(solution(s));
    }
}
