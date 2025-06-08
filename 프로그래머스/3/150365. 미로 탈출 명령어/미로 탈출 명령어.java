import java.util.*;

class Solution {
    
    private static int[] dx = {1, 0, 0, -1};
    private static int[] dy = {0, -1, 1, 0};
    private static char[] dir = {'d', 'l', 'r', 'u'};

    private static String answer = "impossible";
    private static boolean found = false;

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        dfs(x, y, r, c, k, "", n, m);
        return answer;
    }

    private void dfs(int x, int y, int r, int c, int k, String path, int n, int m) {
        if (found) return;

        int dist = Math.abs(x - r) + Math.abs(y - c);
        if (dist > k || (k - dist) % 2 != 0) return;

        if (k == 0) {
            if (x == r && y == c) {
                answer = path;
                found = true;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx <= 0 || ny <= 0 || nx > n || ny > m) continue;

            dfs(nx, ny, r, c, k - 1, path + dir[i], n, m);
        }
    }
}