import java.util.HashSet;
import java.util.Set;

public class Main {

    public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int[] turn = new int[n];
        Set<String> set = new HashSet<>();

        String prevWord = words[0];
        set.add(prevWord);
        turn[0]++;
        for (int i = 1; i < words.length; i++) {
            int person = i % n;
            turn[person]++;
            String word = words[i];
            if (set.contains(word) || word.charAt(0) != prevWord.charAt(prevWord.length() - 1)) {
                answer[0] = person + 1;
                answer[1] = turn[person];
                break;
            }
            set.add(word);
            prevWord = word;
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 3;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        System.out.println(solution(n, words));
    }
}
