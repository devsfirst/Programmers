import java.util.LinkedList;

class Main {

    static int finishR, finishC;
    static int min = Integer.MAX_VALUE;
    static int[] moveR = {1, 0, -1, 0};
    static int[] moveC = {0, 1, 0, -1};
    static boolean[][] visit;

    public static void main(String[] args) {
        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}};
        System.out.println(solution(maps));
    }

    public static int solution(int[][] maps) {
        int rowLength = maps.length;
        int colLength = maps[0].length;
        visit = new boolean[rowLength][colLength];
        finishR = rowLength - 1;
        finishC = colLength - 1;
        visit[0][0] = true;
        bfs(maps);
        if (min == Integer.MAX_VALUE) return -1;
        else return min;
    }

    private static void bfs(int[][] maps) {
        LinkedList<Node> linkedList = new LinkedList<>();
        linkedList.add(new Node(0, 0, 1));
        while (linkedList.size() != 0) {
            Node node = linkedList.remove();
            int r = node.r;
            int c = node.c;
            int move = node.move;
            if (r == finishR && c == finishC) {
                min = move;
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nr = r + moveR[d];
                int nc = c + moveC[d];
                if (nr < 0 || nr > finishR || nc < 0 || nc > finishC) continue;
                if (maps[nr][nc] == 0) continue;
                if (!visit[nr][nc]) {
                    visit[nr][nc] = true;
                    linkedList.add(new Node(nr, nc, move + 1));
                }
            }
        }
    }

    static class Node {
        int r, c, move;

        public Node(int r, int c, int move) {
            this.r = r;
            this.c = c;
            this.move = move;
        }
    }
}