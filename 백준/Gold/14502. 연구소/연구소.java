import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int n, m;
    private static int[][] board;
    private static int result = 0;

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static class Pos {
        int x, y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 벽 세우기 시작
        dfs(0);
        System.out.println(result);
    }

    // 벽 3개를 세우는 조합 DFS
    private static void dfs(int depth) {
        if (depth == 3) {
            simulate(); // 바이러스 퍼뜨리고 안전영역 계산
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    board[i][j] = 1;
                    dfs(depth + 1);
                    board[i][j] = 0;
                }
            }
        }
    }

    // 바이러스 퍼뜨리고 안전 영역 개수 세기
    private static void simulate() {
        int[][] copy = new int[n][m];
        for (int i = 0; i < n; i++) {
            copy[i] = board[i].clone(); // 깊은 복사
        }

        Queue<Pos> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copy[i][j] == 2) {
                    q.add(new Pos(i, j));
                }
            }
        }

        // BFS로 바이러스 퍼뜨리기
        while (!q.isEmpty()) {
            Pos now = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = now.x + dx[dir];
                int ny = now.y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (copy[nx][ny] == 0) {
                    copy[nx][ny] = 2;
                    q.add(new Pos(nx, ny));
                }
            }
        }

        // 안전 영역 개수 세기
        int safe = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (copy[i][j] == 0)
                    safe++;

        result = Math.max(result, safe);
    }
}
