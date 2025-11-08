import java.util.*;

class Solution {

    private static int m, n;
    private static char[][] newBoard;
    private static Map<Character, List<int[]>> map;

    // 위, 아래, 왼, 오
    private static int[] dx = new int[]{-1, 1, 0, 0};
    private static int[] dy = new int[]{0, 0, -1, 1};

    private static class Pos {
        int x, y;
        int d;    // 방향
        int r;    // 꺾은 횟수

        Pos(int x, int y, int d, int r) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.r = r;
        }
    }

    public String solution(int m, int n, String[] board) {

        this.m = m;
        this.n = n;
        newBoard = new char[m][n];

        // 알파벳별 위치 2개 저장
        map = new TreeMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = board[i].charAt(j);
                newBoard[i][j] = c;

                if (!Character.isAlphabetic(c)) continue;

                map.putIfAbsent(c, new ArrayList<>());
                map.get(c).add(new int[]{i, j});
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!map.isEmpty()) {

            boolean removed = false;

            for (char c : new TreeSet<>(map.keySet())) {
                if (isPossible(c)) {
                    sb.append(c);
                    map.remove(c);
                    removed = true;
                    break;
                }
            }

            if (!removed) return "IMPOSSIBLE";
        }

        return sb.toString();
    }

    private static boolean isPossible(char c) {

        List<int[]> arr = map.get(c);
        int[] st = arr.get(0);
        int[] en = arr.get(1);

        // BFS
        Deque<Pos> dq = new ArrayDeque<>();
        boolean[][][][] visited = new boolean[m][n][4][2];

        // 시작점은 방향 없음(d = -1)
        dq.add(new Pos(st[0], st[1], -1, 0));

        while (!dq.isEmpty()) {

            Pos p = dq.poll();

            for (int k = 0; k < 4; k++) {

                int nx = p.x + dx[k];
                int ny = p.y + dy[k];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                if (newBoard[nx][ny] == '*') continue;

                int turn = isStraight(p.d, k) ? 0 : 1;
                int nr = p.r + turn;

                if (nr > 1) continue;  // 두 번 이상 꺾으면 불가

                if (p.d != -1) {
                    if (visited[nx][ny][k][nr]) continue;
                }

                // 목적지 도달
                if (nx == en[0] && ny == en[1]) {
                    newBoard[st[0]][st[1]] = '.';
                    newBoard[en[0]][en[1]] = '.';
                    return true;
                }

                // 빈 칸만 진행 가능
                if (newBoard[nx][ny] != '.') continue;

                visited[nx][ny][k][nr] = true;
                dq.add(new Pos(nx, ny, k, nr));
            }
        }

        return false;
    }

    // d = -1 은 시작점 → 꺾이지 않은 것으로 취급
    private static boolean isStraight(int d, int k) {
        if (d == -1) return true;
        if ((d == 0 || d == 1) && (k == 0 || k == 1)) return true;
        if ((d == 2 || d == 3) && (k == 2 || k == 3)) return true;
        return false;
    }
}
